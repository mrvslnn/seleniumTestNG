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

public class C02_Iframe {
    //bir web sitesi icerisindeki baska bir web isteisine denir
    //● Bir class olusturun: D12_IframeTest
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu
    // test edin ve konsolda
    //yazdirin.
    //○ Text Box’a “Merhaba Dunya!” yazin.
    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin

    WebDriver driver;
    String actualResult;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iframeTest() throws InterruptedException {
        WebElement bslık=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(bslık.isEnabled(), "baslık yazısı erısılebilir degil");
        System.out.println(bslık.getText());

        driver.switchTo().frame("mce_0_ifr");
        WebElement box= driver.findElement(By.xpath("//*[@id='tinyace']"));
        box.clear();
        box.sendKeys("merhaba dunya");
        //nosuchelement aldık yazı kutusnu bulamadık dedi
        // eger webelementimizin parenti bir iframe ise
        //once switchto diyerek o iframe gitmeliyiz
        //iframe e index ile gecebilirz eger
        // bir id varsa name i varsa
        //webelement olarak loceate edebiliriz
// iframe’den cikmak icin switchTo().parentFrame veya defaultFrame yazmaliyiz.
WebElement elememntalLinki=driver.findElement(By.linkText("Elemental Selenium"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(elememntalLinki.isDisplayed());
        softAssert.assertAll();
        System.out.println(elememntalLinki.getText());


    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }


}