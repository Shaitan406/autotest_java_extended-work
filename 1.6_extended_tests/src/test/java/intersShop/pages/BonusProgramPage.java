    package intersShop.pages;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    public class BonusProgramPage extends Page {
        private final String subUrl = "bonus/";

        @FindBy(css = "#bonus_main h3") //сообщение - карта оформлена
        public WebElement successResultMessage;

        @FindBy(css = "#bonus_content") // ошибка о не заполнений телефона или имени
        public WebElement errorNameErrorPhone;

        @FindBy(css = ".current") // заголовок - бонусная программа
        public WebElement subTitle;

        public BonusProgramPage(WebDriver driver) {
            super(driver, "bonus/");
            PageFactory.initElements(driver, this);
        }
        public String getSuccessResultMessage() {
            return successResultMessage.getText();
        }
        public Boolean isSuccessResultMessageDisplayed() {
            return successResultMessage.isDisplayed();
        }
        public boolean getError() {
            return errorNameErrorPhone.isDisplayed();
        }
        public String getSubTitle() {
            return subTitle.getText();
        }
    }
