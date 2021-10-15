package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    //handle alert =>cıkan uyarılarda sag clıkc calısmazsa
    //alert ler js ile yapılmıssa inspect yapılmaz
    //uzerine gelip sag clıck ile incele cıkıyorsa html dir
    //js ile napacagımıza bakacagız
    //3cesit js alert kullanacagız
    //switchTo() gecis yaptırır driver i alerte gecis yaptirır
    //accept ile kabul ederiz
    //dismiss ile kabul temeyız
    //gettext text i alırız
    //sendkeys ile yollayıp keys leriz


//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//            ● Bir metod olusturun: acceptAlert
//○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//“You successfully clicked an alert” oldugunu test edin.
//● Bir metod olusturun: dismissAlert
//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin.
//● Bir metod olusturun: sendKeysAlert
//○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın

    WebDriver driver;
    String actualResult;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public  void acceptAlert(){
driver.findElement(By.xpath("//button[@" +
        "onclick='jsAlert()']")).click();
driver.switchTo().alert().accept();
        WebElement result=driver.findElement(By.id("result"));
        String expectedResult="You successfully clicked an alert";
        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult,"sonuc yazısı ıstenen ile aynı degıl");


    }
    @Test
    public void dismissAlert(){
    driver.findElement(By.xpath("//*[text()='Click for JS confirm']")).click();
    driver.switchTo().alert().accept();
    String istenmeyen="succesflly";
        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
    Assert.assertFalse(actualResult.contains(istenmeyen));
    }
@Test
public void sendKeysAlert(){
driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
String isim="mehet";
driver.switchTo().alert().sendKeys(isim);
driver.switchTo().alert().accept();
    WebElement result=driver.findElement(By.id("result"));
    String actualResult=result.getText();
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(actualResult.contains(isim));
    softAssert.assertAll();


}


    @AfterClass
    public void tearDown(){
        //driver.close();
    }


}
