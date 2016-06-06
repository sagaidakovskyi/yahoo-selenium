package com.msagaidakovskyi.yahoo.project.tests;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class AbstractTest {
    protected WebDriver driver;

    protected String userName = "java.selenium";
    protected String password = "securePWDforJAVA";

    @BeforeMethod(alwaysRun = true, description = "Start the Browser")
    @Parameters("browser")
    public void startBrowser(@Optional("chrome") String browser) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", url.toString().replace("file:/", ""));
        driver = new ChromeDriver();
    }

    @AfterMethod(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }
}
