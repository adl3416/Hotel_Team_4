package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_015RoomRezervasyon10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_015_10 {

    US_015RoomRezervasyon10 roomRezervasyon=new US_015RoomRezervasyon10();
    @BeforeTest
    public void testebaslamadanOnce() {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        roomRezervasyon.ilkLoginLinki.click();
        roomRezervasyon.userNameTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        roomRezervasyon.passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        roomRezervasyon.loginButonu.click();
        ReusableMethods.waitForClickablility(roomRezervasyon.hotelManagementElementi, 10);
        roomRezervasyon.hotelManagementElementi.click();
        roomRezervasyon.roomRezervationElementi.click();
    }
    @Test(priority=1,description="contactphone basliginin gorunurlugu test edildi")
    public void contactPhoneTest(){
        System.out.println(roomRezervasyon.contactPhoneBaslik.isDisplayed());
        Assert.assertTrue(roomRezervasyon.contactPhoneBaslik.isDisplayed());
    }
    @Test(priority=2,description="contactemail basliginin gorunurlugu test edildi")
    public void contactEmailTest(){
        System.out.println(roomRezervasyon.contactEmailBaslik.isDisplayed());
        Assert.assertTrue(roomRezervasyon.contactEmailBaslik.isDisplayed());
    }
    @Test(priority=3,description="Approved basliginin gorunurlugu test edildi")
    public void aapprovedTest(){
        System.out.println(roomRezervasyon.approvedBaslik.isDisplayed());
        Assert.assertTrue(roomRezervasyon.approvedBaslik.isDisplayed());
    }
    @Test(priority=4,description="IsPaid basliginin gorunurlugu test edildi")
    public void paidTest(){
        System.out.println(roomRezervasyon.isPaidBaslik.isDisplayed());
        Assert.assertTrue(roomRezervasyon.isPaidBaslik.isDisplayed());
    }
    @Test(priority=5,description="actions basliginin gorunurlugu test edildi")
    public void actionsBaslikTest(){
        System.out.println(roomRezervasyon.actionsBaslik.isDisplayed());
        Assert.assertTrue(roomRezervasyon.actionsBaslik.isDisplayed());
    }
    @Test(priority=6,description="addRoom, Search ve Clear Butonlarinin gorunurlugu test edildi")
    public void addRoomSearchClearButonlari(){
        Assert.assertTrue(roomRezervasyon.addRoomBtn.isDisplayed());
        Assert.assertTrue(roomRezervasyon.searchBtn.isDisplayed());
        Assert.assertTrue(roomRezervasyon.clearBtn.isDisplayed());
        System.out.println("Room rezervasyon sayfasindaki elementlerin gorunurlugu basari ile sonuclanmistir");
    }









}
