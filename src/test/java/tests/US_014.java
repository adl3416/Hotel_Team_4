package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.US_014_Negatif_RoomReservasyon;
import utilities.*;

import java.io.IOException;

public class US_014 {
    US_014_Negatif_RoomReservasyon page ;
    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentHtmlReporter extentHtmlReporter;

    @BeforeClass(alwaysRun = true)
    public void reportSetUp(){
        extentReports = new ExtentReports();

        String filePath = System.getProperty("user.dir") + "/test-output/US_014.html";

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Device",System.getProperty("os.version"));

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentHtmlReporter.config().setReportName("US_014");
        extentHtmlReporter.config().setDocumentTitle("Negatif Room Olusturma Testi");
        extentReports.attachReporter(extentHtmlReporter);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        extentTest = extentReports.createTest("Test Sonucları");
        page = new US_014_Negatif_RoomReservasyon();
        page.preConditions();
    }

    @Test
    public void tc_001(){
        JSUtils.clickElementByJS(page.saveButton);
        page.hataMesajlarıGörüntülendiMi();

    }
    @Test
    public void tc_002(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.idUserHataMesaji);
        Assert.assertTrue(page.idUserHataMesaji.isDisplayed());
    }

    @Test
    public void tc_003(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.hotelRoomHataMesaji);
        Assert.assertTrue(page.hotelRoomHataMesaji.isDisplayed());
    }

    @Test
    public void tc_004(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.priceHataMesaji);
        try {
            Assert.assertTrue(page.priceHataMesaji.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(false,"Price textbox hata mesajı görüntülenmedi");
        }
    }

    @Test
    public void tc_005(){
        page.dateStartTakvimButton.click();
        page.disabledDay.click();
        Assert.assertFalse(page.gunSecildiMi());
    }

    @Test
    public void tc_006(){
        page.dateEndTakvimButton.click();
        page.disabledDay.click();
        Assert.assertFalse(page.gunSecildiMi());
    }

    @Test
    public void tc_007(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.adultAmountHataMesaji);
        try {
            Assert.assertTrue(page.adultAmountHataMesaji.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(false,"Adult Amount textbox hata mesajı görüntülenmedi");
        }

    }

    @Test
    public void tc_008(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.childrenAmountHataMesaji);
        try {
            Assert.assertTrue(page.childrenAmountHataMesaji.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(false,"Children Amount textbox hata mesajı görüntülenmedi");
        }

    }

    @Test
    public void tc_009(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.contactNameSurnameHataMesaji);
        try {
            Assert.assertTrue(page.contactNameSurnameHataMesaji.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(false,"ContactNameSurname textbox hata mesajı görüntülenmedi");
        }
    }

    @Test
    public void tc_010(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.contactPhoneHataMesaji);
        Assert.assertTrue(page.contactPhoneHataMesaji.isDisplayed());
    }

    @Test
    public void tc_011(){
        page.hataMesajikontrolEdilenElemanHaricBilgileriDoldur(page.contactEmailHataMesaji);
        Assert.assertTrue(page.contactEmailHataMesaji.isDisplayed());
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