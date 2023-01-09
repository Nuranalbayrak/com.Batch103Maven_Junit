package homework;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Odev03 extends TestBase {
    @Test
    public void test01() {
        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement allDropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(allDropDownMenu);
        List<WebElement> allOptıons = select.getOptions();
        allOptıons.stream().forEach(t -> System.out.println(t.getText()));
        Assert.assertTrue(allOptıons.size() == 28);

        //dropdown menude 40 eleman olduğunu doğrulayın
    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement elektronik = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(elektronik);
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String[] arr = driver.findElement(By.xpath("//*[.='1-24 of over 7,000 results for']")).getText().split(" ");
        System.out.println("Results==>" + arr[3]);
        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String title = driver.getTitle();

        String price = driver.findElement(By.xpath("//div[@class='a-section a-spacing-micro']")).getText().substring(0, 3);
        System.out.print("Price==>" + price);

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }

    @Test
    public void test03() {
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //dropdown’dan bebek bölümüne secin
        WebElement baby = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select01 = new Select(baby);
        select01.selectByVisibleText("Baby");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bebek puset" + Keys.ENTER);

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        String[] aramaSonucu = driver.findElement(By.xpath("//*[.='1-16 of 22 results for']")).getText().split(" ");
        System.out.println("arama sonucu=" + aramaSonucu[2]);

        //sonuç yazsının puset içerdiğini test edin
        String actualresult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualresult.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//img[@data-image-index='3']")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title01 = driver.getTitle();
        String price = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]")).getText().substring(0, 3);
        System.out.println(price);
        driver.findElement(By.id("add-to-cart-button")).click();

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.xpath("//div[@id='nav-cart-text-container']")).click();
        String sepettekiurun = driver.findElement(By.xpath("//p[@class='a-spacing-mini']")).getText();
        //Assert.assertTrue(sepettekiurun.contains(title01));
        String sepettekiUrunFiyati = driver.findElement(By.xpath("//p[@class='a-spacing-mini']")).getText().substring(0, 3);
        Assert.assertEquals(price, sepettekiUrunFiyati);


    }


}
