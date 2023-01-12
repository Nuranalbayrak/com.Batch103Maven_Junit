package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest(){
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//img[@id='NDU1Ojc5Q==-1']"));

    }

}

    //Interview Questions
    //Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
    //What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
    /*NoSuchElementException
            TimeOutException
    NullPointerException
            InvalidSelectorException
    StaleElementReferenceException
            InvalidElementStateException
    WebDriverException
            ElementNotInteractableException
    ElementClickInterceptedException
            InvalidArgumentException
    JavascriptException
            RemoteDriverServerException
            */
//NoSuchElementException:
//Yanlis locator
//Popup, yeni pencere, iframe,…
//Sayfa dolmada problemler ve yavaslamalar
//Sakli olan elementler
//Solution:
//Locatorin dogrulugunu tekrar kontrol et
//Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
//Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada fluent wait kullaniri
    //What is your solution?-Cozum ne?

    //What type of waits do you use?- Hangi resit wait kullanirsin?
    //Which wait do you prefer?- Hangi wait tercih edersin?
    //Why do you prefer that wait?- Neden onu tercih edersin?
    //How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?
    //

