package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
//assertoın dogrulma 2seyın biribirine esit olup olmadugını test ediyoruz
//assetron failde olursa  sonraki kod lar calısmaz
//testng bunun icin bie cozum uretmis
//5test var 3dogru 2si yanlıs demesini istersek testng aradıgımız sey
//1den fazla assertion icin ideal bır test olur testng
//3asama var soft assertıon hard assertıon assert test
public class C02_SoftAssertion {
    // amazon sayfasina gidin
    // url'in amazon icerdigini test edin
    // title'in amazon icerdigini test edin
    // java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // title'in amazon icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        // java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(ilkUrun.getText().contains("Java"));
    }
    //burada failed bile olsa calısma devam eder
    //soft mu hard mı
    //testin icinde verification diyorsa soft
    //testin icinde assert edin test edin diyora hard kullanılır
    //assertall demezsek softasserion rapor etti ancak rapor vermedi
   //assertall ugorunceye kadar calsıır
    @Test
    public  void test(){
        SoftAssert softAssert=new SoftAssert();
        driver.get("https://www.amazon.com");
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"), "url amazon icemiyor");

        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
