package com.msagaidakovskyi.yahoo.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    // Page elements
    @FindBy(id = "yui_3_10_3_1_1375219693637_127")
    private WebElement accountButton;

    @FindBy (id = "yucs-signout")
    private WebElement exitButton;

    private WebDriver driver;

    public MailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("java.selenium - Yahoo Mail"));
    }

    public String getTitle(){

        String title = this.driver.getTitle();

        return title;
    }

    public LoginPage logout(){
        accountButton.click();
        exitButton.click();
        return new LoginPage(driver);
    }

}
