package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_005_Hotel_Ekleme;
import pages.US_008_Positif_Hotel_Guncelleme;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
public class US_008 {
    US_008_Positif_Hotel_Guncelleme MusteriBilgileriGuncelleme=new US_008_Positif_Hotel_Guncelleme();

    @BeforeClass
    public void setup() { //Us_TC_001    ve Us_TC_002  de  icerir

        MusteriBilgileriGuncelleme.loginMethodu();
        MusteriBilgileriGuncelleme.Managementsekmesi.click();
        MusteriBilgileriGuncelleme.HotelListsekmesi.click();
    }

    @Test
    public void Us_TC_003() throws InterruptedException {
        MusteriBilgileriGuncelleme.hotelListPages();
        MusteriBilgileriGuncelleme.PhoneSekmesi.clear();
        MusteriBilgileriGuncelleme.PhoneSekmesi.sendKeys(ConfigReader.getProperty("US008_new_phone"));
        MusteriBilgileriGuncelleme.savebuttonu.click();
        Thread.sleep(7000);
        Assert.assertTrue(MusteriBilgileriGuncelleme.succesfullytext.isDisplayed());
        MusteriBilgileriGuncelleme.okbutonu.click();
        MusteriBilgileriGuncelleme.HotelListsekmesi.click();
    }
    @Test
    public void Us_TC_004 () throws InterruptedException {
        MusteriBilgileriGuncelleme.hotelListPages();
        MusteriBilgileriGuncelleme.EmailSekmesi.clear();
        MusteriBilgileriGuncelleme.EmailSekmesi.sendKeys(ConfigReader.getProperty("US008_new_email"));
        MusteriBilgileriGuncelleme.savebuttonu.click();
        Thread.sleep(7000);
        Assert.assertTrue(MusteriBilgileriGuncelleme.succesfullytext.isDisplayed());
        MusteriBilgileriGuncelleme.okbutonu.click();
        MusteriBilgileriGuncelleme.HotelListsekmesi.click();
    }
    @Test
    public void Us_TC_005 () throws InterruptedException {
        MusteriBilgileriGuncelleme.hotelListPages();
        MusteriBilgileriGuncelleme.Group1.click();
        MusteriBilgileriGuncelleme.savebuttonu.click();
        Thread.sleep(7000);
        Assert.assertTrue(MusteriBilgileriGuncelleme.succesfullytext.isDisplayed());
        MusteriBilgileriGuncelleme.okbutonu.click();
        MusteriBilgileriGuncelleme.HotelListsekmesi.click();
    }
    @Test
    public void Us_TC_006 () throws InterruptedException {
        MusteriBilgileriGuncelleme.hotelListPages();
        MusteriBilgileriGuncelleme.DeleteSekmesi.click();
        MusteriBilgileriGuncelleme.DevammiText.click();
        Thread.sleep(7000);
        Assert.assertTrue(MusteriBilgileriGuncelleme.TamamText.isDisplayed());
    }
}
