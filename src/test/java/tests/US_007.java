package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_007_Hotellist_Guncelleme;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_007 {
    US_007_Hotellist_Guncelleme hotelBilgileriGuncelle=new US_007_Hotellist_Guncelleme();
    @BeforeClass
    public void setup() {
        //Setup methodu Hotellist bolumune kadar çalışmaktadır.
        //login methodu ile sayfaya giriş yapılmıştır.
        hotelBilgileriGuncelle.loginMethodu();
        hotelBilgileriGuncelle.hotelManagement.click();
        hotelBilgileriGuncelle.HotelListsekmesi.click();


    }

    @Test //Hotel Sitesinde Code sekmesi değiştirilebilir olmalı
    public void us007_tc_001() throws InterruptedException {

        hotelBilgileriGuncelle.hotelListPages(); //Bu bolumde hotellist sayfasında random olarak bir details butonu seçilmektedir.
                                                    //istenen hotele ait sayfa gelmektedir.
        hotelBilgileriGuncelle.codesekmesi.clear();
        hotelBilgileriGuncelle.codesekmesi.sendKeys(ConfigReader.getProperty("US007_new_hotel_code"));
        hotelBilgileriGuncelle.savebuttonu.click();
        Thread.sleep(7000);
        Assert.assertTrue(hotelBilgileriGuncelle.succesfullytext.isDisplayed());
        System.out.println("Tebrikler başarılı kayıt oluşturuldu");

        hotelBilgileriGuncelle.okbutonu.click();
        hotelBilgileriGuncelle.HotelListsekmesi.click();

    }

    @Test //Kullanici Hotel ismini duzeltilebilmeli ve degistirebilmeli
    public void us007_tc_002 () throws InterruptedException {
        hotelBilgileriGuncelle.hotelListPages(); //tekrar random bir hotel saçilmektedir.
        hotelBilgileriGuncelle.namesekmesi.clear();
        hotelBilgileriGuncelle.namesekmesi.sendKeys(ConfigReader.getProperty("US007_new_hotel_name"));
        hotelBilgileriGuncelle.savebuttonu.click();
        Thread.sleep(7000);
        Assert.assertTrue(hotelBilgileriGuncelle.succesfullytext.isDisplayed());
        System.out.println("Tebrikler başarılı kayıt oluşturuldu");
        hotelBilgileriGuncelle.okbutonu.click();
        hotelBilgileriGuncelle.HotelListsekmesi.click();
    }

    @Test //Kullanici Adress bilgilerini duzeltilebilmeli ve degistirebilmeli (Actions kullanılarak yapıldı.)

    public void us007_tc_003 () throws InterruptedException {
        hotelBilgileriGuncelle.hotelListPages();
        Actions action=new Actions(Driver.getDriver());
        action.click(hotelBilgileriGuncelle.namesekmesi).sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("US007_new_hotel_adress"),Keys.ENTER).perform();
       // hotelBilgileriGuncelle.namesekmesi.click();

        Thread.sleep(7000);
        Assert.assertTrue(hotelBilgileriGuncelle.succesfullytext.isDisplayed());
        System.out.println("Tebrikler başarılı kayıt oluşturuldu");
        hotelBilgileriGuncelle.okbutonu.click();
        hotelBilgileriGuncelle.HotelListsekmesi.click();
        Driver.closeDriver();
    }
}
