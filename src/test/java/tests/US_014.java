package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_014_Negatif_RoomReservasyon;
import utilities.JSUtils;
import utilities.ReusableMethods;

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
