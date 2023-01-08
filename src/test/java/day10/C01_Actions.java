package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu ");
        //Kutuya sag tıklayın
        Actions action = new Actions(driver);
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        action.contextClick(kutu).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
