package test.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist{
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));
        //C:\Users\melek\Desktop\picture.jpg
    //masauntundeki bir dosya yolunun sorunsuz calısması ıcın dosya yolunu ikiye ayıracagız
        //herkesin pc de farklı olan kısım
        //bukısmı pc den kodu ıle alabiliiz
        //2.herke sicin aynı olan kısım bu kısım 1.maddedeki yolun deamı seklinde olur
        //ornek
        //masausutmuzdeki picture dosyası ıcın yol kaydedelim
        String dosya=System.getProperty("user.home")+"\\Dekstop\\picture.jpg";
        System.out.println(dosya);
        System.out.println(Files.exists(Paths.get(dosya)));
        Assert.assertTrue(Files.exists(Paths.get(dosya)));

        System.out.println(System.getProperty("user.dir"));
    }
}
