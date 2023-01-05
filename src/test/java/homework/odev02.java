package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class odev02 extends TestBase {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        String window1Handle = driver.getWindowHandle();
       Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Click here a tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);//Burdaki eachHandle window2 handle ina esittir.
                break;
            }
        }

        Assert.assertEquals("New Window",driver.getTitle());



    }
}
