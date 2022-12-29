package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacagimiz metotlari ya da claslari koydugumuz paketin adidir.
        -TestBase
        -Driver
        -ExcelUtil
        -Configuration
     -utulities paketinde test caseler yazilmaz
     -sadece tekrar kullanilabilecek destek siniflari (support class)olusturulur.
     -Bu support classlar test caselerin yazilmasini hizlandirir.
     */
    @Test
    public void test01(){
        //techproeducation anasayfasina git ve tittlein Bootcamps kelimesini icerdigini test et
        driver.get("https://www.techproeducation.com");
        String pageTittle= driver.getTitle();
        Assert.assertTrue(pageTittle.contains("Bootcamps"));
    }

}
