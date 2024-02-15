package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.components.Header;
import com.zebrunner.carina.demo.gui.pages.common.RegistrationPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends RegistrationPageBase {

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

    public void putDataToForm(String firstName, String lastName, String email, String password, String confirmPassword){
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        emailAddressField.type(email);
        passwordField.type(password);
        confirmPasswordField.type(confirmPassword);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }


}
