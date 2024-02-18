package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductPageBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.zebrunner.carina.demo.enums.ProductDetail.*;
import static com.zebrunner.carina.demo.enums.Status.FAIL;
import static com.zebrunner.carina.demo.enums.Status.SUCCESS;

public class ProductPageTest extends AbstractTest {

    @DataProvider(name = "useTestProductData")
    public Object[][] productDataProvider() {
        return new Object[][]{
                {COLOR_OPTION1, 1, SUCCESS},
                {COLOR_OPTION2, 1, SUCCESS},
                {COLOR_OPTION1, 0, FAIL},
                {COLOR_OPTION2, 0, FAIL},
        };
    }

    @Test(dataProvider = "useTestProductData", description = "JIRA#DEMO-A001")
    public void testAddProductToBasket(ProductDetail color, int quantity, Status message){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Homepage is not opened");
        ProductPageBase productPage = homePage.clickProductItem();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");

        productPage.decreaseQuantity();
        productPage.selectColor(String.valueOf(color));
        for (int i = 0; i < quantity; i++) {
            productPage.increaseQuantity();
        }
        productPage.addProductToCart();

        if(message.equals(SUCCESS)){
            Assert.assertEquals(productPage.getCartBadgeText(), "1", "Quantity doesn't show in cart badge");
        } else {
            Assert.assertFalse(productPage.isAddToCartButtonEnabled(),
                    "Button is enabled, but it shouldn't when quantity is 0");
        }
    }

    @Test(description = "JIRA#DEMO-A002")
    public void testProductCheckOut(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Homepage is not opened");
        ProductPageBase productPage = homePage.clickProductItem();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");

        productPage.addProductToCart();
        CartPageBase cartPage = productPage.clickCartBadge();
        cartPage.clickProceedToCheckOutButton();

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened after clicking Checkout button");
    }


    @BeforeMethod
    public void setDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel_3a");
        desiredCapabilities.setCapability("appium:deviceType", "phone");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:app", "=C:/Users/anna0/Documents/demo-app/Android-MyDemoAppRN.1.3.0.build-244.apk"); //link to app: https://github.com/saucelabs/my-demo-app-rn
        desiredCapabilities.setCapability("appium:appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
    }
}
