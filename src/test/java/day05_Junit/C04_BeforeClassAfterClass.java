package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    /*
         @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
        Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
         */

    @BeforeClass
    public static void setup() {
        System.out.println("Butun Testlerden once calisti");

    }

    @Before
    public void setUp01() {
        System.out.println("her testten once calisir");
    }

    @After
    public void tearDown01() {
        System.out.println("her testten sonra calisir");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Butun testlerden sonra calisti.");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }

    @Test
    @Ignore
    public void test03() {
        System.out.println("ucuncu test");
    }
}
