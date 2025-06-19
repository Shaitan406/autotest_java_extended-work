package intersShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;
    public HeaderPanel header;

    @FindBy(id = "bonus_username")
    public WebElement name;

    @FindBy(id = "bonus_phone")
    public WebElement phone;

    @FindBy(name = "bonus")
    public WebElement getCard;

    public Page(WebDriver driver, String subUrl) {
        this.driver = driver;
        header = new HeaderPanel(driver);
        PageFactory.initElements(driver,this);
        this.subUrl = subUrl;
    }
    public Page(WebDriver driver) {
        this(driver, "");
    }
    public Page open() {
         driver.navigate().to(getPageUrl());
         return this;
    }
    private String getPageUrl() {
        return url + subUrl;
    }
    private final String url = "https://intershop6.skillbox.ru/";
    private final String subUrl;

    public BonusProgramPage nameRus() {
        name.sendKeys("Вадим");
        return new BonusProgramPage(driver);
    }
    public BonusProgramPage phoneNotPlus() {
        phone.sendKeys("85295971282");
        return new BonusProgramPage(driver);
    }
    public BonusProgramPage buttonClick() {
        getCard.click();
        return new BonusProgramPage(driver);
    }
    public BonusProgramPage nameEnglish() {
        name.sendKeys("Vadim");
        return new BonusProgramPage(driver);
    }
    public BonusProgramPage phoneYesPlus() {
        phone.sendKeys("+75295971282");
        return new BonusProgramPage(driver);
    }
}
