package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class US_004_HomePage {
    //  (//button[@class='owl-dot'])[3]
    public US_004_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //(//span[@class='text'])[3]
    @FindBy(xpath="//span[contains(text(),'info@koalaresorthotels.com')]")
    public WebElement anaSayfaEmailYazisi;
    @FindBy(xpath="//span[text()='9 E. Loockerman street, suite 241 Dover, DE 19901']")
    public WebElement anaSayfaAdresYazisi;
    @FindBy(xpath="(//span[@class='text'])[2]")
    public WebElement anaSayfaIletisimNoYazisi;
    //@FindBy(xpath="(//p[contains(text(),'As I stayed,')])[1]")
    @FindBy(xpath=("//div[6]/div[1]/div[1]/div[2]/p[1]"))
    public WebElement anaSayfaEltonSmithYazisi;
    @FindBy(xpath="//div[@class='carousel-testimony owl-carousel ftco-owl owl-loaded owl-drag']")
    public WebElement carouselElementi;
}
