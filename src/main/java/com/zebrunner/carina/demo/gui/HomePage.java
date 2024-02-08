package com.zebrunner.carina.demo.gui;

import com.zebrunner.carina.demo.gui.components.Footer;
import com.zebrunner.carina.demo.gui.components.Header;
import com.zebrunner.carina.demo.gui.components.MainContent;
import com.zebrunner.carina.demo.gui.components.NavSection;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {


    @FindBy(xpath = ".//header")
    private Header header;

    @FindBy(xpath = "//div[@class='sections nav-sections']")
    private NavSection navSection;

    @FindBy(xpath = "//main[@id='maincontent']")
    private MainContent mainContent;

    @FindBy(xpath = "//footer[@class='page-footer']")
    private Footer footer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public Header getHeader() {
        return header;
    }

    public NavSection getNavSection() {
        return navSection;
    }

    public MainContent getMainContent() {
        return mainContent;
    }

    public Footer getFooter() {
        return footer;
    }
}


