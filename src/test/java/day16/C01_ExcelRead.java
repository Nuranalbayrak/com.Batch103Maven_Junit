package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws IOException {
        //WORKBOOK (EXCELL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW >CELL
        String path = "./src/test/java/resources/Capitals.xlsx";

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCELL DOSYASINI AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //SAYFAYI AC
        Sheet sheet01 = workbook.getSheet("Sheet1");

        //ILK SATIRA GIDELIM
        Row row1 = sheet01.getRow(0);
        //ILK SATIRDAKI ILK VERIYI AL
        Cell cell01 = row1.getCell(0);
        //O VERIYI YAZDIR
        System.out.println(cell01);

        //1. SATIR 2. SUTUN
        Cell cell12 = sheet01.getRow(0).getCell(1);
        System.out.println(cell12);

        //3.SATIR 1. SUTUN yazdir ve o verinin France oldugunu test et
        String cell31 = sheet01.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France", cell31);

        //Exceldeki toplam satir sayisini bul
        int toplamSatirSayisi = sheet01.getLastRowNum() + 1;//son satir sayisi.index sifirdan basladigi icin bir ekleriz.
        System.out.println(toplamSatirSayisi);

        //Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet01.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1'den baslar.

        //CONTRY ,CAPITALS key ve valueleri map a alip print et

        //Variable olusturalim. bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country=sheet01.getRow(satirSayisi).getCell(0).toString();
            String capital=sheet01.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);

        }
        System.out.println(ulkeBaskentleri);




    }
}
