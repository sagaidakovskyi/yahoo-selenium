package com.msagaidakovskyi.yahoo.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//securePWDforJAVA

/**
 * Created by Mykola.Sagaidakovsky on 31.05.2016.
 */
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
    }

    public LoginPage logout(){
        accountButton.click();
        exitButton.click();
        return new LoginPage(driver);
    }

}
