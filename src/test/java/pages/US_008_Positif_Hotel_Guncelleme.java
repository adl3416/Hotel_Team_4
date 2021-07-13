package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_008_Positif_Hotel_Guncelleme {




        public US_008_Positif_Hotel_Guncelleme() {

            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(partialLinkText ="Log")
        public WebElement LoginButonu;

        @FindBy(css ="#UserName")
        public WebElement usurname;

        @FindBy(xpath = "//input[@id='Password']")
        public WebElement password;

        @FindBy (xpath = "//input[@id=\"btnSubmit\"]")
        public WebElement sonLoginButonu;

        @FindBy(xpath = "(//span[@class='title'])[3]")
        public WebElement hotelManagment;

        @FindBy(linkText="Hotel List")
        public WebElement HotelListsekmesi;

        @FindBy(xpath = "//div[@class='caption']")
        public  WebElement HotelListYazisi;

        @FindBy(xpath = " //a[@class='btn btn-xs default']")
        public  WebElement DetailsSekmesi;

        @FindBy(xpath = "(//div[@class='caption'])[1]")
        public WebElement DetailsYazisi;

        @FindBy(xpath ="//input[@name='Phone']")
        public WebElement PhoneSekmesi;

        @FindBy(xpath = "//button[@class='btn green'][1]")
        public WebElement SaveSekmesi;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement SaveOlduYazisi;

        @FindBy(xpath ="//input[@title='Email']")
        public WebElement EmailSekmesi;

        @FindBy(xpath = "//select[@id='IDGroup']")
        public WebElement GroupSekmesi;

        @FindBy(xpath = "//option[@value='1']")
        public WebElement Group1;

        @FindBy(xpath = "(// div[@class='portlet-title'])[4]")
        public WebElement DeleteSekmesi;

        @FindBy(xpath = "//button[@class='btn btn-primary']")
        public WebElement DevammiText;





}
