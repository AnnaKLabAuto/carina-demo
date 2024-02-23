package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.constans.ProductDetail;
import com.zebrunner.carina.demo.constans.Status;
import com.zebrunner.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.demo.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.zebrunner.carina.demo.constans.ProductDetail.*;
import static com.zebrunner.carina.demo.constans.Status.FAIL;
import static com.zebrunner.carina.demo.constans.Status.SUCCESS;


public class ProductPageTest extends AbstractTest {

    @DataProvider(name = "useTestDataClothingOptions")
    public Object[][] userSignInDataProvider() {
        return new Object[][]{
                {PRODUCT_NAME2, SIZE, COLOR, SUCCESS},
                {PRODUCT_NAME2, INVALID, COLOR, FAIL},
                {PRODUCT_NAME2, SIZE, INVALID, FAIL},
                {PRODUCT_NAME2, INVALID, INVALID, FAIL}
        };
    }

    @Test(dataProvider = "useTestDataClothingOptions", description = "JIRA#DEMO-C001")
    public void verifyAddProductToBasket(ProductDetail productName, ProductDetail size, ProductDetail color, Status message){
        HomePageBase page = new HomePage(getDriver());
        page.open();
        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        SearchPage searchPage = searchLineComponent.typeSearchInputData(String.valueOf(productName));

        List<ProductCard> cards = searchPage.getCards();
        Assert.assertNotNull(cards, "Cards list is null");
        Assert.assertFalse(cards.isEmpty(), "Cards list is empty");

        cards.get(0).clickOnProduct();

        ProductPageBase productPage = new ProductPage(getDriver());
        productPage.selectSize(String.valueOf(size));
        productPage.selectColor(String.valueOf(color));
        productPage.clickAddToCart();

        if(message.equals(SUCCESS)){
            Assert.assertTrue(productPage.verifyProductAddedToCart(String.valueOf(productName)), "Product was not added to the cart");
        } else {
            Assert.assertTrue(productPage.isErrorMessageDisplayed(), "Error message was not displayed");
        }
    }
}
