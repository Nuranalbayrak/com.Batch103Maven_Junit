package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev05 extends TestBase {
    @Test
    public void  ActionsClass() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");
        // "Hover over Me First" kutusunun ustune gelin
        //Link 1" e tiklayin
        Actions actions=new Actions(driver);
        WebElement hoverFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverFirst).perform();
        driver.findElement(By.linkText("Link 1")).click();

        //Popup mesajini yazdirin
        System.out.println("Popup mesaji==> = " + driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun

        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("clickAndHold.getText() = " + clickAndHold.getText());
        //8- “Double click me" butonunu cift tiklayin
       WebElement doubleClick= driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();

    }
}
