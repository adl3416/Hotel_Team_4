package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_014_Negatif_RoomReservasyon;
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
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.iDUser);
        Assert.assertTrue(page.idUserHataMesaji.isDisplayed());
    }
}
