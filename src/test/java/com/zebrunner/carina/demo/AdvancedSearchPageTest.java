package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.AdvancedSearchPage;
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
                {"Tank", "1", "Description", "Short Description", "12", "18"},
        };
    }

    @Test(dataProvider = "useAdvancedSearchTestData", description = "JIRA#DEMO-B004")
    public void verifySearchForm(String productName, String sku, String description, String shortDescription, String priceFrom, String priceTo){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");


        AdvancedSearchPage advancedSearchPage =  page.getFooter().clickAdvancedSearchLink();
        advancedSearchPage.enterProductName(productName);
        advancedSearchPage.enterPriceFrom(priceFrom);
        advancedSearchPage.enterPriceTo(priceTo);

        advancedSearchPage.clickSearchButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/catalogsearch/advanced/result/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertTrue(actualUrl.startsWith(expectedUrl),
                "URL doesn't start with the expected URL after performing an advanced search");

        sa.assertAll();
    }

}
