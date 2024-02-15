package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchFormPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='name']")
    private ExtendedWebElement productNameInput;

    @FindBy(xpath = "//input[@name='sku']")
    private ExtendedWebElement skuInput;

    @FindBy(xpath = "//input[@name='description']")
    private ExtendedWebElement descriptionInput;

    @FindBy(xpath = "//input[@name='short_description']")
    private ExtendedWebElement shortDescriptionInput;

    @FindBy(xpath = "//input[@name='price[from]']")
    private ExtendedWebElement priceFromInput;

    @FindBy(xpath = "//input[@name='price[to]']")
    private ExtendedWebElement priceToInput;

    @FindBy(xpath = "//button[@class='action search primary']")
    private ExtendedWebElement searchButton;

    public AdvancedSearchFormPage(WebDriver driver) {
        super(driver);
    }

    public void putDataToSearchForm(String productName, String sku, String description, String shortDescription, String priceFrom, String priceTo){
        productNameInput.type(productName);
        skuInput.type(sku);
        descriptionInput.type(description);
        shortDescriptionInput.type(shortDescription);
        priceFromInput.type(priceFrom);
        priceToInput.type(priceTo);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }


}
