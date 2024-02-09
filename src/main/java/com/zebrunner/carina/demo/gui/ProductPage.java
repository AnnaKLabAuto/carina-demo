package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//form[@id='product_addtocart_form']")
    private ExtendedWebElement addToCartForm;

    @FindBy(xpath = "//div[@class='swatch-attribute size']//div[@class='swatch-option text']")
    private List<ExtendedWebElement> sizeOptions;

    @FindBy(xpath = "//div[@class='swatch-attribute color']//div[@class='swatch-option color']")
    private List<ExtendedWebElement> colorOptions;

    @FindBy(xpath = "//input[@id='qty']")
    private ExtendedWebElement quantityInput;

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private ExtendedWebElement addToCartButton;

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
}
