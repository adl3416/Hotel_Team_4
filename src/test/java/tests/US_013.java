package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_013_Positive_RoomReservation;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_013 {

    US_013_Positive_RoomReservation us_013_RoomReservation;

    @BeforeMethod
    public void setUp(){
        us_013_RoomReservation = new US_013_Positive_RoomReservation();
        us_013_RoomReservation.preConditions();
    }

    @Test
    public void tc_001_User_Verification(){
        Select select=new Select(us_013_RoomReservation.idUser);
        select.selectByVisibleText(ConfigReader.getProperty("pos_IDUser"));
        Assert.assertTrue( us_013_RoomReservation.idUser.getText().contains(ConfigReader.getProperty("pos_IDUser")));
        Driver.closeDriver();
    }

    @Test
    public void tc_002_HotelRoom_Verification(){
        Select select=new Select(us_013_RoomReservation.idHotelRoom);
        select.selectByVisibleText(ConfigReader.getProperty("pos_IDUser_HotelRoom"));
       // WebElement hotelRoom = Driver.getDriver().findElement(By.xpath("//option[text()='Ayse']"));
       // Assert.assertTrue( hotelRoom.isSelected());
        Assert.assertTrue( us_013_RoomReservation.idHotelRoom.getText().contains(ConfigReader.getProperty("pos_IDUser_HotelRoom")));
        Driver.closeDriver();
    }

    @Test
    public void tc_003_Price_Verification(){
        us_013_RoomReservation.price.sendKeys(ConfigReader.getProperty("pos_Price"));
        Assert.assertTrue( us_013_RoomReservation.price.isEnabled());
    }

    @Test
    public void tc_004_DateStart_Verification(){
        us_013_RoomReservation.dateStart.sendKeys(ConfigReader.getProperty("pos_DateStart") + Keys.ENTER);
        Assert.assertTrue( us_013_RoomReservation.dateStart.isEnabled());
    }

    @Test
    public void tc_005_DateEnd_Verification(){
        us_013_RoomReservation.dateEnd.sendKeys(ConfigReader.getProperty("pos_DateEnd") + Keys.ENTER);
        Assert.assertTrue( us_013_RoomReservation.dateEnd.isEnabled());
    }

    @Test
    public void tc_006_AdultAmount_Verification(){
        us_013_RoomReservation.adultAmount.sendKeys(ConfigReader.getProperty("pos_AdultAmount") );
        Assert.assertTrue( us_013_RoomReservation.adultAmount.isEnabled());
    }

    @Test
    public void tc_007_ChildrenAmount_Verification(){
        us_013_RoomReservation.childrenAmount.sendKeys(ConfigReader.getProperty("pos_ChildrenAmount"));;
        Assert.assertTrue( us_013_RoomReservation.childrenAmount.isEnabled());
    }

    @Test
    public void tc_008_ContactNameSurname_Verification(){
        us_013_RoomReservation.contactNameSurname.sendKeys(ConfigReader.getProperty("pos_NameSurname"));
        Assert.assertTrue( us_013_RoomReservation.contactNameSurname.isEnabled());
    }

    @Test
    public void tc_009_Phone_Verification(){
        us_013_RoomReservation.contactPhone.sendKeys(ConfigReader.getProperty("pos_Phone"));
        Assert.assertTrue( us_013_RoomReservation.contactPhone.isEnabled());
    }

    @Test
    public void tc_010_Email_Verification(){
        us_013_RoomReservation.allValidData();
        JSUtils.clickElementByJS(us_013_RoomReservation.saveButton);
        ReusableMethods.waitForVisibility(us_013_RoomReservation.alertText, 3);
        Assert.assertEquals(us_013_RoomReservation.alertText.getText(),
                ConfigReader.getProperty("success_room_reservation_message"));
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
