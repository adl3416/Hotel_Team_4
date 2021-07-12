package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_007_Hotellist_Guncelleme {
    public US_007_Hotellist_Guncelleme() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (partialLinkText ="Log")
    public WebElement LoginButonu;

    @FindBy(css ="#UserName")
    public WebElement usurname;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id=\"btnSubmit\"]")
    public WebElement sonLoginButonu;

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagement;

    @FindBy(linkText="Hotel List")
    public WebElement HotelListsekmesi;

    @FindBy(xpath = "//div[@class='caption']")
    public  WebElement HotelListYazisi;

   // @FindBy(xpath = "//div[@class='table-scrollable']")
   // public WebElement anaTablo;

    @FindBy (xpath = "//a[@target]")
    public List<WebElement> Hoteldetails;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarlisti;

    @FindBy(xpath = "//Input[@id='Code']")
    public WebElement codesekmesi;

    @FindBy(css = "button.btn.green")
    public WebElement savebuttonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement succesfullytext;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement namesekmesi;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement adresssekmesi;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okbutonu;

    public void hotelListPages () { //randonm olarak hotel listesinden bir adet hotel getirir.
        List<String> detailslist=new ArrayList<>();
        for (int i=0; i<satirlarlisti.size(); i++) {
            detailslist.add(Hoteldetails.get(i).getAttribute("href"));
        }
        Random random=new Random();
        int detailsno=random.nextInt(10);

        Driver.getDriver().get(detailslist.get(detailsno));
    }
    public void loginMethodu() {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        LoginButonu.click();
        usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        sonLoginButonu.click();
    }

}
