package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_001_PositiveLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_001 {

    @Test
    public void KoalaResortLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        US_001_PositiveLoginPage us_001_positiveLoginPage = new US_001_PositiveLoginPage();
        us_001_positiveLoginPage.ilkLoginLinki.click();

        us_001_positiveLoginPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_gecerli_username"));

        us_001_positiveLoginPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_gecerli_password"));
        us_001_positiveLoginPage.loginButonu.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("kr_basarili_giris_url"));
        Driver.closeDriver();


    }






}
