package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.demo.gui.components.Footer;
import com.zebrunner.carina.demo.gui.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = ".//header")
    private Header header;

    @FindBy(xpath = ".//footer")
    private Footer footer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}


