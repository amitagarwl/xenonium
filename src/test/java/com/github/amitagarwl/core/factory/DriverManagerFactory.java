package com.github.amitagarwl.core.factory;

import com.github.amitagarwl.core.*;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {

            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;

        }
        return driverManager;

    }
}
