package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_015RoomRezervasyon10 {

    public US_015RoomRezervasyon10(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(xpath="//input[@id='UserName']")
    public WebElement userNameTextBox;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath=" //span[text()='Hotel Management']")
    public WebElement hotelManagementElementi;

    @FindBy(xpath="//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomRezervationElementi;

    @FindBy(xpath="//th[contains(text(),'ContactPhone')]")
    public WebElement contactPhoneBaslik;

    @FindBy(xpath="//th[contains(text(),'ContactEmail')]")
    public WebElement contactEmailBaslik;

    @FindBy(xpath="//th[contains(text(),'Approved')]")
    public WebElement approvedBaslik;

    @FindBy(xpath="//th[contains(text(),'IsPaid')]")
    public WebElement isPaidBaslik;

    @FindBy(xpath="//th[contains(text(),'Actions')]")
    public WebElement actionsBaslik;

    @FindBy(xpath=" //span[contains(text(),'Add Room Reservation')]")
    public WebElement addRoomBtn;

    @FindBy(xpath="//thead/tr[2]/td[14]/div[1]/button[1]")
    public WebElement searchBtn;

    @FindBy(xpath=" //thead/tr[2]/td[14]/button[1]")
    public WebElement clearBtn;


}
