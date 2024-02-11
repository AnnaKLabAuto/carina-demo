package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailAddressField;

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@id='send2']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[@class='messages']//div[@class='message-error error message']//div")
    private ExtendedWebElement errorMessage;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getEmailAddressField() {
        return emailAddressField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.type(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isElementPresent();
    }
}
