package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_014_Negatif_RoomReservasyon {

    public US_014_Negatif_RoomReservasyon(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement anasayfaLoginButton ;


    @FindBy(css = "input#UserName")
    public WebElement loginUsername;

    public void loginMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        anasayfaLoginButton.click();
        String chordLoginData = Keys.chord(ConfigReader.getProperty("kr_valid_username"), Keys.TAB, ConfigReader.getProperty("kr_valid_password"),Keys.TAB,Keys.ENTER);
        loginUsername.sendKeys(chordLoginData);

    }

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelListManagementButton;

    @FindBy(xpath = "(//ul[@class='sub-menu'])[3]/li[3]/a")
    public WebElement roomReservationButton;

    @FindBy(css = ".btn.btn-circle.btn-default")
    public WebElement addRoomreservationButton;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[@for='IDUser']")
    public WebElement idUserHataMesaji;

    @FindBy(xpath = "//label[@for='IDHotelRoom']")
    public WebElement hotelRoomHataMesaji;

    @FindBy(xpath = "//label[@for='Price']")
    public WebElement priceHataMesaji;

    @FindBy(xpath = "//label[@for='DateStart']")
    public WebElement dataStartHataMesaji;

    @FindBy(xpath = "//label[@for='DateEnd']")
    public WebElement dataEndHataMesaji;

    @FindBy(xpath = "//label[@for='AdultAmount']")
    public WebElement adultAmountHataMesaji;

    @FindBy(xpath = "//label[@for='ChildrenAmount']")
    public WebElement childrenAmountHataMesaji;

    @FindBy(xpath = "//label[@for='ContactNameSurname']")
    public WebElement contactNameSurnameHataMesaji;

    @FindBy(xpath = "//label[@for='ContactEmail']")
    public WebElement contactEmailHataMesaji;

    @FindBy(xpath = "//label[@for='Notes']")
    public WebElement notesHataMesaji;

    @FindBy(xpath = "//label[@for='ContactPhone']")
    public WebElement contactPhoneHataMesaji;

    @FindBy(xpath = "//label[@class='error']")
    public List<WebElement> errorMessages;

    @FindBy(css= "select#IDHotelRoom")
    public WebElement iDHotelRoom;

    @FindBy(css= "select#IDUser")
    public WebElement iDUser;


    public void hataMesajlarıGörüntülendiMi(){
        List<WebElement> messages = errorMessages;
        SoftAssert softAssert = new SoftAssert();
        for (WebElement w: messages) {
            softAssert.assertTrue(w.isDisplayed());
        }

        softAssert.assertAll();

    }

    public void sayfayıEnAltaKaydır(){
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }

    public void preConditions() {
        loginMethod();
        hotelListManagementButton.click();
        roomReservationButton.click();
        addRoomreservationButton.click();

    }

    public void hataMesajikontrolEdilenElemanHaricBilgileriDoldur(WebElement element){

        String chordData = Keys.chord("Select User",Keys.TAB,"Ahmet",Keys.TAB,"3500",Keys.TAB,"07/13/2021",
                Keys.TAB,Keys.TAB,"07/15/2021",Keys.TAB,Keys.TAB,"2",Keys.TAB,"2",Keys.TAB,"Test Tester",Keys.TAB,"5554448844",
                Keys.TAB,"test@gmail.com",Keys.TAB,"Test",Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
        iDUser.sendKeys(chordData);

    }

}
