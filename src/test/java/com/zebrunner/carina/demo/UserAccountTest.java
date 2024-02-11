package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.gui.RegistrationPage;
import com.zebrunner.carina.demo.gui.HomePage;
import com.zebrunner.carina.demo.gui.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.zebrunner.carina.demo.enums.Credentials.*;
import static com.zebrunner.carina.demo.enums.Status.FAIL;
import static com.zebrunner.carina.demo.enums.Status.SUCCESS;

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
                {"thomas.smith@email.com", "password123!@#", SUCCESS},
                {generateRandomEmail(), "password123!@#", FAIL},
                {"thomas.smith@email.com", generateRandomName(), FAIL},
                {"", "", FAIL}
        };
    }

    @Test(dataProvider = "useTestDataSignIn", description = "JIRA#DEMO-D001")
    public void verifySignIn(String email, String password, Status message){
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();

        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SignInPage signInPage = page.getHeader().clickSignInLink();
        signInPage.enterEmailAddress(email);
        signInPage.enterPassword(password);

        signInPage.clickSignInButton();

        if(message.equals(SUCCESS)){
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage(String.valueOf(NAME)), "Logged as username failed");
        } else {
            Assert.assertTrue(signInPage.isErrorMessageDisplayed(), "Error message is not displayed after failed login");
        }
    }

    @DataProvider(name = "useTestDataRegister")
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {generateRandomName(), generateRandomName(), generateRandomEmail(), "password123!@#", SUCCESS},
                {"", generateRandomName(), generateRandomEmail(), "password123!@#", FAIL},
                {generateRandomName(), "", generateRandomEmail(), "password123!@#", FAIL},
                {generateRandomName(), generateRandomName(), "", "password123!@#", FAIL},
                {generateRandomName(), generateRandomName(), generateRandomEmail(), " ", FAIL},
        };
    }

    @Test(dataProvider = "useTestDataRegister", description = "JIRA#DEMO-D002")
    public void verifyCreateAccount(String firstName, String lastName, String email, String password, Status message){
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

        if(message.equals(Status.SUCCESS)){
            String expectedUsername = firstName + " " + lastName;
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage(expectedUsername), "Logged as username failed");
        } else {
            Assert.assertTrue(registrationPage.isPageOpened(), "User is not on the registration page after putting invalid data to form");
        }
    }

}
