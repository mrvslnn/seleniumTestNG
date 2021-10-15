package test.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03 {
// ● Bir class oluşturun: DependsOnTest
//● https://www.amazon.com/ adresine gidin.
//1. Test : amazon ana sayfaya gittiginizi test edin
//2. Test : 1.Test basarili ise search Box’i kullanarak
// “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
//3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve
// fiyatinin $16.83 oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1() {
        driver.navigate().to("https://www.amazon.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/","amazon degil");
    }
//iki testi bagladıgımızda eger 1.test failed olursa 2.testi ignore eder
    @Test(dependsOnMethods = "test1")
    public void test2() {
        WebElement aramaKutusu = driver.findElement(By.id("twosearchtextbox"));
    aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
    Assert.assertTrue(driver.getTitle().contains("nutella"),"nutella sizin icin arama yapamıyor");

    }
    //eger uc test bu sekılde baglanduysa ucuncuyu calsıtırmak ıstedgımızde
    //zıncır reactıon calısıp 1ye gıtmez
    @Test(dependsOnMethods = "test2")
    public void test3() {
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    WebElement fiyat= driver.findElement(By.xpath("[@class='a-size-base a-color-price']"));
        System.out.println(fiyat.getText());
        Assert.assertEquals(fiyat.getText(),"126.56$" );
    }


    @AfterMethod
    public void tearDown(){
        driver.close();

    }


}
