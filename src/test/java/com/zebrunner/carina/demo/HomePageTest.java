package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "useSearchTestData")
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {"Maya Tunic"},
                {"Tee"},
                {"Blouse"}
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
        for (ProductCard card: cards){
            sa.assertTrue(card.getTitleText().toLowerCase().contains(product.toLowerCase()),
                    String.format("Product with name '%s doesn't contain the product name in it's title", card.getTitleText()));
        }

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-B002")
    public void verifyCreateAccountButton(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        page.getHeader().clickCreateAccountLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after account creation doesn't match");

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-B003")
    public void verifySignInAccountButton(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        page.getHeader().clickSignInLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertTrue(actualUrl.startsWith(expectedUrl),
                "URL after clicking sign in doesn't match");

        sa.assertAll();
    }
}
