package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_013_Positive_RoomReservation {

    public US_013_Positive_RoomReservation(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButton;

    @FindBy(css = "#UserName")
    public WebElement userName;

    @FindBy(css = "#Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginSubmit;

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public WebElement hotelMeagamentMenu;

    @FindBy (xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservationMenu;

    @FindBy (xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservationButton;

    @FindBy (id = "IDUser")
    public WebElement idUser;

    @FindBy (id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy (id = "Price")
    public WebElement price;

    @FindBy (id = "DateStart")
    public WebElement dateStart;

    @FindBy (id = "DateEnd")
    public WebElement dateEnd;

    @FindBy (id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy (id = "ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy (id = "ContactNameSurname")
    public WebElement contactNameSurname;

    @FindBy (id = "ContactPhone")
    public WebElement contactPhone;

    @FindBy (id = "ContactEmail")
    public WebElement contactEmail;

    @FindBy (id = "Notes")
    public WebElement notes;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (className = "bootbox-body")
    public WebElement alertText;



















}
