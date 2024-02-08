package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {
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

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
