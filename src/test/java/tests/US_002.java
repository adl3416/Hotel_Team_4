package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_002_Negatif_Login;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002 {
    US_002_Negatif_Login us_002_negatif_login=new US_002_Negatif_Login();


    @Test
    public void yanlisPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed()&&
                us_002_negatif_login.girisYapilamadiYazisi.getText().contains("Wrong password"));
    }

    @Test
    public void yanlisUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed());
    }

    @Test
    public void yanlisUsernameVePasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed());

    }

    @Test
    public void bosUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_empty_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertEquals(us_002_negatif_login.bosbutonYazisi.getText(),
                ConfigReader.getProperty("kr_empty_message"));
    }

    @Test
    public void bosPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_empty_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertEquals(us_002_negatif_login.bosbutonYazisi.getText(),
                ConfigReader.getProperty("kr_empty_message"));

    }

}