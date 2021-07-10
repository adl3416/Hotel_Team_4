package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_003_Home_Page_Elements;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.io.IOException;


public class US_003 {

    US_003_Home_Page_Elements home_page_elements = new US_003_Home_Page_Elements();

    @Test
    public void us_003_tc_001_WelcomeTo_KoalaResort_Text_IsDisplayed(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        String actual = home_page_elements.carousel();
        String expected = "Welcome To Koala Resort";
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void us_003_tc_002_KoalaResort_Text_IsDisplayed(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        Assert.assertTrue(home_page_elements.koalaResortText.isDisplayed());
    }
    @Test
    public void us_003_tc_003_Rooms_Button_isClickable(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        JSUtils.changeColor("red",home_page_elements.roomsButton);
        home_page_elements.roomsButton.click();
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(url,ConfigReader.getProperty("roomsButtonLink"));

    }
    @Test
    public void us_003_tc_004_Home_Button_isClickable(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        JSUtils.changeColor("red",home_page_elements.homeButton);
        String homeTitle= Driver.getDriver().getTitle();
        home_page_elements.homeButton.click();
        String homeCurrentTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(homeTitle,homeCurrentTitle);

    }
    @Test
    public void us_003_tc_005_Restaurant_Button_isClickable() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.changeColor("red",home_page_elements.restaurantButton);
        home_page_elements.restaurantButton.click();
        String currentTitle =Driver.getDriver().getTitle();
        Assert.assertEquals(currentTitle,ConfigReader.getProperty("restaurantButtonTitle"));
        ReusableMethods.getScreenshot("RestaurantButtonIsClicable");

    }
    @Test
    public void us_003_tc_006_About_Button_isClickable()  {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.changeColor("red",home_page_elements.aboutButton);
        home_page_elements.aboutButton.click();
        String currentUrl =Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,ConfigReader.getProperty("aboutButtonLink"));


    }
    @Test
    public void us_003_tc_007_Blog_Button_isClickable(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.changeColor("red",home_page_elements.blogButton);
        home_page_elements.blogButton.click();
        Assert.assertTrue(home_page_elements.blogText.isDisplayed());

    }
    @Test
    public void us_003_tc_008_Login_Button_isClickable() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.changeColor("red",home_page_elements.loginButton);
        home_page_elements.loginButton.click();
        Assert.assertTrue(home_page_elements.loginText.isDisplayed());
        ReusableMethods.getScreenshot("LoginButtonIsClicable");
    }
    @Test
    public void us_003_tc_009_Check_Availability_Button_isClickable() throws InterruptedException {

        Actions action= new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        JSUtils.scrollIntoVIewJS(home_page_elements.checkinBox);

        action.click(home_page_elements.checkinBox).build().perform();
        action.click(home_page_elements.checkinDay).build().perform();

        action.click(home_page_elements.checkoutBox).build().perform();
        action.click(home_page_elements.checkoutDay).build().perform();

        action.click(home_page_elements.roomTypeDropDown).build().perform();

        Select select = new Select(home_page_elements.roomTypeDropDown);
        select.selectByVisibleText("Double");

        Select select2 = new Select(home_page_elements.customerDropDown);
        select2.selectByVisibleText("2 Adult");

        JSUtils.changeColor("red",home_page_elements.checkAvailabilityButton);
        home_page_elements.checkAvailabilityButton.click();

        String expectedTitle= "KoalaResortHotels - Rooms";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

}
