package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAllert extends TestBase {
    //    3. butona tıklayın,
//    uyarıdaki metin kutusuna isminizi yazin,
//    OK butonuna tıklayın
//    ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    public void promptAllert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Nuran");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="Nuran";
        Assert.assertTrue(actualResult.contains(expectedResult));//You entered: Nuran" sonuc boyle oldugu icin equals kullanmak fail verir
    }
}
