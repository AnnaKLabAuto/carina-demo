package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//strong[@class='product name product-item-name']/a")
    private ExtendedWebElement titleElement;

    @FindBy(xpath = "//div[@class='reviews-actions a view']")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//button[@class='action tocart primary']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action towishlist']")
    private ExtendedWebElement wishlistButton;

    @FindBy(xpath = "//a[@class='action tocompare']")
    private ExtendedWebElement compareButton;

    private Actions actions;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        this.actions = new Actions(driver);
    }

    public ExtendedWebElement getTitleElement() {
        return titleElement;
    }

    public ExtendedWebElement getReviewsLink() {
        return reviewsLink;
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public ExtendedWebElement getWishlistButton() {
        return wishlistButton;
    }

    public ExtendedWebElement getCompareButton() {
        return compareButton;
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public String getProductName() {
        return titleElement.getText();
    }

    public void clickOnProduct() {
        titleElement.click();
    }
}
