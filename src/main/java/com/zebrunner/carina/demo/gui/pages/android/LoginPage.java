package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Username input field']")
    private ExtendedWebElement userInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Username-error-message']")
    private ExtendedWebElement usernameErrorMessage;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Password input field']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Password-error-message']")
    private ExtendedWebElement passwordErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void putUserDataToForm(String user, String password){
        userInput.type(user);
        passwordInput.type(password);
    }

    public boolean isErrorMessageDisplayed() {
        return usernameErrorMessage.isElementPresent() || passwordErrorMessage.isElementPresent();
    }
}
