package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import com.zebrunner.carina.demo.gui.components.SearchLineComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.zebrunner.carina.demo.enums.ProductDetail.PRODUCT_NAME1;
import static com.zebrunner.carina.demo.enums.ProductDetail.PRODUCT_NAME2;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "useSearchTestData")
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {PRODUCT_NAME1},
                {PRODUCT_NAME2},
        };
    }

    @Test(dataProvider = "useSearchTestData", description = "JIRA#DEMO-A001")
    public void verifySearchLineTest(ProductDetail product){
        HomePageBase page = new HomePage(getDriver());

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),
                "Search input is not present");

        SearchPage searchPage = searchLineComponent.typeSearchInputData(String.valueOf(product));
        Assert.assertTrue(page.getCurrentUrl().toLowerCase().contains(String.valueOf(product).toLowerCase()
                        .replace(" ", "+")), "URL doesn't contain the product");

        List<ProductCard> cards = searchPage.getCards();
        Assert.assertNotNull(cards, "Cards list is null");
        Assert.assertFalse(cards.isEmpty(), "Cards list is empty");

        for (ProductCard card: cards){
            Assert.assertTrue(card.getTitleText().toLowerCase().contains(String.valueOf(product).toLowerCase()),
                    String.format("Product with name '%s doesn't contain the product name in it's title",
                            card.getTitleText()));
        }
    }

    @Test(description = "JIRA#DEMO-A002")
    public void verifyCreateAccountButton(){
        HomePageBase page = new HomePage(getDriver());
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickCreateAccountLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = page.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl), "URL after account creation doesn't match");
    }

    @Test(description = "JIRA#DEMO-A003")
    public void verifySignInAccountButton(){
        HomePageBase page = new HomePage(getDriver());
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");
        page.getHeader().clickSignInLink();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/";
        String actualUrl = page.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl), "URL after clicking sign in doesn't match");
    }
}
