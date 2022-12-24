package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
//Eger test sinifinda birden fazla method olusturulmussa before kullanilir.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //      Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        //        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){
        //1.Locate dropdown element
       WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
       WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
       WebElement day= driver.findElement(By.xpath("//select[@id='day']"));
       //2.Select objesi olustur.
        Select select=new Select(year);
        //3. Select objesini kullanarak 3 farkli sekilde secim yapoabiliriz
        select.selectByIndex(22);//SECENEK SIRASI 0'dan baslar. 2000 yili 23.sirada
        //ay secimi
        Select select1=new Select(month);
        select1.selectByValue("0");
        //gun secimi
        Select select2=new Select(day);
        select2.selectByVisibleText("10");

    }
    @Test
    public void printAllTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //eyalet isimlerini konsala yazdir.
       WebElement state= driver.findElement(By.xpath("//select[@id='state']"));
       Select stateDropDown=new Select(state);
       List<WebElement> stateList= stateDropDown.getOptions();
//        for (WebElement w:stateList) {
//            System.out.println(w.getText());
//        }
        stateList.stream().forEach(t-> System.out.println(t.getText()));
    }
    @Test
    public void getSelectedOptionsTest(){

        //state dropdown'indaki varsayilan secili secenegi select a state oldugunu verify edelim.
        WebElement state= driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown=new Select(state);
        String varSayilanText= stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", varSayilanText);

    }

    /*
    INTERWIEV QUESTIONS
        1. What is dropdown? Dropdown nedir?
        Dropdown liste olusturmak icin kullanilir.
        2. How to handle dropdown elements? Dropdown nasil automate edilir?
        -Dropdown'i Locate ederiz
        -Select objecti'i olustururum
        -Select objecti'i ile istedigim secenegi secerim
        NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi
       3.Tum dropdown seceneklerini nasil konsolda yazdiririz?
       -tum dropdown elementlerini getOptions() methodu ile listeye koyariz sonra secenkelri lopp ole yazdirabilirz.
       4.Bir secenegin secili oldugunu automate etmek icin ne yapilir?
       Ornek: gun olarak 10 sectik ama ya tiklanmadiysa?
       getFirstSelectedOption() secili olan secenegi return eder.
     */
   @After
    public void tearDown() {
       driver.close();
   }



}
