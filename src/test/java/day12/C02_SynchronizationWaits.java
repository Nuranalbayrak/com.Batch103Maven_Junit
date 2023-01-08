package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_SynchronizationWaits extends TestBase {
    //impicitly wait : Sayfa üzerindeki tüm öğeler için zaman aşımı
    //explicitly wait  : belirli elementler için zaman aşımı

    @Test
    public void explicitWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloWorldElement.getText());
//        //1.WaitDriverWait objesini olustur.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        //2.wait objesini kullanarak bekleme problemini cozmeye calis
       WebElement helloWorldElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
       String helloWorldText=helloWorldElement.getText();
       Assert.assertEquals("Hello World!", helloWorldText);

    }
}
