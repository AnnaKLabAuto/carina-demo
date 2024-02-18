package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.components.common.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderBase getHeader();

    public abstract ProductPageBase clickProductItem();

}
