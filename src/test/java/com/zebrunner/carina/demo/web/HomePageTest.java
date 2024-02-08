package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.web.HomePage;
import com.zebrunner.carina.demo.web.components.ProductCard;
import com.zebrunner.carina.demo.web.components.SearchLineComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchLineTest(){
        String clothingName = "Maya Tunic";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();

        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),
                "Search input is not present");

        //TODO: check button enabling
//        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1),
//                "Search button is not present");

        SearchPage searchPage = searchLineComponent.typeSearchInputData(clothingName);

        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains(clothingName.toLowerCase().replace(" ", "+")),
                "URL doesn't contain the product");

        List<ProductCard> cards = searchPage.getCards();
        for (ProductCard card: cards){
            sa.assertTrue(card.getTitleText().toLowerCase().contains(clothingName.toLowerCase()),
                    String.format("Product with name '%s doesn't contain the product name in it's title", card.getTitleText()));
        }

        sa.assertAll();
    }
}
