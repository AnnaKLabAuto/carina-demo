package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.components.Footer;
import com.zebrunner.carina.demo.gui.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract Footer getFooter();

}
