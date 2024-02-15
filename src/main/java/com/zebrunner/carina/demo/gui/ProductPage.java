package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='swatch-option text']")
    private List<ExtendedWebElement> sizeOptions;

    @FindBy(xpath = "//div[@class='swatch-option color']")
    private List<ExtendedWebElement> colorOptions;

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private ExtendedWebElement successMessageElement;

    @FindBy(xpath = "//div[@id='super_attribute[143]-error']")
    private ExtendedWebElement errorMessageElementSize;

    @FindBy(xpath = "//div[@id='super_attribute[93]-error']")
    private ExtendedWebElement errorMessageElementColor;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize(String size) {
        for (ExtendedWebElement option : sizeOptions) {
            if (option.getText().equals(size)) {
                option.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        for (ExtendedWebElement option : colorOptions) {
            if (option.getAttribute("aria-label").equals(color)) {
                option.click();
                break;
            }
        }
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public boolean verifyProductAddedToCart(String product) {
        String expectedMessage = "You added " + product + " to your shopping cart.";
        return successMessageElement.getText().equals(expectedMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return (errorMessageElementSize.isDisplayed() && errorMessageElementSize.getText().equals("This is a required field."))
                || (errorMessageElementColor.isDisplayed() && errorMessageElementColor.getText().equals("This is a required field."));
    }
}
