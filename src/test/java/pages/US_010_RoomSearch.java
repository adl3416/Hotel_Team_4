package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_010_RoomSearch {

    public US_010_RoomSearch(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButton;
    @FindBy(css = "#UserName")
    public WebElement userName;
    @FindBy(css = "#Password")
    public WebElement password;
    @FindBy(id = "btnSubmit")
    public WebElement loginSubmit;
    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementButton;
    @FindBy(linkText = "Hotel Rooms")
    public WebElement hotelRoomsButton;
    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement idDropDown;
    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;
    @FindBy(xpath = "(//div[@class='pagination-panel'])[2]")
    public WebElement dataTableInfo;
    @FindBy(xpath= "//input[@name='Code']")
    public WebElement codeBox;
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement nameBox;
    @FindBy(xpath = "//input[@name='Location']")
    public WebElement locationBox;
    @FindBy(xpath = "//input[@name='Price']")
    public WebElement priceBox;
    @FindBy(xpath = "//select[@id='lkpGroupRoomTypes']")
    public WebElement idGroupRoomTypeDropDown;
    @FindBy(xpath = "//select[@name='IsAvailable']")
    public WebElement isAvailableDropDown;
    @FindBy(xpath = "//button[@class='btn btn-sm red filter-cancel']")
    public WebElement clearButton;



}
