package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListComponent extends AbstractUIObject {
    @FindBy(xpath = "//li[@class='product-item']")
    private List<ProductCard> cards;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
