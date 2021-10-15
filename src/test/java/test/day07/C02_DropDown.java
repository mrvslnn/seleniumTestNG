package test.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class C02_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    @Test
    public void option1() {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown1 = driver.findElement(By.id("dropdown"));

//  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select options = new Select(dropDown1);
        options.selectByIndex(1);
        options.selectByVisibleText("Option 1");
    }

    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test(priority = 2)
    public void option2 () {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown2 = driver.findElement(By.id("dropdown"));
        Select options2 = new Select(dropDown2);
        options2.selectByValue("2");

    }
    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void option3() {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown1 = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown1);
        options.selectByIndex(1);

        options.selectByVisibleText("Option 1");
    }
    //    4.Tüm dropdown değerleri(value) yazdırın
    @Test
    public void dropdownList(){

        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown1 = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown1);
        List<WebElement> dropdownList= options.getOptions();

//    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        for (WebElement s:dropdownList) {

            System.out.println(s.getText());
        }

        System.out.println(dropdownList.size());// eleman sayısı icin boyutu

        Assert.assertNotEquals(dropdownList, 4);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }


}
