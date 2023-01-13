package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {
    @Test
    public void fullPageScreenshotTest() throws IOException {
       //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        //1->Ekran goruntusunu getScreenShotAs methodu ile alip File olarak olusturalim
        File ts=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;

        //2->Almis oldugum ekran goruntusunu belirledigim bir path'e kaydet
        //kayit objesini dinamik yapmak icin date objesini kullandim
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);

        //3->goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(ts,hedef);
        //-“QA” aramasi yap
       driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("QA", Keys.ENTER);
       waitFor(3);
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
       String metinText= driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue("Search Results for: QA".contains(metinText));
        takeScreenShotOfPage();



    }
}
