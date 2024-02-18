package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class NavBarMenuBase extends AbstractUIObject {

    public NavBarMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract LoginPage clickLogInLink();
}
