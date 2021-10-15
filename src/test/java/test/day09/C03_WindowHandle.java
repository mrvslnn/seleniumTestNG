package test.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandle {
    public class C04_WindowHandle extends TestBase {
        WebDriver driver;

        @Test
        public void test() {
            // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
            //● https://the-internet.herokuapp.com/windows adresine gidin.

            driver.get("https://the-internet.herokuapp.com/windows");
            //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            String actualYazi = driver.findElement(By.tagName("h3")).getText();
            String expectedYazi = "Opening a new window";
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualYazi, expectedYazi, "yazi istendigi gibi degil");
            //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            String actualTitle = driver.getTitle();
            String expectedTitle = "The Internet";
            softAssert.assertEquals(actualTitle, expectedTitle, "title istenen degerden farkli");

            System.out.println("ilk sayfanın handle degeri "+driver.getWindowHandle());

            //● Click Here butonuna basın.
            driver.findElement(By.linkText("Click Here")).click();
            Set<String> tumWindowHandles=driver.getWindowHandles();
            System.out.println("tum handles "+tumWindowHandles);
            //window handle ederken ilk adım o sayfanın handle degerini alıp bir stringe atamak
// cx xc

            String ilkhandle= driver.getWindowHandle();
            //ikinci adım iki sayfa acıldıgında her iki sayfanın handle degerkeini koymk icin bir
            //set olusturup handles methodu ile b u degerleri elde etmek
            //ucuncu adım set ıcerisinde 1.sayfanın handle degerine esit olmayan hndle degerini bulup bir stringe atmak
            String ikincihandle="";
            for (String each : tumWindowHandles
                 ) {
                if (each.equals(ilkhandle)){
                    ikincihandle=each;
                }
            }
            System.out.println(ikincihandle);

            //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            driver.switchTo().window(ikincihandle);

            String actualYeniTitle = driver.getTitle();
            String expectedYeniTitle = "New Window";
            softAssert.assertEquals(actualYeniTitle, expectedYeniTitle, "yeni sayfanin title'i yanlis");

            //● Sayfadaki textin “New Window” olduğunu doğrulayın.
            WebElement yenisahife=driver.findElement(By.tagName("h3"));
            String expectedYeni="";
            String actualYeni=yenisahife.getText();
            softAssert.assertEquals(actualYeni,expectedYeni,"yeni sayafadaki yazı bekeleneden farklı");

            //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
            driver.switchTo().window(ilkhandle);
            actualTitle= driver.getTitle();
            softAssert.assertAll();

        }
    }
}