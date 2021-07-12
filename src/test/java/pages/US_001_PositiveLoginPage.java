package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_001_PositiveLoginPage {


    public US_001_PositiveLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;
    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;
    @FindBy(id = "Password")
    public WebElement passwordTexBox;
    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;


}



