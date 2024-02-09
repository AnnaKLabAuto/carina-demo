package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserAccountTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-B008")
    public void verifyCreateAccount(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickCreateAccount();

        RegistrationPage createAccountPage = new RegistrationPage(driver);

        createAccountPage.enterFirstName("Thomas");
        createAccountPage.enterLastName("Smith");
        createAccountPage.enterEmailAddress("thomas.smith@email.com");
        createAccountPage.enterPassword("password123!@#");
        createAccountPage.enterConfirmPassword("password123!@#");

        createAccountPage.clickCreateAccountButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after account creation doesn't match");

        sa.assertAll();
    }

    @Test(description = "JIRA#DEMO-B009")
    public void verifyCreateAccountWithInvalidInput() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickCreateAccount();

        RegistrationPage createAccountPage = new RegistrationPage(driver);

        createAccountPage.enterFirstName("#$%");
        createAccountPage.enterLastName("@#");
        createAccountPage.enterEmailAddress("invalid email");
        createAccountPage.enterPassword("");
        createAccountPage.enterConfirmPassword("8ui90");

        createAccountPage.clickCreateAccountButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after failed account creation doesn't match");

        sa.assertAll();
    }


    @Test(description = "JIRA#DEMO-B010")
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

    @Test(description = "JIRA#DEMO-B011")
    public void verifySignInWithInvalidCredentials() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress("%^ffemail@email.com");
        signInPage.enterPassword("56g#$");

        signInPage.clickSignInButton();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertTrue(actualUrl.startsWith(expectedUrl), "URL after failed sign-in doesn't start with the expected URL");

        sa.assertAll();
    }
}
