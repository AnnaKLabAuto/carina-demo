package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.enums.Credentials;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserAccountTest implements IAbstractTest {

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 9);
    }

    private String generateRandomEmail() {
        return UUID.randomUUID().toString().substring(0, 9) + "@email.com";
    }

    @DataProvider(name = "useTestDataSignIn")
    public Object[][] userSignInDataProvider() {
        return new Object[][]{
                {Credentials.EMAIL, Credentials.PASSWORD, Status.SUCCESS},
                {generateRandomEmail(), Credentials.PASSWORD, Status.FAIL},
                {Credentials.EMAIL,  generateRandomName(), Status.FAIL},
                {"", "", Status.FAIL}
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
    }

    @DataProvider(name = "useTestDataRegister")
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {generateRandomName(), generateRandomName(), generateRandomEmail(), Credentials.PASSWORD, Status.SUCCESS},
                {"", generateRandomName(), generateRandomEmail(), Credentials.PASSWORD, Status.FAIL},
                {generateRandomName(), "", generateRandomEmail(), Credentials.PASSWORD, Status.FAIL},
                {generateRandomName(), generateRandomName(), "", Credentials.PASSWORD, Status.FAIL},
                {generateRandomName(), generateRandomName(), generateRandomEmail(), "", Status.FAIL},
                {"", "", "", "", Status.FAIL}
        };
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
            Assert.assertTrue(registrationPage.isPageOpened(), "User is not on the registration page after putting invalid data to form");
        }
    }

}
