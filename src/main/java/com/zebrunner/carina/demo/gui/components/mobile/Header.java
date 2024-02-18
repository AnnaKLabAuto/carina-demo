package com.zebrunner.carina.demo.gui.components.mobile;

import com.zebrunner.carina.demo.gui.components.common.HeaderBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends HeaderBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']")
    private ExtendedWebElement navBarMenuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='menu item log in']")
    private ExtendedWebElement logInLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        this.searchContext = searchContext;
    }

    public SearchContext getSearchContext() {
        return this.searchContext;
    }

    @Override
    public NavBarMenu clickNavBarMenu() {
        navBarMenuButton.click();
        return new NavBarMenu(getDriver(), getSearchContext());
    }
}
