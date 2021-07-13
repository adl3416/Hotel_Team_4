package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_008_Positif_Hotel_Guncelleme {


        private US_008_Positif_Hotel_Guncelleme detailslist;

        public US_008_Positif_Hotel_Guncelleme() {

                PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(partialLinkText = "Log")
        public WebElement LoginButonu;

        @FindBy(css = "#UserName")
        public WebElement usurname;

        @FindBy(xpath = "//input[@id='Password']")
        public WebElement password;

        @FindBy(xpath = "//input[@id=\"btnSubmit\"]")
        public WebElement sonLoginButonu;

        @FindBy(xpath = "(//span[@class='title'])[3]")
        public WebElement hotelManagment;

        @FindBy(linkText = "Hotel List")
        public WebElement HotelListsekmesi;

        @FindBy(xpath = "//div[@class='caption']")
        public WebElement HotelListYazisi;

        @FindBy(xpath = " //a[@class='btn btn-xs default']")
        public WebElement DetailsSekmesi;

        @FindBy(xpath = "(//div[@class='caption'])[1]")
        public WebElement DetailsYazisi;

        @FindBy(xpath = "//input[@class='Phone']")
        public WebElement PhoneSekmesi;

        @FindBy(xpath = "//button[@class='btn green'][1]")
        public WebElement SaveSekmesi;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement SaveOlduYazisi;

        @FindBy(xpath = "//input[@title='Email']")
        public WebElement EmailSekmesi;

        @FindBy(xpath = "//select[@id='IDGroup']")
        public WebElement GroupSekmesi;

        @FindBy(xpath = "//option[@value='1']")
        public WebElement Group1;

        @FindBy(xpath = "(// div[@class='portlet-title'])[4]")
        public WebElement DeleteSekmesi;

        @FindBy(xpath = "//button[@class='btn btn-primary']")
        public WebElement DevammiText;






        @FindBy(xpath = "(//span[@class='title'])[3]")
        public WebElement hotelManagement;

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

       /* public void hotelListPages () { //randonm olarak hotel listesinden bir adet hotel getirir.
                List<String> detailslist=new ArrayList<>();
                for (int i=0; i<satirlarlisti.size(); i++) {
                        detailslist.add(DetailsSekmesi.get(i).getAttribute("href"));
                }
                Random random=new Random();
                int detailsno=random.nextInt(10)get(detailsno));
        }
        public void loginMethodu() {
                Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
                LoginButonu.click();;
                Driver.getDriver().get(detailslist.
                        usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
                password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
                sonLoginButonu.click();
        }*/




}
