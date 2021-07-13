package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_004_HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;

public class US_004 {

    US_004_HomePage homePage=new US_004_HomePage();

    @Test(priority = 2,enabled = true,description = "AnaSayfa'nin Url ve Title kisminin dogrulanmasi")
    public void anaSayfanTitleVeUrlDogrulamasi(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        String actualHomeUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl=ConfigReader.getProperty("kr_url");
        System.out.println("AnaSayfa'nin Url bilgisi: "+actualHomeUrl);
        Assert.assertEquals(actualHomeUrl,expectedUrl);
        String actualHomeTitle= Driver.getDriver().getTitle();
        System.out.println("AnaSayfa'nin Title bilgisi: "+actualHomeTitle);
        String expectedHomeTitle="KoalaResortHotels - Home";
        Assert.assertEquals(actualHomeTitle,expectedHomeTitle);

    }
    @Test(priority = 1,enabled = true,description = "AnaSayfa'nin tam olarak yuklenmesi")
    public void anaSayfaninYuklenmesi(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.pageisLoaded();

    }
    @Test(priority = 3,enabled = true,description = "AnaSayfa'nin en altindaki email bilgisi")
    public void anaSayfaEmailYazisiDogrulamasi(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        enAltaGit();
        String actualEmailyazisi=homePage.anaSayfaEmailYazisi.getText();
        System.out.println("Anasayfadaki email bilgisi: "+actualEmailyazisi);
        String expectedEmailYazisi="info@koalaresorthotels.com";
        Assert.assertEquals(actualEmailyazisi,expectedEmailYazisi);

    }
    @Test(priority = 4,enabled = true,description = "AnaSayfa'nin en altindaki adres bilgisi")
    public void anaSayfaAdresYazisiDogrulamasi(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.scrollDownByJS();
        String actualadresYazisi= homePage.anaSayfaAdresYazisi.getText();
        System.out.println("Anasayfadaki adres bilgisi: "+actualadresYazisi);
        String expectedAdresYazisi="9 E. Loockerman street, suite 241 Dover, DE 19901";
        Assert.assertEquals(actualadresYazisi,expectedAdresYazisi);

    }
    @Test(priority = 5,enabled = true,description = "AnaSayfa'nin en altindaki iletisim no bilgisi")
    public void anasayfaIletisimNoDogrulanmasi(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.scrollDownByJS();
        String actualIletsimNo= homePage.anaSayfaIletisimNoYazisi.getText();
        System.out.println("Anasayfadaki iletisim no bilgisi: "+actualIletsimNo);
        String expectedIletisimNo="302 718 2180";
        Assert.assertEquals(actualIletsimNo,expectedIletisimNo);

    }
    @Test(priority = 6,enabled = true,description = "AnaSayfadaki iletisim bilgilerine ait elementlerin gorunulur olmasi")
    public void iletisimBilgileriElementGorunurlugu(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        JSUtils.scrollDownByJS();
        Assert.assertTrue(homePage.anaSayfaEmailYazisi.isDisplayed());
        Assert.assertTrue(homePage.anaSayfaAdresYazisi.isDisplayed());
        Assert.assertTrue(homePage.anaSayfaIletisimNoYazisi.isDisplayed());
        System.out.println("Iletisim Bilgileri Elementleri gorulebilir konumdadir," +
                "test basarili bir sekilde calistirilmistir");

    }
    @Test(priority = 7,enabled = true,description = "Misafir yorumlarindan Elton Smith'in yorumunun dogrulanmasi")
    public void anaSayfakullaniciYorumuDogrulanmasiVeCarouselHandle(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        WebElement misafirYorum=homePage.anaSayfaEltonSmithYazisi;
        //Sayfanin ortasina gitmek icin asagidaki Javascript yontemi kullanilir.
        JavascriptExecutor j = (JavascriptExecutor) Driver.getDriver();
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", misafirYorum);
        ReusableMethods.waitForVisibility(homePage.carouselElementi,15);
        //Carouseldeki itemleri almak icin
        List <WebElement> names= Driver.getDriver().findElements(By.xpath("//div[@class='carousel-testimony owl-carousel ftco-owl owl-loaded owl-drag']"));
        ArrayList list1 = new ArrayList();
        String name;
        for (int i = 0; i<names.size(); i++){
            int index = i+1;
            name = Driver.getDriver().findElement(By.xpath("//div[6]/div[1]/div[1]/div[2]/p[1]")).getText();
            list1.add(name);
            System.out.println(name);
        }
        String actualMisafirYorum=homePage.anaSayfaEltonSmithYazisi.getText();
        System.out.println("Elton Smith'in otel hakkinda yorumu: "+actualMisafirYorum);
        String expectedMisafirYorum="As I stayed, the sea was good, the service was good, the location was good.";
        Assert.assertEquals(actualMisafirYorum,expectedMisafirYorum);
        Driver.closeDriver();

    }
    public void enAltaGit(){
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
    }

}
