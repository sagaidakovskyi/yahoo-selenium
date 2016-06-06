package com.msagaidakovskyi.yahoo.project.tests;

import java.net.URL;
import org.apache.bcel.util.ClassLoader;
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
        ClassLoader classLoader = new ClassLoader();
        URL url = classLoader.getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", url.toString().replace("file:/", ""));
        driver = new ChromeDriver();
    }

    @AfterClass(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        driver.quit();
    }
}
