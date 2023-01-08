package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev06 extends TestBase {
    //Faker Kutuphanesi HOMEWORK
//Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.

    @Test
    public void test01() {
        Faker faker = new Faker();
        String day = String.valueOf(faker.number().numberBetween(1, 31));
        String month = String.valueOf(faker.number().numberBetween(1, 12));
        String year = String.valueOf(faker.number().numberBetween(1800, 2022));
        String email=faker.internet().emailAddress();


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']")).click();

        //“firstName” giris kutusuna bir isim yazin
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());

        //“surname” giris kutusuna bir soyisim yazin
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

        //“email” giris kutusuna bir email yazin
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        //“email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
        //Bir sifre girin
        driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());

        //Tarih icin gun secin
        driver.findElement(By.id("day")).sendKeys(day);

        //Tarih icin ay secin
        driver.findElement(By.id("month")).sendKeys(month);

        //Tarih icin yil secin
        driver.findElement(By.id("year")).sendKeys(year);

        //Cinsiyeti secin
        driver.findElement(By.xpath("//input[@value='1']")).click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='-1']")).isSelected());

        //Sayfayi kapatin
    }
}
