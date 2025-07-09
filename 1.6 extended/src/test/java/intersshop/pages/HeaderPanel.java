package intersShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPanel {

    @FindBy(xpath = "//*[contains(@class,'menu')]/*[contains(@class,'menu-item')]/a[text()='Каталог']")
    public WebElement catalogueLink;

    @FindBy(xpath = "//*[contains(@class,'menu')]/*[contains(@class,'menu-item')]/a[text()='Мой аккаунт']")
    public WebElement myAccountLink;

    @FindBy(xpath = "//*[contains(@class,'menu')]/*[contains(@class,'menu-item')]/a[text()='Корзина']")
    public WebElement cartLink;

    @FindBy(xpath = "//*[contains(@class,'menu')]/*[contains(@class,'menu-item')]/a[text()='Оформление заказа']")
    public WebElement checkoutLink;

    private final WebDriver driver;
    public HeaderPanel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public Page checkOnCheckout()
    {
        checkoutLink.click();
        return new Page(driver);
    }
    public Page clickOnMyAccount()
    {
        myAccountLink.click();
        return new Page(driver);
    }
    public Page clickOnCart(){
        cartLink.click();
        return new Page(driver);
    }
    public Page clickOnCatalogueLink() {
        catalogueLink.click();
        return new Page(driver);
    }
}

