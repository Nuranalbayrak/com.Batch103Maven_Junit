package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownReusable {
    WebDriver driver;

    @Before
            public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //      Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        //        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //Reusable method:Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.
    public void selectFromDropdown(WebElement dropdown, String secenek) {
      List<WebElement> options=dropdown.findElements(By.tagName("option"));
        for (WebElement w:options) {
            if (w.getText().equals(secenek)){
                w.click();
                break;
            }
        }

    }
    @Test
    public void selectFromDropdown() {
        selectFromDropdown( driver.findElement(By.xpath("//select[@id='year']")),"2005");
    }
}
