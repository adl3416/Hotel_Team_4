package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.US_012_RoomGuncelleme;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.JSUtils.*;

public class US_012 {



    US_012_RoomGuncelleme us_012_roomGuncelleme;
    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentHtmlReporter extentHtmlReporter;

    @BeforeClass(alwaysRun = true)

    public void loginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_012_roomGuncelleme.loginButton.click();
        us_012_roomGuncelleme.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_012_roomGuncelleme.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_012_roomGuncelleme.loginSubmit.click();
        us_012_roomGuncelleme.hotelManagement.click();
        us_012_roomGuncelleme.hotelRooms.click();
        us_012_roomGuncelleme.detailsButon.click();


        extentReports = new ExtentReports();
        String filePath = System.getProperty("user.dir") + "test-output/US_012.html";

        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Device", System.getProperty("os.version"));

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentHtmlReporter.config().setReportName("US_012");
        extentHtmlReporter.config().setDocumentTitle("Room Guncelleme012");
        extentReports.attachReporter(extentHtmlReporter);

    }

    @BeforeMethod(alwaysRun = true)

    public void deneme() {
        us_012_roomGuncelleme = new US_012_RoomGuncelleme();
        extentTest = extentReports.createTest("01", "");
    }

    @Test
    public void PhotosSekmesi() {
     //   extentTest = extentReports.createTest("01", "photos sekmesi");

        us_012_roomGuncelleme.photoslinki.click();
    }

    @Test
    public void SelectFileButonu() {
        us_012_roomGuncelleme.photoslinki.click();
        us_012_roomGuncelleme.selectFile.click();
    }

    @Test
    public void propertiesSekmesi() throws InterruptedException {
        Thread.sleep(7000);
        us_012_roomGuncelleme.properties.click();
    }

    @Test
    public void DropdownTesti() {
        us_012_roomGuncelleme.properties.click();
        Select select = new Select(us_012_roomGuncelleme.tipDropdown);
        select.selectByVisibleText("room prop2");
        SoftAssert softAssert = new SoftAssert();
        String actualSeciliOpsiyon = select.getFirstSelectedOption().getText();
        String expectedValue = "room prop2";
        softAssert.assertEquals(actualSeciliOpsiyon, expectedValue);
        softAssert.assertAll();

    }

    @Test
    public void pozitifCodeValueTextbox() {
        clickElementByJS(us_012_roomGuncelleme.properties);
        // us_012_roomGuncelleme.properties.click();
        Select select = new Select(us_012_roomGuncelleme.tipDropdown);
        select.selectByVisibleText("room prop1");
        us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
        us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
    }

    @Test
    public void saveButonu() {
        clickElementByJS(us_012_roomGuncelleme.properties);
        //us_012_roomGuncelleme.properties.click();
        Select select = new Select(us_012_roomGuncelleme.tipDropdown);
        select.selectByVisibleText("room prop1");
        us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
        us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        clickElementByJS(us_012_roomGuncelleme.saveButonu);
        //scrollDownByJS();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(us_012_roomGuncelleme.saveTusuUyariYazisi.getText().contains("Value added"));


        // Assert.assertTrue(us_012_roomGuncelleme.saveTusuUyariYazisi.getText().contains("Value added"));
    }

    @Test
    public void deleteButonu() {
        clickElementByJS(us_012_roomGuncelleme.properties);
        // us_012_roomGuncelleme.properties.click();
        Select select = new Select(us_012_roomGuncelleme.tipDropdown);
        select.selectByVisibleText("room prop1");
        us_012_roomGuncelleme.codeYazisi.sendKeys("1234");
        us_012_roomGuncelleme.valueYazisi.sendKeys("asdef");
        scrollDownByJS();
        // Actions actions =new Actions(Driver.getDriver());
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // us_012_roomGuncelleme.saveButonu.click();
        clickElementByJS(us_012_roomGuncelleme.saveButonu);
        // scrollPageDown();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        us_012_roomGuncelleme.saveOkButtonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        clickElementByJS(us_012_roomGuncelleme.removeButonu);
        clickElementByJS(us_012_roomGuncelleme.removeOkButtonu);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(us_012_roomGuncelleme.removeSilindiMesaji.getText().contains("Value was deleted Succesfully"));
    }


    @Test
    public void photoEkleVeUpload() throws InterruptedException {
        clickElementByJS(us_012_roomGuncelleme.photoslinki);
        us_012_roomGuncelleme.photoslinki.click();
        us_012_roomGuncelleme.selectFile.click();
        System.out.println(System.getProperty("user.dir"));
        String mainPath = System.getProperty("user.home");
        String dosyaYolu = mainPath + "\\Desktop+" + "\\lale.jpg";
        us_012_roomGuncelleme.selectFile.sendKeys(dosyaYolu);
        Thread.sleep(5000);
        us_012_roomGuncelleme.uploadFile.click();
    }

    @Test
    public void negatifCodeValueYazisiTextBox() {
        clickElementByJS(us_012_roomGuncelleme.properties);
        //  us_012_roomGuncelleme.properties.click();
        Select select = new Select(us_012_roomGuncelleme.tipDropdown);
        select.selectByVisibleText("room prop3");
        us_012_roomGuncelleme.codeYazisi.sendKeys(" ");
        us_012_roomGuncelleme.valueYazisi.sendKeys(" ");
        scrollDownByJS();
        us_012_roomGuncelleme.saveButonu.click();
        Assert.assertFalse(us_012_roomGuncelleme.degerBosBirakilamazYazisi.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownReports(){
        extentReports.flush();
    }
}


