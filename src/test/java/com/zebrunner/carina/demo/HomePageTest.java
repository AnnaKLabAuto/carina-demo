package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.zebrunner.carina.demo.enums.ProductDetail.PRODUCT_NAME1;
import static com.zebrunner.carina.demo.enums.ProductDetail.PRODUCT_NAME2;

public class HomePageTest extends AbstractTest {

    private HomePage page;

    private WebDriver driver;

    @BeforeMethod
    public void getHomePage() {
        driver = getDriver();
        page = new HomePage(driver);
        page.open();
    }

    @DataProvider(name = "useSearchTestData")
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {PRODUCT_NAME1},
                {PRODUCT_NAME2},
        };
    }

    @Test(dataProvider = "useSearchTestData", description = "JIRA#DEMO-A001")
    public void verifySearchLineTest(ProductDetail product){
        SoftAssert sa = new SoftAssert();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),
                "Search input is not present");

        SearchPage searchPage = searchLineComponent.typeSearchInputData(String.valueOf(product));
        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains(String.valueOf(product).toLowerCase()
                        .replace(" ", "+")), "URL doesn't contain the product");

        List<ProductCard> cards = searchPage.getCards();
        Assert.assertNotNull(cards, "Cards list is null");
        Assert.assertFalse(cards.isEmpty(), "Cards list is empty");

        for (ProductCard card: cards){
            sa.assertTrue(card.getTitleText().toLowerCase().contains(String.valueOf(product).toLowerCase()),
                    String.format("Product with name '%s doesn't contain the product name in it's title",
                            card.getTitleText()));
        }

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-A002")
    public void verifyCreateAccountButton(){
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickCreateAccountLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl), "URL after account creation doesn't match");
    }

    @Test(description = "JIRA#DEMO-A003")
    public void verifySignInAccountButton(){
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickSignInLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl), "URL after clicking sign in doesn't match");
    }
}
