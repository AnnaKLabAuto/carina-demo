package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.pages.android.CartPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void increaseQuantity();

    public abstract void decreaseQuantity();

    public abstract void addProductToCart();

    public abstract boolean isAddToCartButtonEnabled();

    public abstract void selectColor(String color);

    public abstract String getCartBadgeText();

    public abstract CartPageBase clickCartBadge();
}
