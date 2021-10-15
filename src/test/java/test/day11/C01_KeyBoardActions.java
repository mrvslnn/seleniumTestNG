package test.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyBoardActions extends TestBase {
//1- Bir Class olusturalim C01_KeyboardActions1
//2- https://www.amazon.com sayfasina gidelim
//3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin
// ve Enter’a basarak arama yaptirin
//4- aramanin gerceklestigini test edin
@Test
    public void test(){
    driver.get("https://www.amazon.com");
    WebElement box=driver.findElement(By.id("twotabsearchtextbox"));
    Actions actions=new Actions(driver);
    actions.click(box).perform();
    actions.sendKeys("samsung ").perform();
    actions.keyDown(Keys.SHIFT).perform();
    actions.sendKeys("a").perform();
    actions.keyUp(Keys.SHIFT).perform();
    actions.sendKeys("71").perform();
    actions.sendKeys(Keys.ENTER).perform();
String aranan="samsung A71";
String actualTitle= driver.getTitle();
    Assert.assertTrue(actualTitle.contains(aranan),"arama yapılamadı");
}
}
