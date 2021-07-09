package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_006_HotelEkleme;
import utilities.ConfigReader;
import utilities.Driver;

public class US_006 {
    US_006_HotelEkleme us_006_hotelEkleme = new US_006_HotelEkleme();

    @BeforeClass
    public void loginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        us_006_hotelEkleme.ilkLoginLinki.click();
        us_006_hotelEkleme.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_006_hotelEkleme.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_006_hotelEkleme.loginButonu.click();
        // us_010room.hotelManagementButton.click();
        // us_010room.hotelRoomsButton.click();
    }
   @Test
    public void us001_TC001() {


        /*test data username: manager ,
        us_006_hotelEkleme.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));

        //test data password : Manager1!

        us_006_hotelEkleme.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        us_006_hotelEkleme.loginButonu.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("kr_basarili_giris_url"));
*/
    }
}
