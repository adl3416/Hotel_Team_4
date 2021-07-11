package tests;

import org.testng.annotations.BeforeClass;
import pages.US_013_Positive_RoomReservation;
import utilities.ConfigReader;
import utilities.Driver;

public class US_013 {

    US_013_Positive_RoomReservation us_013_PosRoomRes = new US_013_Positive_RoomReservation();

    @BeforeClass
    public void positiveRoomReservation(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        us_013_PosRoomRes.loginButton.click();
        us_013_PosRoomRes.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        us_013_PosRoomRes.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        us_013_PosRoomRes.loginSubmit.click();
        us_013_PosRoomRes.hotelMeagamentMenu.click();
        us_013_PosRoomRes.roomReservationMenu.click();
    }

}
