package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.US_002_Negatif_Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


public class US_002 {

    US_002_Negatif_Login us_002_negatif_login=new US_002_Negatif_Login();
    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentHtmlReporter extentHtmlReporter;

    @BeforeClass(alwaysRun = true)
    public void reportSetUp(){
        extentReports = new ExtentReports();

        String filePath = System.getProperty("user.dir") + "/test-output/US_002.html";

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Device",System.getProperty("os.version"));

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentHtmlReporter.config().setReportName("US_002");
        extentHtmlReporter.config().setDocumentTitle("Negatif Login");
        extentReports.attachReporter(extentHtmlReporter);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        extentTest = extentReports.createTest("Test Results of US_002");

    }

    @Test (priority = 1)
    public void yanlisPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed()&&
                us_002_negatif_login.girisYapilamadiYazisi.getText().contains("Wrong password"));
    }

    @Test(priority = 2)
    public void yanlisUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed());
    }

    @Test(priority = 3)
    public void yanlisUsernameVePasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertTrue(us_002_negatif_login.girisYapilamadiYazisi.isDisplayed());

    }

    @Test(priority = 4)
    public void bosUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_empty_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertEquals(us_002_negatif_login.bosbutonYazisi.getText(),
                ConfigReader.getProperty("kr_empty_message"));
    }

    @Test(priority = 5)
    public void bosPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        us_002_negatif_login.ilkLoginButonu.click();
        us_002_negatif_login.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_002_negatif_login.password.sendKeys(ConfigReader.getProperty("kr_empty_password"));
        us_002_negatif_login.sonLoginButonu.click();
        Assert.assertEquals(us_002_negatif_login.bosbutonYazisi.getText(),
                ConfigReader.getProperty("kr_empty_message"));
        Driver.closeDriver();

    }
    @AfterClass(alwaysRun = true)
    public void tearDownReports(){
        extentReports.flush();
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

    }}
