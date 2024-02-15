package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RegistrationPageBase extends AbstractPage {

    public RegistrationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void putDataToForm(String firstName, String lastName, String email, String password, String confirmPassword);

    public abstract void clickCreateAccountButton();
}
