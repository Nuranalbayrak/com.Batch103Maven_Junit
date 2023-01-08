package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    @Test
    public void scrollUpDown() {
        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        waitFor(2);
        //Sayfanin altına doğru gidelim
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
         action.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
         action.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);

        //Sonra sayfanın üstüne doğru gidelim
        action.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        action.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        action.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);


    }
}
