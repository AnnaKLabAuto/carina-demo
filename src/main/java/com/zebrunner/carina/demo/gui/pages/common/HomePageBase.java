package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.components.footer.Footer;
import com.zebrunner.carina.demo.gui.components.header.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public abstract Header getHeader();

    public abstract Footer getFooter();

}
