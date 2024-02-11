package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "useSearchTestData")
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {ProductDetail.PRODUCT_NAME1},
                {ProductDetail.PRODUCT_NAME2},
        };
    }

    @Test(dataProvider = "useSearchTestData", description = "JIRA#DEMO-B001")
    public void verifySearchLineTest(String product){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),
                "Search input is not present");

        SearchPage searchPage = searchLineComponent.typeSearchInputData(product);
        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains(product.toLowerCase().replace(" ", "+")),
                "URL doesn't contain the product");

        List<ProductCard> cards = searchPage.getCards();
        Assert.assertNotNull(cards, "Cards list is null");
        Assert.assertFalse(cards.isEmpty(), "Cards list is empty");

        for (ProductCard card: cards){
            sa.assertTrue(card.getTitleText().toLowerCase().contains(product.toLowerCase()),
                    String.format("Product with name '%s doesn't contain the product name in it's title", card.getTitleText()));
        }

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-B002")
    public void verifyCreateAccountButton(){
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickCreateAccountLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl), "URL after account creation doesn't match");
    }

    @Test(description = "JIRA#DEMO-B003")
    public void verifySignInAccountButton(){
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickSignInLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl),
                "URL after clicking sign in doesn't match");
    }
}
