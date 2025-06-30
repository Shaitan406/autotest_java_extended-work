package intersShop;

import intersShop.pages.BonusProgramPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusProgramPageTests extends TestBase {
    public BonusProgramPage page;

    private final String massageForWrongResultText = "Неверное сообщение заголовка об успешном оформлении карты";
    private final String massageForInvisibleResultText = "Не отоброжается сообщение при успешном оформлении карты";
    private final String errorMassageForNameAndPhone = "Нету сообщения об ошибки не ввода данных в строку имени и телефона";

    @BeforeEach
    public void start() {
    page = new BonusProgramPage(driver);
    page.open();
    }
    
    @Test
    public void bonusProgramPage_FillFormWithPhoneWith8_Success() {
        //arrange
        var page = new BonusProgramPage(driver)
                    .open()
        //act
                    .nameRus()
                    .phoneNotPlus()
                    .buttonClick();
        //Assert
        Assertions.assertEquals(page.getSubTitle(),"Бонусная Программа", massageForWrongResultText);
        Assertions.assertTrue(page.isSuccessResultMessageDisplayed(), massageForInvisibleResultText);
        Assertions.assertEquals(page.getSuccessResultMessage(),"Ваша карта оформлена!", massageForWrongResultText);
    }
    @Test
    public void bonusProgramPage_FillFornWithPhoneWith7_Success() {
        //arrange
        var page = new BonusProgramPage(driver)
                    .open()
        //act
                    .nameEnglish()
                    .phoneYesPlus()
                    .buttonClick();
        //Assert
        Assertions.assertEquals(page.getSubTitle(),"Бонусная Программа", massageForWrongResultText);
        Assertions.assertTrue(page.isSuccessResultMessageDisplayed(), massageForInvisibleResultText);
        Assertions.assertEquals(page.getSuccessResultMessage(),"Ваша карта оформлена!", massageForWrongResultText);
    }
    @Test
    public void bonusProgramPage_NotName() {
        //arrange
        //act
        page.phone.sendKeys("+85295971282");
        page.getCard.click();
        //Assert
        Assertions.assertTrue(page.getError(), errorMassageForNameAndPhone);
    }
    @Test
    public void bonusProgramPage_NotPhone() {
        //arrange
        //act
        page.name.sendKeys("Вадим");
        page.getCard.click();
        //Assert
        Assertions.assertTrue(page.getError(), errorMassageForNameAndPhone);
    }
    @Test
    public void bonusProgramPage_NotNameAndPhone() {
        //arrange
        //act
        page.getCard.click();
        //Assert
        Assertions.assertTrue(page.getError(), errorMassageForNameAndPhone);
    }
}
