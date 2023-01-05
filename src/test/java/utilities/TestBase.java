package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //Testbase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyoruz.
    //amac bu sinifi extend etmek ve icindeki hazir metodlari kulllanmak

        //    driver objesini olustur. Driver ya public yada protected olmali. Sebepi child classlarda gorulebilir olmasi
        protected static WebDriver driver;

        //    setUp
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        //teardown
    @After
    public void teardown() throws InterruptedException {
            driver.quit();

    }
    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
    //windowNumber sıfır (0)'dan başlıyor.
    //index numarasini parametre alir
    //ve o indextekipencereye gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        //tum pencereleri bir liste koyuyoruz sonra bizim verdigimiz indexteki
        //pencereye gecis yapiyor.
        driver.switchTo().window(list.get(windowNumber));
    }
    /*   HARD WAIT:
    @param : second
*/
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
