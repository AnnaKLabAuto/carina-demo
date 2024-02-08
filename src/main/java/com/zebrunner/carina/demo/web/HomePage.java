package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = ".//header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public Header getHeader() {
        return header;
    }
}


