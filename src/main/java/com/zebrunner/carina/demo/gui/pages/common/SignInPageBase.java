package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterEmailAddress(String emailAddress);

    public abstract void enterPassword(String password);

    public abstract void clickSignInButton();

    public abstract boolean isErrorMessageDisplayed();

}
