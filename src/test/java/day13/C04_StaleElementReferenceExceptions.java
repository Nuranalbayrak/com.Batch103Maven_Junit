package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceExceptions extends TestBase {
    /*
Stale Element = eski,kullanilamaz durumda, kullanima artik elverisli degil.
    -Sayfayi yenilediginizde refresh()
    -Sayfada back() veya forward() yaparsak
    COZUM:
   -> Elementi tekrar bulmak
 */

    @Test
    public void staleElementReferenceExceptionTest1() {

            driver.get("https://www.techproeducation.com");
            waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
            WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
            waitFor(5);
            lmsLoginLink.click();//LMS e git
            Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
            waitFor(5);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
            driver.navigate().back();//tekrar ana sayfaya gittik
            waitFor(5);
            lmsLoginLink.click();//LMS e git

        }
        @Test
        public void staleElementReferenceExceptionTest2 () {
            driver.get("https://www.techproeducation.com");
            waitFor(5);
            WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
            waitFor(5);
            driver.navigate().refresh();
            waitFor(5);
            lmsLoginLink.click();
        }
        //eleniumda aldigin 5 exception
    //Null pointer, no such element, time out, slale element reference, web driver
    //Genel olarak exception aldiginda bozum yolun nedir?
    //Hata mesajini oku
    //Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    //Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
    //Selniumda kullandigin waitler nelerdir>
    //Implicit yada explicit yada fluent
    //Hangi waiti tercih edersin?
    //Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.
    //Neden Explicit wait?
    //Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.
    //Senkronize(bekleme) problemlerini nasıl çözersin
    //Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim.
    // Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var. Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.
    }
//

