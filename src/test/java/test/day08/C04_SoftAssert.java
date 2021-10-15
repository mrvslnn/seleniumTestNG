package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//        1. “http://zero.webappsecurity.com/” Adresine gidin
//        2. Sign in butonuna basin
//        3. Login kutusuna “username” yazin
//        4. Password kutusuna “password.” yazin
//        5. Sign in tusuna basin
//        6. Pay Bills sayfasina gidin
//        7. “Purchase Foreign Currency” tusuna basin
//        8. “Currency” drop down menusunden Eurozone’u secin
//        9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
//        10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select
//        One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
//        (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
//        (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
//        (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (bah
public class C04_SoftAssert {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
@Test
public  void test(){
        driver.get("https://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
}



    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
