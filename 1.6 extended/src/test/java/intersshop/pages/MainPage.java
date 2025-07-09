package intersShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page {

    private final String url = "https://intershop6.skillbox.ru/";

    @FindBy(css = ".current" )
    public WebElement title;

    @FindBy(xpath = "//*[@class='widget-title'][text()='Книги']")
    public WebElement booksTab;

    @FindBy(xpath = "//*[@class='widget-title'][text()='Планшеты']")
    public WebElement tabletsTab;

    @FindBy(xpath = "//*[@class='widget-title'][text()='Фотоаппараты']")
    public WebElement photoVideoTab;

    @FindBy(css = "header.entry-header h1")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@id='product1']//li[@aria-hidden='false'][1]//*[contains(@class,'item-img')]")
    public WebElement productOnSale;

    @FindBy(css = "#product1 li[aria-hidden='false'] .item-img span")
    public List<WebElement> allProductLabels;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Page open() {
        driver.navigate().to(url);
        return this;
    }
    public boolean getDiscountElements(int index) {
        return allProductLabels.get(index).getAttribute("class").contains("onsale");
    }
    public int getElements() {
        return allProductLabels.size();
    }
    public String getSubTitle() {
        return subTitle.getText();
    }
    public String getTitle() {
        return title.getText();
    }
}
