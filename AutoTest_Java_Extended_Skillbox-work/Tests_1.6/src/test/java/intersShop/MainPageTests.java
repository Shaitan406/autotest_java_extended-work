package intersShop;

import intersShop.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {
    public MainPage page;

    @BeforeEach
    public void startSetUp() {
      page = new MainPage(driver);
      page.open();
    }

    private String messageError = "Неверный заголовок станицы, на которую перешли  после клика";

    @Test
    public void mainPage_clickOnBooks_CataloguePageWithBooksWasOpened() {
        //arrange
        //act
        page.booksTab.click();
        //assert
       Assertions.assertEquals(page.getSubTitle(),"КНИГИ", messageError);
    }
    @Test
    public void mainPage_clickOnTablets_CataloguePageWithTabletWasOpened() {
        //arrange
        //act
        page.tabletsTab.click();
        //assert
        Assertions.assertEquals(page.getSubTitle(),"ПЛАНШЕТЫ", messageError);
    }
    @Test
    public void mainPage_clickOnTable_CataloguePageWithPhotoAndVideoWasOpened() {
        //arrange
        //act
        page.photoVideoTab.click();
        //assert
        Assertions.assertEquals(page.getSubTitle(),"ФОТО/ВИДЕО", messageError);
    }
    @Test
    public void practicalTests_4() {
        //arrange
        //act
        page.header.catalogueLink.click();
        //assert
        Assertions.assertEquals(page.getSubTitle(),"КАТАЛОГ", messageError);
    }
    @Test
    public void mainPage_clickOnTable_CataloguePageWitMyAccountWasOpened() {
        //arrange
        //act
        page.header.myAccountLink.click();
        //assert
        Assertions.assertEquals(page.getTitle(),"Мой Аккаунт", messageError);
    }
    @Test
    public void mainPage_clickOnTable_CataloguePageWitCheckoutTransitionBasketWasOpened() {
        //arrange
        //act
        page.header.checkoutLink.click();
        //assert
        //Assertions.assertEquals(page.getTitle(),"Корзина", messageError);
    }
    @Test
    public void mainPage_clickOnTable_CataloguePageWitTheBasketWasOpened() {
        //arrange
        //act
        page.header.cartLink.click();
        //assert
        Assertions.assertEquals(page.getTitle(),"Корзина", messageError);
    }
    @Test
    public void mainPage_CheckingForLabelsOnDiscountedProducts() {
        //arrange
        //act
        //assert
        assertSaleLabelsOnProductsWithDiscount(page);
    }
    private void assertSaleLabelsOnProductsWithDiscount(MainPage page) {
        for (int i = 0; i<page.getElements(); i++) {
           Assertions.assertTrue(page.getDiscountElements(i),"У товара нет лейбла скидки");
        }
   }
    @Test
    public void mainPage_ClickOnCheckoutLinkInMenuWithItemInCart_CartPageWasOpened() {
        //arrange
        page.productOnSale.click();
        //act
        page.header.checkoutLink.click();
        //assert
        Assertions.assertEquals(page.getTitle(),"Корзина", messageError);
    }
}

