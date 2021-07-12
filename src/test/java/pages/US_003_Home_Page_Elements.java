package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_003_Home_Page_Elements {

        public US_003_Home_Page_Elements() {

            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy (xpath = "//div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]")
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

        @FindBy (partialLinkText = "Blog")
        public WebElement blogText;

        @FindBy (xpath = "(//a[@class='nav-link'])[7]")
        public WebElement loginButton;

        @FindBy (partialLinkText = "Log in")
        public WebElement loginText;

        @FindBy (xpath = "//input[@type='submit']")
        public WebElement checkAvailabilityButton;

        @FindBy (id= "checkin_date")
        public WebElement checkinBox;

        @FindBy (xpath= "/html/body/div[2]/div[1]/table/tbody/tr[4]/td[3]")
        public WebElement checkinDay;

        @FindBy(id = "checkout_date")
        public WebElement checkoutBox;

        @FindBy (xpath= "/html/body/div[2]/div[1]/table/tbody/tr[4]/td[7]")
        public WebElement checkoutDay;

        @FindBy(id = "IDRoomType")
        public WebElement roomTypeDropDown;

        @FindBy(id = "AdultCount")
        public WebElement customerDropDown;

        @FindBy(xpath = "(//tr//td)[22]")
        public WebElement checkindatePicker;



        public String carousel(){
        List<WebElement> carouselList = Driver.getDriver().
                findElements(By.xpath("//section[@class='home-slider owl-carousel owl-loaded owl-drag']"));

        ArrayList list1 = new ArrayList();
        String text = null;
        for (int i = 0; i < carouselList.size(); i++) {
                int index = i + 1;
                WebElement welcometext=Driver.getDriver().
                        findElement(By.xpath("//div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]"));

        text = welcometext.getText();
        list1.add(text);
        System.out.println(text);

        }
                return text;
}
}
