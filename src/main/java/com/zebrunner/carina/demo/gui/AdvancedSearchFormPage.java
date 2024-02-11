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
