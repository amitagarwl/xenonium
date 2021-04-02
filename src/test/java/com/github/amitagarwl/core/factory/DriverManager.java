package com.github.amitagarwl.core.factory;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebDriver();

    public void quitWebDriver() {

        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    public WebDriver getWebDriver() {
        if (Objects.isNull(driver)) {
            createWebDriver();
        }
        return driver;
    }


}
