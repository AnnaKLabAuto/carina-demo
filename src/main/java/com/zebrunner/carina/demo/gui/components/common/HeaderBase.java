package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.components.mobile.NavBarMenu;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {

    protected SearchContext searchContext;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        this.searchContext = searchContext;
    }

    public abstract NavBarMenu clickNavBarMenu();

}
