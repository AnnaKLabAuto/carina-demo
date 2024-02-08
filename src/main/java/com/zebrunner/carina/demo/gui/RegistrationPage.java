package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='firstname']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private ExtendedWebElement emailAddressField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private ExtendedWebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getFirstNameField() {
        return firstNameField;
    }

    public ExtendedWebElement getLastNameField() {
        return lastNameField;
    }

    public ExtendedWebElement getEmailAddressField() {
        return emailAddressField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public ExtendedWebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.type(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.type(confirmPassword);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
}
