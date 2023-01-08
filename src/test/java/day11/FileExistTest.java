package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistTest {
    @Test
    public void isExist() {
        //Masa ustunden bir dosyanın varligini test et
        String userDir=System.getProperty("user.dir");
        System.out.println(userDir);
        String userHome=System.getProperty("user.home");
        System.out.println(userHome);
        String dosyaYolu=userHome+"/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);
       boolean isExists= Files.exists(Paths.get(dosyaYolu));
       Assert.assertTrue(isExists);
        /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */



    }
}
