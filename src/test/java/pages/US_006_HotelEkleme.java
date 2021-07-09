package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_006_HotelEkleme {

    public US_006_HotelEkleme(){
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

}

