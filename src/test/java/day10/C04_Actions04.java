package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    @Test
    public void dragAndDropTest() {
      //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);
        Actions actions=new Actions(driver);
       WebElement kaynak= driver.findElement(By.id("draggable"));
       WebElement hedef=driver.findElement(By.id("droppable"));
       actions.dragAndDrop(kaynak, hedef).perform();

    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);
        Actions actions=new Actions(driver);
        WebElement kaynak= driver.findElement(By.id("draggable"));
        WebElement hedef=driver.findElement(By.id("droppable"));
        actions
                .clickAndHold(kaynak).//kaynagi tut
                moveToElement(hedef).//hedefe koy
                build().//onceki methodlarin iliskisini korur
                perform();

    }
    @Test
    public void moveByOffSetTest(){
//Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);
        Actions actions=new Actions(driver);
        WebElement kaynak= driver.findElement(By.id("draggable"));
        actions.clickAndHold(kaynak).moveByOffset(401,19).release().perform();
    }
}
