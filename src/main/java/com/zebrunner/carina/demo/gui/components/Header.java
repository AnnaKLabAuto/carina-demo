package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.demo.gui.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//form[@class= 'form minisearch']")
    private SearchLineComponent searchLineComponent;

    @FindBy(xpath = "//a[contains(@href, '/customer/account/login/')]")
    private ExtendedWebElement signInLink;

    @FindBy(xpath = "//a[contains(@href, '/customer/account/create/')]")
    private ExtendedWebElement createAccountLink;

    @FindBy(xpath = "//li[@class='greet welcome']//span[@class='logged-in']")
    private ExtendedWebElement welcomeMessage;

    @FindBy(xpath = "//button[contains(@class, 'customer-name') and contains(text(), 'Change')]")
    private ExtendedWebElement changeButton;

    @FindBy(xpath = "//li[@class='authorization-link']//a[contains(text(), 'Sign Out')]")
    private ExtendedWebElement signOutLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }

    public SignInPage clickSignInLink() {
        signInLink.click();
        return new SignInPage(getDriver());
    }

    public RegistrationPage clickCreateAccountLink() {
        createAccountLink.click();
        return new RegistrationPage(getDriver());
    }

    public boolean isUsernameInWelcomeMessage(String username) {
        String welcomeMessageText = welcomeMessage.getText();
        return welcomeMessageText.contains(username);
    }

    public void clickUserAccount(){
        changeButton.click();
    }

    public void clickSignOut(){
        signOutLink.click();
    }
}
