package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C05_Iframe extends TestBase {


    @Test
    public void testIframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
       String actualResult= driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
       String expectedResult="black border:";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String icmetin=driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedtext1="Applications lists";
        Assert.assertTrue(icmetin.contains(expectedtext1));
        driver.switchTo().parentFrame();

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
       String text2= driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(text2);
       String expectedText="Povered By";
       Assert.assertTrue(text2.contains(expectedText));



    }
    /*
    INTERWIEV SORULARI
    1)how do you find the number of iframe on a page?(bir sayfadaki toplam iframe sayisini nasil buluruz
    -iframe'ler iframe tagi kullanilartak olusuturulur. bu durumda find element by frame locatorini kullanarak tum iframeleri bulurum.
    -->driver.findElements(By.tagName("iframe")
    -->driver.findElements(By.xpath("//iframe"))
    2)Explain how you can switch back from a main page? (tekrar anasayfaya nasil donersin?)
    -->2 farkli yol vardir "DefaultContent ya da parentFrame metodlarini kullanarak gecis yapabiliriz.
    ------------------------------------------------
    peki bunlarin aralarindaki fark nedir?
   -- oncelikle her ikiside frame'in disina cikmamizi saglar. defaultContetent anasayfaya direk atlatir, parentFrame ise
   bir ust sayfaya atlatir.

    3)What might be the reason for your test case to fail? (bir test case'in fail etme sebepleri neler olabilir?)
    -yanlis locater(tekrar elementi locate etmeliyiz,degisken element varsa ona gore dynamic bir xpath yazariz)
    -wait/syscroniztion hatalari(implicit waitte yeterli sure oldugundan emin oluruz.o sureyi artirabiliriz.30 sn verilebilir. Explicit wait kullanilabilir.)
    -iframe(switchTo. iframe)
    -alert(switchTo.alert)
    -new window(switch to window)
     */
}
