package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_010_RoomSearch;
import utilities.ConfigReader;
import utilities.Driver;

public class US_010 {

    US_010_RoomSearch us_010room=new US_010_RoomSearch();

    @BeforeClass
    public void loginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        us_010room.loginButton.click();
        us_010room.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_010room.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_010room.loginSubmit.click();
        us_010room.hotelManagementButton.click();
        us_010room.hotelRoomsButton.click();

    }

    @Test()
    public void idHotelIleArama() throws InterruptedException {

        Select select=new Select(us_010room.idDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIdHotel"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }

    @Test
    public void codeIleArama() throws InterruptedException {

        us_010room.clearButton.click();
        us_010room.codeBox.sendKeys(ConfigReader.getProperty("roomSearchCode"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }

    @Test
    public void nameIleArama() throws InterruptedException {
        us_010room.clearButton.click();
        us_010room.nameBox.sendKeys(ConfigReader.getProperty("roomSearchName"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];


        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }
    @Test
    public void locationIleArama() throws InterruptedException {
        us_010room.clearButton.click();
        us_010room.locationBox.sendKeys(ConfigReader.getProperty("roomSearchLocation"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }

    @Test
    public void priceIleArama() throws InterruptedException {
        us_010room.clearButton.click();
        us_010room.priceBox.sendKeys(ConfigReader.getProperty("roomSearchPrice"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));
    }
    @Test
    public void idGroupRoomTypeIleArama() throws InterruptedException {
        us_010room.clearButton.click();
        Select select=new Select(us_010room.idGroupRoomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIdGroupRoomType"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }
    @Test
    public void isAvailableIleArama() throws InterruptedException {
        us_010room.clearButton.click();
        Select select=new Select(us_010room.isAvailableDropDown);

        select.selectByVisibleText(ConfigReader.getProperty("dropDownVisibleTextIsAvailable"));
        us_010room.searchButton.click();

        Thread.sleep(3000);
        String actualInfo=us_010room.dataTableInfo.getText().split(" ")[0];

        Assert.assertEquals(actualInfo,ConfigReader.getProperty("expectedInfo"));

    }

    @AfterClass
    public void closeTest(){
        Driver.getDriver().close();
    }






}
