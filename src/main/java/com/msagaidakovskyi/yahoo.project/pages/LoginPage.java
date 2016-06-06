package com.msagaidakovskyi.yahoo.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Mykola.Sagaidakovsky on 28.05.2016.
 */
public class LoginPage {

    String APP_URL = "http://www.mail.yahoo.com";
    String APP_TITLE = "Yahoo - login";

    @FindBy(id = "login-username")
    private WebElement email;

    @FindBy(id = "login-signin")
    private WebElement nextBtn;

    @FindBy(id = "login-passwd")
    private WebElement pwd;

    @FindBy(id = "login-signin")
    private WebElement signInBtn;

    @FindBy(id = "mbr-login-greeting")
    private WebElement userGreetingText;

    private WebDriver driver;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String pwd) {
        this.pwd.sendKeys(pwd);
        return this;
    }

    public LoginPage clickNextBtn() {
        nextBtn.click();
        return this;
    }

    public MailPage clickSignInBtn() {
        signInBtn.click();
        return new MailPage(driver);
    }

    public MailPage loginAs(String email, String pwd) {

        driver.navigate().to(APP_URL);

        this.email.sendKeys(email);
        this.nextBtn.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("mbr-button-link-back")));
        this.pwd.sendKeys(pwd);
        this.nextBtn.click();
        return new MailPage(driver);

    }


}
