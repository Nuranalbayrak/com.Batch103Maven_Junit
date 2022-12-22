package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ClassWork3 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }
    @After
    public void tearDown()  {
        driver.close();
    }

    @Test
    public void test01() {
        //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

        //=> Sayfa başlığının “Amazon” oldugunu test edin
        String actualTittle=driver.getTitle();
        String expectedTittle="Amazon";
        Assert.assertTrue(actualTittle.contains(expectedTittle));
    }

    @Test
    public void test02() {
        //=> amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resimGoruntusu = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(resimGoruntusu.isDisplayed());
    }

    @Test
    public void test03() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
        String wrongTitle = driver.getTitle();
        Assert.assertFalse(wrongTitle.contains("amazon"));
    }

}
