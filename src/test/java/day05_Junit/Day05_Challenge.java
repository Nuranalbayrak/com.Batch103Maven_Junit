package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day05_Challenge {


    static List<String> goruntulemeListesi = new ArrayList<>();
    static List<String> sepetListesi = new ArrayList<>();
    static List<WebElement> listNames;
    static List<WebElement> phonesNames;
    static List<WebElement> addToCart;

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");

//        ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

//        ~ get the brandName of phones
        phonesNames = driver.findElements(By.xpath("//div[@class='caption']"));

        getName(phonesNames, goruntulemeListesi);
        Thread.sleep(2000);

//        ~ click on add to button for all elements
        addToCart = driver.findElements(By.xpath("//*[text()='Add to Cart']"));

        allClick(addToCart);

//        ~ click on black total added cart button
        driver.findElement(By.id("cart-total")).click();

//        ~ get the names of list from the cart
        listNames = driver.findElements(By.cssSelector("td.text-left>a"));

        getName(listNames, sepetListesi);

//        ~ compare the names from displaying list and cart list
        compareTwoList(goruntulemeListesi, sepetListesi);


//        ~ close driver !

        Thread.sleep(2000);
        driver.close();
    }

    public static void compareTwoList(List<String> a, List<String> b) {
        System.out.println(goruntulemeListesi.equals(sepetListesi) ? "Listeler Ayn??" : "Listeler Farkl??");

    }

    public static void getName(List<WebElement> a, List<String> b) {

        for (WebElement y : a) {
            b.add(y.getText());
        }
        System.out.println(b);
    }

    public static void allClick(List<WebElement> a) throws InterruptedException {

        for (WebElement k : addToCart) {
            k.click();
            Thread.sleep(2000);
        }

    }
}
