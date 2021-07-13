package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_013_Positive_RoomReservation {

    public US_013_Positive_RoomReservation(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButton;

    @FindBy(css = "#UserName")
    public WebElement userName;

    public void loginMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        loginButton.click();
        String chordLoginData = Keys.chord(ConfigReader.getProperty("kr_valid_username"),
                Keys.TAB, ConfigReader.getProperty("kr_valid_password"),
                Keys.TAB,Keys.ENTER);
        userName.sendKeys(chordLoginData);

    }


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

    public void preConditions() {
        loginMethod();
        hotelMeagamentMenu.click();
        roomReservationMenu.click();
        addRoomReservationButton.click();

    }

    @FindBy (id = "IDUser")
    public WebElement idUser;

    public void allValidData() {

        String chordValidDatas = Keys.chord(
                ConfigReader.getProperty("pos_IDUser"),
                Keys.TAB, ConfigReader.getProperty("pos_IDUser_HotelRoom"),
                Keys.TAB, ConfigReader.getProperty("pos_Price"),
                Keys.TAB, ConfigReader.getProperty("pos_DateStart"),
                Keys.TAB,Keys.TAB, ConfigReader.getProperty("pos_DateEnd"),
                Keys.TAB,Keys.TAB, ConfigReader.getProperty("pos_AdultAmount"),
                Keys.TAB, ConfigReader.getProperty("pos_ChildrenAmount"),
                Keys.TAB, ConfigReader.getProperty("pos_NameSurname"),
                Keys.TAB, ConfigReader.getProperty("pos_Phone"),
                Keys.TAB, ConfigReader.getProperty("pos_Email"),
                Keys.TAB, ConfigReader.getProperty("pos_Notes"));
        idUser.sendKeys(chordValidDatas);
    }

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

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (className = "bootbox-body")
    public WebElement alertText;




















}
