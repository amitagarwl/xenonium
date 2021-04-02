package com.github.amitagarwl.test;

import com.github.amitagarwl.BaseTest;
import com.github.amitagarwl.core.factory.DriverManager;
import com.github.amitagarwl.core.factory.DriverManagerFactory;
import com.github.amitagarwl.core.factory.DriverType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class BrowserTest extends BaseTest {


    @DataProvider(name = "browsers")
    public static Object[][] browsers() {

        return new Object[][]
                {
                        {DriverType.CHROME},
                        {DriverType.SAFARI},
                        {DriverType.FIREFOX},
                };
    }


    @Test(dataProvider = "browsers")
    public void test(DriverType driverType) {

        driverManager = DriverManagerFactory.getDriverManager(driverType);
        driver = driverManager.getWebDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.protonn.com");
        Assert.assertEquals("Protonn", driver.getTitle());

        log.info("Successfully verified title of the page!!");
        driver.quit();

    }



}
