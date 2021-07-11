package tests;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.US_014_Negatif_RoomReservasyon;
import utilities.Driver;
import utilities.JSUtils;


public class US_014 {

    US_014_Negatif_RoomReservasyon page = new US_014_Negatif_RoomReservasyon();

    @Test
    public void tc_001(){
        page.preConditions();
        JSUtils.clickElementByJS(page.saveButton);
        page.hataMesajlarıGörüntülendiMi();

    }
    @Test
    public void tc_002(){
        page.preConditions();
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.idUserHataMesaji);
        Assert.assertTrue(page.idUserHataMesaji.isDisplayed());
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
