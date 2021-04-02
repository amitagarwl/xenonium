package com.github.amitagarwl.test;

import com.github.amitagarwl.BaseTest;
import com.github.amitagarwl.core.factory.DriverManagerFactory;
import com.github.amitagarwl.core.factory.DriverType;
import com.github.amitagarwl.model.HomePage;
import com.github.amitagarwl.model.SignInPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


@Slf4j
public class SignInTest extends BaseTest {

    @BeforeClass
    public void initialize(){

        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();

        //full screen window
        driver.manage().window().maximize();

        // wait for the element to appear before the exception occurs
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSignInWithValidCredentials(){

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.isPageOpened());
        signInPage.signIn("test@gmail.com", "testtest");

        Assert.assertEquals("testuser", homePage.getNameOfLoggedInUser());
    }

    @Test
    public void testSignInWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("test@gmail.com", "wrongPass");

        //Check the visibility of error message, when the wrong password is entered
        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }

    @Test
    public void testSignInWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("wrongEmail", "ania1991");

        //Check the visibility of error message, when the wrong email is entered
        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }




}
