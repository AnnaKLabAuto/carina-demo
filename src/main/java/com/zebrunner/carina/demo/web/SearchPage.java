package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'item product product-item')]")
    private List<ProductCard> cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
