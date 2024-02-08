package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserAccountTests extends AbstractTest {

    @Test
    public void verifyCreateAccount(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickCreateAccount();

        RegistrationPage createAccountPage = new RegistrationPage(driver);

        createAccountPage.enterFirstName("Tom");
        createAccountPage.enterLastName("Smith");
        createAccountPage.enterEmailAddress("tom.smith@email.com");
        createAccountPage.enterPassword("password123!@#");
        createAccountPage.enterConfirmPassword("password123!@#");

        createAccountPage.clickCreateAccountButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after account creation doesn't match");

        sa.assertAll();
    }


    @Test
    public void verifySignIn(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress("tom.smith@email.com");
        signInPage.enterPassword("password123!@#");

        signInPage.clickSignInButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after account creation doesn't match");

        sa.assertAll();
    }
}
