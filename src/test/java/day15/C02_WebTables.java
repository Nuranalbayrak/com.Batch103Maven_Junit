package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

    @Test
    public void table1Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
      String table01=  driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI==>"+table01);
      List<WebElement> tumVeriler=  driver.findElements(By.xpath("//table[@id='table1']//td"));
        tumVeriler.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void row3Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.stream().forEach(veri-> System.out.println(veri.getText()));

    }

    @Test
    public void sonSutunVerileri() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonsutunElemenalri = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonsutunElemenalri.stream().forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sutun5() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));
    }


    //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
    public void printData(int satir, int sutun){
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }
    @Test
    public void printDataTest(){
        printData(2,3);


    }
}
