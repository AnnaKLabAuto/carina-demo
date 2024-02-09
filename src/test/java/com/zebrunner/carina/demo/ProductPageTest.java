package com.zebrunner.carina.demo;

import com.sun.source.tree.AssertTree;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.ProductPage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;

public class ProductPageTest extends AbstractTest {

    Logger logger = Logger.getLogger(ProductPageTest.class.getName());

    @Test(description = "JIRA#DEMO-B006")
    public void verifyAddProductToBasket(){
        String clothingName = "Radiant Tee";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        SearchPage searchPage = searchLineComponent.typeSearchInputData(clothingName);
        List<ProductCard> cards = searchPage.getCards();

        assertNotNull("Cards list is null", cards);
        assertFalse("Cards list is empty", cards.isEmpty());

        cards.get(0).clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize("S");
        productPage.selectColor("Orange");
        productPage.clickAddToCart();

        sa.assertTrue(productPage.verifyProductAddedToCart(clothingName), "Product was not added to the cart");

        sa.assertAll();

    }

    @Test(description = "JIRA#DEMO-B007")
    public void verifyAddProductToBasketWithoutOptions(){
        String clothingName = "t-shirt";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        SearchPage searchPage = searchLineComponent.typeSearchInputData(clothingName);
        List<ProductCard> cards = searchPage.getCards();

        assertNotNull("Cards list is null", cards);
        assertFalse("Cards list is empty", cards.isEmpty());

        cards.get(0).clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize(" ");
        productPage.selectColor(" ");
        productPage.clickAddToCart();

        sa.assertTrue(productPage.verifyCannotAddToCartWithoutSelection(), "Page display message that this is a required field");
        sa.assertAll();

    }
}
