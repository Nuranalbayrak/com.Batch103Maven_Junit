package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class Day05_Challenge {
    static List<WebElement> allButon;
    /*
    ~
    ~
    ~
    ~
    ~
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        if (driver.getTitle().equalsIgnoreCase("Your Store")){
            System.out.println("Tıttle testi Passed");
        }else System.out.println("Tittle testi Failed");
        // click on Phones & PDAs
        driver.findElement(By.xpath("//*[@href='http://tutorialsninja.com/demo/index.php?route=product/category&path=24']")).click();
        //get the brandName of phones
        List<WebElement> brandName=driver.findElements(By.xpath("//h4"));
        for (WebElement w: brandName) {
            System.out.println(w.getText());
        }

        //click on add to button for all elements
       allButon=driver.findElements(By.xpath("//*[text()='Add to Cart"));

        // click on black total added cart button
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();




    }
}
