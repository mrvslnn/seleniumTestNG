package test.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {
    // beforemethod ve aftermethod un toplam test saysisinca calsitigina dikkat et
    // once prioritysizler calisir...sonra priorityliler kucukten buyuge calisir
    //3 test methodu olusturun
    //1. amazona agitsin
    //2. techproeducationsa
    //3. ude facebook anasayfaya gitsin
    //ve sayfa title larını yazdırsın
    WebDriver driver;
@BeforeMethod
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
@Test
public void amazon(){
    driver.get("https://www.amazon.com");
    System.out.println(driver.getTitle());
}

    @Test
    public void tecpro() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }


    @Test
    public void facebook() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());


    }

    @AfterMethod
    public  void yearDown(){
    driver.close();
}
}
