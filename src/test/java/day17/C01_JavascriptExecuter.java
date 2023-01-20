package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JavascriptExecuter extends TestBase {
    //Excel Okuma
    //Excelden veriyi okumak icin hangi sırayla gitmem gerekir
    //workbook > sheet > row > cell
    //Bir exceldeki top satir sayısı nasıl bulunur?
    //getLastROwNumber
    //Yada
    //getPhysicalNumberOfRows- toplam kullanılan satir sayısı
    //Excel Yazdırma
    //Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
    //Su anki projende exceli nasil kullandin?
    //Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz.
    // Bu datalari test caselerde kullanmak icin excelden çekiyorum ve test caselerimde kullanıyorum.
    //Datalari excelde tutmanı faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.


    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://www.techproeducation.com");
        waitFor(3);
//        1. Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));
        waitFor(3);
//        2. JS executor objesi olustur
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        3. Yapmak istedigim islemi js.executeScript metot u ile yap
//        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir
//        arguments[0] ILK PARAMETREDEKI ELEMENT
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);
//        sayfa goruntusunu al
        takeScreenShotOfPage();
//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();
//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();
//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();
        //en uste git
        scrollTopJS();
        waitFor(3);

        //en alta git
        scrollEndJS();
        waitFor(3);


    }
}
