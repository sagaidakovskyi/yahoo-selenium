package com.msagaidakovskyi.yahoo.project.abstract_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true, description = "Start the Browser")
    @Parameters("browser")
    public void startBrowser(@Optional("chrome") String browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        driver.quit();
    }

}
