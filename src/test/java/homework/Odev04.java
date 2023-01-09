package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev04 extends TestBase {
//Bir Class olusturalim KeyboardActions2

    @Test
    public void KeyboardActions2() {
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //video’yu gorecek kadar asagi inin
        WebElement iframe=driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        //videoyu izlemek icin Play tusuna basin
       WebElement play= driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
               play.click();
        //videoyu calistirdiginizi tes


    }
}
