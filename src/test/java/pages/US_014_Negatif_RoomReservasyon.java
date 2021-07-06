package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_014_Negatif_RoomReservasyon {

    public US_014_Negatif_RoomReservasyon(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy
    public WebElement hotelListManagementButton;



}
