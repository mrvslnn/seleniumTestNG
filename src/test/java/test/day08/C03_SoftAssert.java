package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {
//Yeni bir Class Olusturun : D11_SoftAssert1
//1.“https://www.hepsiburada.com/” Adresine gidin

//3.search kutusuna araba yazip arattirin
//4.bulunan sonuc sayisini yazdirin
//5.sonuc yazisinin "araba" icerdigini dogrulayin
//6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
@Test
public void test(){
        driver.get("https://www.hepsiburada.com/");
    //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    SoftAssert softAssert=new SoftAssert();

    softAssert.assertTrue(driver.getTitle().contains("Turkiye'nin En Buyuk Alisveris Sitesi"), "title istenen cumleyi icermiyor");
driver.findElement(By.xpath("//input[@class='desktopOldAutosuggesTheme-input']")).sendKeys("araba"+ Keys.ENTER);

   WebElement sonuc= driver.findElement(By.className("category-suggestion-title"));
    System.out.println(sonuc.getText());
    softAssert.assertTrue(sonuc.getText().contains("araba"));
    softAssert.assertFalse(sonuc.getText().contains("oto"));

    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }




}
