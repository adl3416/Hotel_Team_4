package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_012_RoomGuncelleme;
import utilities.ConfigReader;
import utilities.Driver;

 public class US_012 {

        US_012_RoomGuncelleme us_012_roomGuncelleme = new US_012_RoomGuncelleme();
        @BeforeClass
        public void loginTest() throws InterruptedException {
            Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
            us_012_roomGuncelleme.loginButton.click();
            us_012_roomGuncelleme.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
            us_012_roomGuncelleme.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
            us_012_roomGuncelleme.loginSubmit.click();
            us_012_roomGuncelleme.hotelManagement.click();
            us_012_roomGuncelleme.hotelRooms.click();
            us_012_roomGuncelleme.detailsButon.click();
        }

        @Test
        public void PhotosSekmesi(){
            us_012_roomGuncelleme.photoslinki.click();
        }

        @Test
        public void SelectFileButonu () {
            us_012_roomGuncelleme.photoslinki.click();
            us_012_roomGuncelleme.selectFile.click();
        }

        @Test
        public void photoEkleVeUpload () throws InterruptedException {
            us_012_roomGuncelleme.photoslinki.click();
            us_012_roomGuncelleme.selectFile.click();
            System.out.println(System.getProperty("user.dir"));
            String mainPath = System.getProperty("user.home");
            String dosyaYolu= mainPath+"\\Desktop+"+"\\lale.jpg";
            us_012_roomGuncelleme.selectFile.sendKeys(dosyaYolu);
            Thread.sleep(5000);
            us_012_roomGuncelleme.uploadFile.click();
        }
        @Test
        public void propertiesSekmesi () {
            us_012_roomGuncelleme.properties.click();
        }
        @Test
        public void DropdownTesti () {
            us_012_roomGuncelleme.properties.click();
            Select select = new Select(us_012_roomGuncelleme.tipDropdown);
            select.selectByVisibleText("room prop2");
            SoftAssert softAssert=new SoftAssert();
            String actualSeciliOpsiyon= select.getFirstSelectedOption().getText();
            String expectedValue="room prop2";
            softAssert.assertEquals(actualSeciliOpsiyon,expectedValue);
        }
        @Test
        public void pozitifCodeValueTextbox () {
            us_012_roomGuncelleme.properties.click();
            Select select = new Select(us_012_roomGuncelleme.tipDropdown);
            select.selectByVisibleText("room prop1");
            us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
            us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
        }
        @Test
        public void saveButonu(){
            us_012_roomGuncelleme.detailsButon.click();
            us_012_roomGuncelleme.properties.click();
            Select select = new Select(us_012_roomGuncelleme.tipDropdown);
            select.selectByVisibleText("room prop1");
            us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
            us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
            us_012_roomGuncelleme.saveButonu.click();
        }
        @Test
        public void deleteButonu(){
            us_012_roomGuncelleme.properties.click();
            Select select = new Select(us_012_roomGuncelleme.tipDropdown);
            select.selectByVisibleText("room prop1");
            us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
            us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
            us_012_roomGuncelleme.saveButonu.click();
            us_012_roomGuncelleme.deleteButonu.click();
        }
        @Test
        public void negatifCodeValueYazisiTextBox () {
            us_012_roomGuncelleme.properties.click();
            Select select = new Select(us_012_roomGuncelleme.tipDropdown);
            select.selectByVisibleText("room prop1");
            us_012_roomGuncelleme.codeYazisi.sendKeys("");
            us_012_roomGuncelleme.valueYazisi.sendKeys("");
            us_012_roomGuncelleme.saveButonu.click();
        }
    }


