package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.US_010_RoomSearch;
import pages.US_014_Negatif_RoomReservasyon;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_010 {

    US_010_RoomSearch page=new US_010_RoomSearch();

    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentHtmlReporter extentHtmlReporter;

    @BeforeClass(alwaysRun = true)
    public void loginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        page.loginButton.click();
        page.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        page.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        page.loginSubmit.click();
        page.hotelManagementButton.click();
        page.hotelRoomsButton.click();
        extentReports = new ExtentReports();

        String filePath = System.getProperty("user.dir") + "/test-output/US_010.html";

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Device",System.getProperty("os.version"));

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentHtmlReporter.config().setReportName("US_010");
        extentHtmlReporter.config().setDocumentTitle("Room Search Testi");
        extentReports.attachReporter(extentHtmlReporter);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        extentTest = extentReports.createTest("Test Sonucları");

    }

    @Test()
    public void idHotelIleArama() throws InterruptedException {
        page.clearButton.click();
        Select select=new Select(page.idDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIdHotel"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }

    @Test
    public void codeIleArama() throws InterruptedException {

        page.clearButton.click();
        page.codeBox.sendKeys(ConfigReader.getProperty("roomSearchCode"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }

    @Test
    public void nameIleArama() throws InterruptedException {
        page.clearButton.click();
        page.nameBox.sendKeys(ConfigReader.getProperty("roomSearchName"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }
    @Test
    public void locationIleArama() throws InterruptedException {
        page.clearButton.click();
        page.locationBox.sendKeys(ConfigReader.getProperty("roomSearchLocation"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }

    @Test
    public void priceIleArama() throws InterruptedException {
        page.clearButton.click();
        page.priceBox.sendKeys(ConfigReader.getProperty("roomSearchPrice"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }
    @Test
    public void idGroupRoomTypeIleArama() throws InterruptedException {
        page.clearButton.click();
        Select select=new Select(page.idGroupRoomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIdGroupRoomType"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }
    @Test
    public void isAvailableIleArama() throws InterruptedException {
        page.clearButton.click();
        Select select=new Select(page.isAvailableDropDown);

        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIsAvailable"));
        page.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=page.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

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
    }

        @AfterClass(alwaysRun = true)
    public void closeTest(){
        Driver.getDriver().close();
            extentReports.flush();
    }






}
