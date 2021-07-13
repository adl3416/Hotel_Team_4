package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_005_Hotel_Ekleme {

    public US_005_Hotel_Ekleme(){
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
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[1]/a")
    public WebElement hotelListButton;
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelButton;
    @FindBy(xpath = "//input[@title='Code']")
    public WebElement code;
    @FindBy(xpath = "//input[@title='Name']")
    public WebElement name;
    @FindBy(xpath = "//input[@title='Address']")
    public WebElement adress;
    @FindBy(xpath = "//input[@title='Phone']")
    public WebElement phone;
    @FindBy(xpath = "//input[@title='Email']")
    public WebElement email;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButonu;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement otelKaydiOlustuYazisi;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButonu;
    @FindBy(xpath = "//label[@for='Code']")
    public WebElement codeHataYazisi;
    @FindBy(xpath = "//label[@for='Name']")
    public WebElement nameHataYazisi;
    @FindBy(xpath = "//label[@for='Address']")
    public WebElement adresHataYazisi;





}
