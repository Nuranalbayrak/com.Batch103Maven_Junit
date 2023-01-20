package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void typeTest() {
        //	2)Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        //	3)Arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");

    }
}
