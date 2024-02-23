package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.constans.Status;
import com.zebrunner.carina.demo.gui.pages.common.RegistrationPageBase;
import com.zebrunner.carina.demo.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.zebrunner.carina.demo.constans.Status.FAIL;
import static com.zebrunner.carina.demo.constans.Status.SUCCESS;

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
                {"thomas.smith@email.com", generateRandomName(), FAIL}
        };
    }

    @Test(dataProvider = "useTestDataSignIn", description = "JIRA#DEMO-D001")
    public void verifySignIn(String email, String password, Status message){
        HomePageBase page = new HomePage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        SignInPageBase signInPage = page.getHeader().clickSignInLink();
        signInPage.enterEmailAddress(email);
        signInPage.enterPassword(password);

        signInPage.clickSignInButton();

        if(message.equals(SUCCESS)){
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage("Thomas Smith"), "Logged as username failed");
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
                {generateRandomName(), generateRandomName(), generateRandomEmail(), "", FAIL},
        };
    }

    @Test(dataProvider = "useTestDataRegister", description = "JIRA#DEMO-D002")
    public void verifyCreateAccount(String firstName, String lastName, String email, String password, Status message){
        HomePageBase page = new HomePage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        RegistrationPageBase registrationPage = page.getHeader().clickCreateAccountLink();
        registrationPage.putDataToForm(firstName, lastName, email, password, password);
        registrationPage.clickCreateAccountButton();

        if(message.equals(SUCCESS)){
            String expectedUsername = firstName + " " + lastName;
            Assert.assertTrue(page.getHeader().isUsernameInWelcomeMessage(expectedUsername), "Logged as username failed");
        } else {
            Assert.assertTrue(registrationPage.isPageOpened(), "User is not on the registration page after putting invalid data to form");
        }
    }

}
