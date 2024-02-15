package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.desktop.RegistrationPage;
import com.zebrunner.carina.demo.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//form[@id = 'search_mini_form']")
    private SearchLineComponent searchLineComponent;

    @FindBy(xpath = "//a[contains(text(), 'Sign In ')]")
    private ExtendedWebElement signInLink;

    @FindBy(xpath = "//a[contains(text(), 'Create an Account')]")
    private ExtendedWebElement createAccountLink;

    @FindBy(xpath = "//li//span[@class='logged-in']")
    private ExtendedWebElement welcomeMessage;

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
}
