package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainContent extends AbstractUIObject {
    @FindBy(xpath = "//li[@class='product-item']")
    private List<ProductCard> productItems;

    private WebDriver driver;

    public MainContent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


//    public List<ProductCard> getProductCards() {
//        List<ProductCard> productCards = new ArrayList<>();
//
//        for (ProductCard productItem : productItems) {
//            productCards.add(new ProductCard(driver, productItem));
//        }
//
//        return productCards;
//    }
//
//    public void clickOnProductCardByName(String name) {
//        List<ProductCard> productCards = getProductCards();
//        for (ProductCard productCard : productCards) {
//            if (productCard.getTitleText().equals(name)) {
//                productCard.clickOnProduct();
//                break;
//            }
//        }
//    }
}
