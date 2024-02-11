package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.ProductPage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;

public class ProductPageTest extends AbstractTest {

    @DataProvider(name = "useTestDataClothingOptions")
    public Object[][] userSignInDataProvider() {
        return new Object[][]{
                {ProductDetail.PRODUCT_NAME2, ProductDetail.SIZE, ProductDetail.COLOR, Status.SUCCESS},
                {ProductDetail.PRODUCT_NAME2, "", ProductDetail.COLOR, Status.FAIL},
                {ProductDetail.PRODUCT_NAME2, ProductDetail.SIZE, "", Status.FAIL},
                {ProductDetail.PRODUCT_NAME2,"", "", Status.FAIL}
        };
    }

    @Test(dataProvider = "useTestDataClothingOptions", description = "JIRA#DEMO-B006")
    public void verifyAddProductToBasket(String product, String size, String color, String message){
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        SearchPage searchPage = searchLineComponent.typeSearchInputData(product);
        List<ProductCard> cards = searchPage.getCards();

        Assert.assertNotNull(cards, "Cards list is null");
        Assert.assertFalse(cards.isEmpty(), "Cards list is empty");

        cards.get(0).clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize(size);
        productPage.selectColor(color);
        productPage.clickAddToCart();

        if(!"fail".equals(message)){
            Assert.assertTrue(productPage.verifyProductAddedToCart(product), "Product was not added to the cart");
        } else {
            Assert.assertTrue(productPage.isPageOpened(), "Error");
        }
    }
}
