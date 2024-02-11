package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchFormPage extends AbstractPage {

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='name']")
    private ExtendedWebElement productNameInput;

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='sku']")
    private ExtendedWebElement skuInput;

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='description']")
    private ExtendedWebElement descriptionInput;

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='short_description']")
    private ExtendedWebElement shortDescriptionInput;

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='price[from]']")
    private ExtendedWebElement priceFromInput;

    @FindBy(xpath = "//form[@class='form search advanced']//input[@name='price[to]']")
    private ExtendedWebElement priceToInput;

    @FindBy(xpath = "//form[@class='form search advanced']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    public AdvancedSearchFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterProductName(String productName) {
        productNameInput.type(productName);
    }

    public void enterSKU(String sku) {
        skuInput.type(sku);
    }

    public void enterDescription(String description) {
        descriptionInput.type(description);
    }

    public void enterShortDescription(String shortDescription) {
        shortDescriptionInput.type(shortDescription);
    }

    public void enterPriceFrom(String priceFrom) {
        priceFromInput.type(priceFrom);
    }

    public void enterPriceTo(String priceTo) {
        priceToInput.type(priceTo);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }


}
