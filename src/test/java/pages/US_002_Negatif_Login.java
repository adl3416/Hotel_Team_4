package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;



public class US_002_Negatif_Login {

    public US_002_Negatif_Login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "navLogon")
    public WebElement ilkLoginButonu;

    @FindBy(css = "#UserName")
    public WebElement username;

    @FindBy(css = "#Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement sonLoginButonu;

    @FindBy(id = "divMessageResult")
    public WebElement girisYapilamadiYazisi;

    @FindBy(xpath = "(//label[text()='This field is required.'])[1]")
    public WebElement bosbutonYazisi;




}
