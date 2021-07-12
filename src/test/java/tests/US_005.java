package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.US_005_Hotel_Ekleme;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
public class US_005 {





    @BeforeClass
    public void loginTest()  {
        US_005_Hotel_Ekleme hotelEkleme = new US_005_Hotel_Ekleme();
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        hotelEkleme.loginButton.click();
        hotelEkleme.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        hotelEkleme.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        hotelEkleme.loginSubmit.click();
        hotelEkleme.hotelManagementButton.click();
        hotelEkleme.hotelListButton.click();
        hotelEkleme.addHotelButton.click();
    }


    @Test(priority = 1,enabled = true, description = "Hotel ekleme formunun gorulebilir olmali")
    public void us005_TC001()  {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_expected_url"));
      //  Driver.getDriver().close();
    }



    @Test(priority = 2,enabled = true, description = "Basarili sekilde Hotel kaydi olusturmali")
    public void us005_TC002()  {
        US_005_Hotel_Ekleme hotelEkleme = new US_005_Hotel_Ekleme();
        hotelEkleme.code.sendKeys(ConfigReader.getProperty("kr_hotelcreate_code"));
        hotelEkleme.name.sendKeys(ConfigReader.getProperty("kr_hotelcreate_name"));
        hotelEkleme.adress.sendKeys(ConfigReader.getProperty("kr_hotelcreate_adres"));
        hotelEkleme.phone.sendKeys(ConfigReader.getProperty("kr_hotelcreate_phone"));
        hotelEkleme.email.sendKeys(ConfigReader.getProperty("kr_hotelcreate_email"));
        WebElement selectElement=Driver.getDriver().findElement(By.xpath("//select[@title='Select Group']"));
        Select select=new Select(selectElement);
        select.selectByIndex(1);
        JSUtils.scrollDownByJS();
        ReusableMethods.waitForVisibility(hotelEkleme.saveButonu,15);
        hotelEkleme.saveButonu.click();
        Assert.assertTrue(hotelEkleme.otelKaydiOlustuYazisi.isEnabled());
        hotelEkleme.okButonu.click();

       Driver.getDriver().close();
    }



    @Test(priority = 3,enabled = true, description = "code box in bos birakilmasi")
    public void us005_TC003()  {
        US_005_Hotel_Ekleme hotelEkleme = new US_005_Hotel_Ekleme();
        hotelEkleme.code.sendKeys("");
        hotelEkleme.name.sendKeys(ConfigReader.getProperty("kr_hotelcreate_name"));
        hotelEkleme.adress.sendKeys(ConfigReader.getProperty("kr_hotelcreate_adres"));
        hotelEkleme.phone.sendKeys(ConfigReader.getProperty("kr_hotelcreate_phone"));
        hotelEkleme.email.sendKeys(ConfigReader.getProperty("kr_hotelcreate_email"));
        WebElement selectElement=Driver.getDriver().findElement(By.xpath("//select[@title='Select Group']"));
        Select select=new Select(selectElement);
        select.selectByIndex(1);
        JSUtils.scrollDownByJS();
        JSUtils.scrollPageDown();
        ReusableMethods.waitForVisibility(hotelEkleme.saveButonu,20);
        ReusableMethods.waitFor(3);
        hotelEkleme.saveButonu.click();
        Assert.assertTrue(hotelEkleme.codeHataYazisi.isEnabled());
        Driver.getDriver().close();
    }



    @Test(priority = 4,enabled = true,  description = "name box in bos birakilmasi")
    public void us005_TC004()  {
        US_005_Hotel_Ekleme hotelEkleme = new US_005_Hotel_Ekleme();
        hotelEkleme.code.sendKeys(ConfigReader.getProperty("kr_hotelcreate_code"));
        hotelEkleme.name.sendKeys("");
        hotelEkleme.adress.sendKeys(ConfigReader.getProperty("kr_hotelcreate_adres"));
        hotelEkleme.phone.sendKeys(ConfigReader.getProperty("kr_hotelcreate_phone"));
        hotelEkleme.email.sendKeys(ConfigReader.getProperty("kr_hotelcreate_email"));
        JSUtils.scrollDownByJS();
        WebElement selectElement=Driver.getDriver().findElement(By.xpath("//select[@title='Select Group']"));
        Select select=new Select(selectElement);
        select.selectByIndex(1);
        ReusableMethods.waitForVisibility(hotelEkleme.saveButonu,15);
        hotelEkleme.saveButonu.click();
        Assert.assertTrue(hotelEkleme.nameHataYazisi.isEnabled());
        Driver.getDriver().close();
    }
    @Test   (priority = 5,enabled = true,  description = "adres box in bos birakilmasi")
    public void us005_TC005()  {
        US_005_Hotel_Ekleme hotelEkleme = new US_005_Hotel_Ekleme();
        hotelEkleme.code.sendKeys(ConfigReader.getProperty("kr_hotelcreate_code"));
        hotelEkleme.name.sendKeys(ConfigReader.getProperty("kr_hotelcreate_name"));
        hotelEkleme.adress.sendKeys("");
        hotelEkleme.phone.sendKeys(ConfigReader.getProperty("kr_hotelcreate_phone"));
        hotelEkleme.email.sendKeys(ConfigReader.getProperty("kr_hotelcreate_email"));
        JSUtils.scrollDownByJS();
        WebElement selectElement=Driver.getDriver().findElement(By.xpath("//select[@title='Select Group']"));
        Select select=new Select(selectElement);
        select.selectByIndex(1);
        ReusableMethods.waitForVisibility(hotelEkleme.saveButonu,15);
        hotelEkleme.saveButonu.click();
        Assert.assertTrue(hotelEkleme.adresHataYazisi.isEnabled());
        Driver.getDriver().close();
    }


}