package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookies() {
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);
        //1.toplam cookie sayisini bul
      Set<Cookie> allCookies=driver.manage().getCookies();
        System.out.println("Cookies sayisi==>"+allCookies.size());
        allCookies.stream().forEach(t -> System.out.println(t.getName()));
        //for (Cookie w : allCookies) {
        //    System.out.println(w.getName());}
        //3. Bir Cookie yi ismiyle bul
        System.out.println(driver.manage().getCookieNamed("skin"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookie=new Cookie("cikolatam","antep-Fistikli-Cikolata");
        driver.manage().addCookie(favoriCookie);
        waitFor(3);
        System.out.println(driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("cikolatam");
        System.out.println(driver.manage().getCookies().size());
        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println(driver.manage().getCookies().size());
    }
}
