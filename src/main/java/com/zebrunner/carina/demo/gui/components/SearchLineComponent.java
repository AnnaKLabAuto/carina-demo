package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='search']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public SearchPage typeSearchInputData(String value){
        searchInput.type(value + Keys.ENTER);
        return new SearchPage(getDriver());
    }

}
