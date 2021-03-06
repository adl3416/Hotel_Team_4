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

    @FindBy(xpath = "(//i[@class='fa fa-calendar'])[1]")
    public WebElement dateStartTakvimButton;

    @FindBy(xpath = "(//i[@class='fa fa-calendar'])[2]")
    public WebElement dateEndTakvimButton;

    @FindBy(xpath = "(//td[@class='disabled day'])[1]")
    public WebElement disabledDay;

    @FindBy(xpath = "(//td[@class='day'])[1]")
    public WebElement enabledDay;


    @FindBy(xpath = "//tbody//td")
    public List<WebElement> takvimGunDatalar??;


    public Boolean gunSecildiMi(){
        List<WebElement> list = takvimGunDatalar??;
        boolean sonuc = true;
        for (WebElement w : list) {
            if(w.getAttribute("class").equals("active day")){
                sonuc = true;
            }else {
                sonuc = false;
            }
        }
        return sonuc;
    }


    public void hataMesajlar??G??r??nt??lendiMi(){
        List<WebElement> messages = errorMessages;
        SoftAssert softAssert = new SoftAssert();
        for (WebElement w: messages) {
            softAssert.assertTrue(w.isDisplayed());
        }

        softAssert.assertAll();

    }

    public void sayfay??EnAltaKayd??r(){
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }

    public void preConditions() {
        loginMethod();
        hotelListManagementButton.click();
        roomReservationButton.click();
        addRoomreservationButton.click();

    }

    public void hataMesajikontrolEdilenElemanHaricBilgileriDoldur(WebElement element){

        String chordData;

        if(element==idUserHataMesaji) {
            chordData = Keys.chord("Select User", Keys.TAB, "Ahmet", Keys.TAB, "3500", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "2", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==hotelRoomHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Select HotelRoom", Keys.TAB, "3500", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "2", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==priceHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "priceText", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "2", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==adultAmountHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "25000", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "AdultAmount", Keys.TAB, "2", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==childrenAmountHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "25000", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "ChildrenAmount", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==contactNameSurnameHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "25000", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "3", Keys.TAB, "85648541", Keys.TAB, "5554448844",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==contactPhoneHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "25000", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "3", Keys.TAB, "Test Tester", Keys.TAB, "phone number",
                    Keys.TAB, "test@gmail.com", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }else if(element==contactEmailHataMesaji){
            chordData = Keys.chord("manager", Keys.TAB, "Ahmet", Keys.TAB, "25000", Keys.TAB, "07/13/2021",
                    Keys.TAB, Keys.TAB, "07/15/2021", Keys.TAB, Keys.TAB, "2", Keys.TAB, "3", Keys.TAB, "Test Tester", Keys.TAB, "5554448844",
                    Keys.TAB, "abcdf.1234", Keys.TAB, "Test", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
            iDUser.sendKeys(chordData);
        }

    }

}
