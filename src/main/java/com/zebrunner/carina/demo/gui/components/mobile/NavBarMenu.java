package com.zebrunner.carina.demo.gui.components.mobile;

import com.zebrunner.carina.demo.gui.components.common.NavBarMenuBase;
import com.zebrunner.carina.demo.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBarMenu extends NavBarMenuBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='menu item log in']")
    private ExtendedWebElement logInLink;

    public NavBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public LoginPage clickLogInLink() {
        logInLink.click();
        return new LoginPage(getDriver());
    }
}
