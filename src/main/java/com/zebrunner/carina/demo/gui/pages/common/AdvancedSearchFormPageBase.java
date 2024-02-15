package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AdvancedSearchFormPageBase extends AbstractPage {

    public AdvancedSearchFormPageBase(WebDriver driver) {
        super(driver);
    }
}
