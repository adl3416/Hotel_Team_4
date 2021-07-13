package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_008_Positif_Hotel_Guncelleme;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_008 {
    US_008_Positif_Hotel_Guncelleme pagesSayfam = new US_008_Positif_Hotel_Guncelleme();
    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        pagesSayfam.LoginButonu.click();
        pagesSayfam.usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        pagesSayfam.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        pagesSayfam.sonLoginButonu.click();



    }
    @Test
    public void us008_TestCase01 () {
        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        Assert.assertTrue(pagesSayfam.HotelListYazisi.isDisplayed());
    }
    @Test
    public void us008_TestCase02 () throws InterruptedException {
        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        pagesSayfam.DetailsSekmesi.click();
        Thread.sleep(9000);
        Assert.assertTrue(pagesSayfam.DetailsYazisi.isDisplayed());



    }
    @Test
    public void us008_TestCase03 () throws InterruptedException {


        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        pagesSayfam.DetailsSekmesi.click();




        pagesSayfam.PhoneSekmesi.clear();
        pagesSayfam.PhoneSekmesi.sendKeys(ConfigReader.getProperty("US_008_guncel_phone"));
        pagesSayfam.SaveSekmesi.click();

        Thread.sleep(9000);
        Assert.assertTrue(pagesSayfam.SaveOlduYazisi.isDisplayed());

    }


    @Test
    public void us008_TestCase04 () throws InterruptedException {
        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        pagesSayfam.DetailsSekmesi.click();
        pagesSayfam.EmailSekmesi.click();
        pagesSayfam.EmailSekmesi.clear();
        pagesSayfam.EmailSekmesi.sendKeys(ConfigReader.getProperty("US_008_guncel_email"));
        pagesSayfam.SaveSekmesi.click();
        Thread.sleep(9000);
        Assert.assertTrue(pagesSayfam.SaveOlduYazisi.isDisplayed());
    }


    @Test
    public void us008_TestCase05 () throws InterruptedException {
        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        pagesSayfam.DetailsSekmesi.click();
        pagesSayfam.GroupSekmesi.click();
        pagesSayfam.Group1.click();
        pagesSayfam.SaveSekmesi.click();
        Thread.sleep(9000);
        Assert.assertTrue(pagesSayfam.SaveOlduYazisi.isDisplayed());
    }

    @Test
    public void us008_TestCase06 () throws InterruptedException {
        pagesSayfam.hotelManagment.click();
        pagesSayfam.HotelListsekmesi.click();
        pagesSayfam.DetailsSekmesi.click();
        pagesSayfam.DeleteSekmesi.click();
        pagesSayfam.DevammiText.click();

    }



}
