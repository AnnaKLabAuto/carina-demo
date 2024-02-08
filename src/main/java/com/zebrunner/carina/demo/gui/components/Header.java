package com.zebrunner.carina.demo.gui.components;

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


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }

    public void clickSignIn() {
        signInLink.click();
    }

    public void clickCreateAccount() {
        createAccountLink.click();
    }
}
