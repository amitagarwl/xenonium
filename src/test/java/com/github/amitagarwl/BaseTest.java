package com.github.amitagarwl;

import com.github.amitagarwl.config.Config;
import com.github.amitagarwl.core.factory.DriverManager;
import com.github.vivekkothari.YamlParser;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Slf4j
public class BaseTest {

    public DriverManager driverManager;
    public WebDriver driver;
    public static Config config;

    @BeforeSuite
    public void setup() throws FileNotFoundException {

        InputStream in = new FileInputStream(new File("src/test/resources/automation.yml"));
        config = YamlParser.load(in,Config.class);
        log.info("================== Starting Automation ===================");
        log.info("Config read is {}", config);

    }


    @AfterSuite
    public void cleanup() {

        log.info("Finishing test case Execution!");
        log.info("================== Finished Automation ===================");
    }
}
