package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {
//driver.switchto.window("gecmek istedigimiz sayfanın handle degeri")
//nutella aramasında 9.urunu tıklamak istesek asagıdaki kodla urunu bulamaz
    @Test
    public void test() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement arama= driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("nutella"+ Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@data-image-index='9']")).click();

    }
}
