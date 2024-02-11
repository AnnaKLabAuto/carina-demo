package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserAccountTest implements IAbstractTest {

//    @BeforeTest
//    @Override
//    public WebDriver getDriver(){
//        return getDriver();
//    }

    @DataProvider(name = "useTestDataSignIn")
    public Object[][] userSignInDataProvider() {
        return new Object[][]{
                {"thomas.smith@email.com", "password123!@#", "success"},
                {"thomas@email.com", "password123!@#", "fail"},
                {"thomas.smith@email.com",  "password", "fail"}
        };
    }

    @Test(dataProvider = "useTestDataSignIn", description = "JIRA#DEMO-B010")
    public void verifySignIn(String email, String password, String message){
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SignInPage signInPage = page.getHeader().clickSignInLink();
        signInPage.enterEmailAddress(email);
        signInPage.enterPassword(password);

        signInPage.clickSignInButton();

        if(!"fail".equals(message)){
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage("Thomas Smith"), "Logged as username failed");
        } else {
            Assert.assertTrue(signInPage.isErrorMessageDisplayed(), "Error message is not displayed");
        }
//        page.getHeader().clickUserAccount();
//        page.getHeader().clickSignOut();
    }

    @DataProvider(name = "useTestDataRegister")
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {generateRandomName(), generateRandomName(), generateRandomEmail(), "password123!@#", "success"},
                {" ", generateRandomName(), generateRandomEmail(), "password123!@#", "fail"},
                {generateRandomName(), " ", generateRandomEmail(), "password123!@#", "fail"},
                {generateRandomName(), generateRandomName(), " ", "password123!@#", "fail"},
                {generateRandomName(), generateRandomName(), generateRandomEmail(), " ", "fail"}
        };
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    private String generateRandomEmail() {
        return UUID.randomUUID().toString().substring(0, 5) + "@email.com";
    }

    @Test(dataProvider = "useTestDataRegister", description = "JIRA#DEMO-B008")
    public void verifyCreateAccount(String firstName, String lastName, String email, String password, String message){
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        RegistrationPage registrationPage = page.getHeader().clickCreateAccountLink();

        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmailAddress(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);

        registrationPage.clickCreateAccountButton();

        if(!"fail".equals(message)){
            String expectedUsername = firstName + " " + lastName;
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage(expectedUsername), "Logged as username failed");
        } else {
            Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/create/",
                    "User is not on the registration page after putting invalid data to form");
        }
    }

}
