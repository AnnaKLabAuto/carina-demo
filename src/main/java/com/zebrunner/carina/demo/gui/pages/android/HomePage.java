package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.components.mobile.Header;
import com.zebrunner.carina.demo.gui.components.mobile.NavBarMenu;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='unique content desc']")
    private Header header;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='store item'])[1]")
    private ExtendedWebElement firstProductCard;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public ProductPageBase clickProductItem() {
        firstProductCard.click();
        return new ProductPage(getDriver());
    }

}
