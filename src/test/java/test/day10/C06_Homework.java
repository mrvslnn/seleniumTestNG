package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Homework extends TestBase {
    @Test
    public void test() throws InterruptedException {

//    1- https://www.facebook.com adresine gidelim
    driver.get("https://www.facebook.com");
//    2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
//    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement ad= driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        actions.clickAndHold(ad).perform();
        ad.sendKeys("merve");

        WebElement soyad= driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        actions.clickAndHold(soyad).perform();
        ad.sendKeys("aslan");

        WebElement mail= driver.findElement(By.id("password_step_input"));
        actions.clickAndHold(mail).perform();
        ad.sendKeys("merveaslan@gmail.com");

//4- Kaydol tusuna basalim
//      driver.findElement(By.xpath("//button[@type='submit'])[2]")).click();
}
}
