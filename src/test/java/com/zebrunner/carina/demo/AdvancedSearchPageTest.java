package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.gui.AdvancedSearchFormPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdvancedSearchPageTest extends AbstractTest {

    @DataProvider(name = "useAdvancedSearchTestData")
    public Object[][] searchAdvancedDataProvider() {
        return new Object[][]{
                {ProductDetail.PRODUCT_NAME1, "1", " ", " ", "12", "18", Status.SUCCESS},
                {ProductDetail.PRODUCT_NAME1, "1", " ", " ", "18", "2", Status.FAIL},
                {" ", " ", " ", " ", " ", " ", Status.FAIL},
        };
    }

    @Test(dataProvider = "useAdvancedSearchTestData", description = "JIRA#DEMO-B004")
    public void verifySearchForm(String productName, String sku, String description, String shortDescription,
                                 String priceFrom, String priceTo, String message){
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        AdvancedSearchFormPage advancedSearchForm =  page.getFooter().clickAdvancedSearchLink();
        advancedSearchForm.enterProductName(productName);
        advancedSearchForm.enterSKU(sku);
        advancedSearchForm.enterDescription(description);
        advancedSearchForm.enterShortDescription(shortDescription);
        advancedSearchForm.enterPriceFrom(priceFrom);
        advancedSearchForm.enterPriceTo(priceTo);

        SearchPage searchPage =  advancedSearchForm.clickSearchButton();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(productName.toLowerCase().replace(" ", "+")),
                "URL doesn't contain the product");
        List<ProductCard> cards = searchPage.getCards();

        if(!"fail".equals(message)){
            for (ProductCard card: cards){
                Assert.assertTrue(card.getTitleText().toLowerCase().contains(productName.toLowerCase()),
                        String.format("Product with name '%s doesn't contain the product name in it's title", card.getTitleText()));
            }
        } else {
            Assert.assertTrue(advancedSearchForm.isPageOpened(), "?");
        }
    }

}
