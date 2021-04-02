package com.github.amitagarwl.core;

import com.github.amitagarwl.core.factory.DriverManager;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {

        SafariOptions safariOptions = new SafariOptions();
        driver = new SafariDriver(safariOptions);
    }
}
