package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.AdvancedSearchPage;
import com.zebrunner.carina.demo.gui.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchPageTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-B004")
    public void verifySearchForm(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getFooter().clickAdvancedSearchLink();

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);

        advancedSearchPage.enterProductName("Tank");
        advancedSearchPage.enterPriceFrom("12");
        advancedSearchPage.enterPriceTo("18");

        advancedSearchPage.clickSearchButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/catalogsearch/advanced/result/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertTrue(actualUrl.startsWith(expectedUrl),
                "URL doesn't start with the expected URL after performing an advanced search");

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-B005")
    public void verifySearchFormWithInvalidData(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getFooter().clickAdvancedSearchLink();

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);

        advancedSearchPage.enterProductName("466yuj");
        advancedSearchPage.enterPriceFrom("12");
        advancedSearchPage.enterPriceTo("2");

        advancedSearchPage.clickSearchButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/catalogsearch/advanced/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl,
                "URL doesn't match the expected URL after submitting the form with invalid data");

        sa.assertAll();
    }

}
