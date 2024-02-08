package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.CreateAccountPage;
import com.zebrunner.carina.demo.gui.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends AbstractTest {

    @Test
    public void verifyCreateAccount(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();
        page.getHeader().clickCreateAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmailAddress("john.doe@example.com");
        createAccountPage.enterPassword("password123!@#");
        createAccountPage.enterConfirmPassword("password123!@#");

        createAccountPage.clickCreateAccount();

        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String actualUrl = driver.getCurrentUrl();
        sa.assertEquals(actualUrl, expectedUrl, "URL after account creation does not match");

        sa.assertAll();
    }
}
