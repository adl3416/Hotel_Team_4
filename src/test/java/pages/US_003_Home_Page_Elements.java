package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

    public class US_003_Home_Page_Elements {

        public US_003_Home_Page_Elements() {

            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy (xpath = "(//*[contains(text(),'Welcome To Koala')])[3]")
        public WebElement welcomeText;

        @FindBy (xpath = "//a[@class='navbar-brand']")
        public WebElement koalaResortText;

        @FindBy (xpath = "(//a[@class='nav-link'])[1]")
        public WebElement homeButton;

        @FindBy (xpath = "(//a[@class='nav-link'])[2]")
        public WebElement roomsButton;

        @FindBy (xpath = "(//a[@class='nav-link'])[3]")
        public WebElement restaurantButton;

        @FindBy (linkText = "About")
        public WebElement aboutButton;

        @FindBy (xpath = "(//a[@class='nav-link'])[5]")
        public WebElement blogButton;

        @FindBy (xpath = "(//a[@class='nav-link'])[7]")
        public WebElement loginButton;

        @FindBy (xpath = "//input[@type='submit']")
        public WebElement checkAvailabilityButton;

        @FindBy (id= "checkin_date")
        public WebElement checkinBox;

        @FindBy(id = "checkout_date")
        public WebElement checkoutBox;

        @FindBy(id = "IDRoomType")
        public WebElement roomTypeDropDown;

        @FindBy(id = "AdultCount")
        public WebElement customerDropDown;



}
