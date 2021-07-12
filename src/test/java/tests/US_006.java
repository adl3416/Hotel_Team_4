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

        us_006_hotelEkleme.loginButton.click();
        us_006_hotelEkleme.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_006_hotelEkleme.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_006_hotelEkleme.loginSubmit.click();
        us_006_hotelEkleme.hotelManagementButton.click();

    }
   @Test
    public void us001_TC001() {



    }
}
