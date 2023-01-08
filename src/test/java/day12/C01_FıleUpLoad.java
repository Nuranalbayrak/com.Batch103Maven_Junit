package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FıleUpLoad extends TestBase {
    @Test
    public void test01() {
        //    Tests packagenin altina bir class oluşturun : C05_UploadFile
        //    https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //    chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        //    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";//yolunu sectik
        /*
        ChooseFileButton'una yuklemek istedigim dosyanin path'ini gondererek dosyayi sectim.
         */
        chooseFileButton.sendKeys(dosyaYolu);//dosyayi yolladik
        waitFor(5);

        //    Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();//dosyayi yukledik

        //    “File Uploaded!” textinin goruntulendigini test edelim.
        String textDogrula = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploaded!", textDogrula);
    }
}

