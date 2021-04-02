package com.github.amitagarwl.model;

import com.github.amitagarwl.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.github.amitagarwl.utils.Constants.PAGE_URL;

public class HomePage {



    private WebDriver driver;

    @FindBy(xpath = "//a[@class='HeaderMenu-link flex-shrink-0 no-underline mr-3']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='flex-shrink-0 css-truncate css-truncate-target']")
    private WebElement userAvatar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {

        signInButton.click();
    }

    public String getNameOfLoggedInUser() {
        return userAvatar.getText();
    }

}
