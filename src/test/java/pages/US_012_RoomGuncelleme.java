package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_012_RoomGuncelleme {

    public US_012_RoomGuncelleme(){
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

        @FindBy(linkText = "Hotel Management")
        public WebElement hotelManagement;

        @FindBy(linkText = "Hotel Rooms")
        public WebElement hotelRooms;

        @FindBy(xpath = "//a[@class='btn btn-xs default']")
        public WebElement detailsButon;

        @FindBy(linkText = "Photos")
        public WebElement photoslinki;

        @FindBy(xpath = "//a[@id='tab_images_uploader_pickfiles']")
        public WebElement selectFile;

        @FindBy(xpath = "//a[@id='tab_images_uploader_uploadfiles']")
        public WebElement uploadFile;

        @FindBy(xpath = "//*[text()='Properties']")
        public WebElement properties;

        @FindBy(xpath = "//select[@name='lkpBarcodeTypes']")
        public WebElement tipDropdown;

        @FindBy(xpath = "//input[@id='txtBarcodeCode']")
        public WebElement codeYazisi;

        @FindBy(xpath = "//textarea[@id='txtBarcode']")
        public WebElement valueYazisi;

        @FindBy(xpath ="(//button[@class='btn green'])[2]")
        public WebElement saveButonu;
        @FindBy(xpath = "//button[@class='btn btn-primary']")
        public WebElement saveOkButtonu;

        @FindBy(xpath = "//a[@class='btn default btn-sm  margin-bottom-5']")
        public WebElement removeButonu;
        @FindBy(xpath = "//button[@class='btn btn-primary']")
        public WebElement removeOkButtonu;

        @FindBy (xpath = "//div[@class='bootbox-body']")
        public WebElement removeSilindiMesaji;

        @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement degerBosBirakilamazYazisi;


        @FindBy  (xpath = "//div[@class='bootbox-body']")
    public WebElement saveTusuUyariYazisi;


    }


