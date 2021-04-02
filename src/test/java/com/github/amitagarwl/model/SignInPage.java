package com.github.amitagarwl.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    @FindBy(xpath = "//h1")
    private WebElement heading;

    @FindBy(xpath = "//input[@class ='btn btn-primary btn-block']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//div[@class='container-lg px-2']")
    private WebElement signInError;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setUserEmail(String usersEmail) {
        userEmail.clear();
        userEmail.sendKeys(usersEmail);
    }

    public void setUserPassword(String usersPassword) {
        password.clear();
        password.sendKeys(usersPassword);
    }

    public void signIn(String usersEmail, String password) {
        if (isPageOpened()) {
            setUserEmail(usersEmail);
            setUserPassword(password);
            clickOnSubmit();
        }
    }

    //Check if page is opened
    public boolean isPageOpened() {
        return heading.getText().contains("Sign in to GitHub");
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public boolean errorMessageIsVisible() {
        return signInError.isDisplayed();
    }


}
