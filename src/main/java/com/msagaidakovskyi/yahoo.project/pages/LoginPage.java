package com.msagaidakovskyi.yahoo.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    String APP_URL = "http://www.mail.yahoo.com";
    String APP_TITLE = "Yahoo - login";

    @FindBy(id = "login-username")
    private WebElement emailTxtField;

    @FindBy(id = "login-signin")
    private WebElement nextBtn;

    @FindBy(id = "login-passwd")
    private WebElement pwdTxtField;

    @FindBy(id = "login-signin")
    private WebElement signInBtn;

    @FindBy(id = "mbr-login-greeting")
    private WebElement userGreetingText;

    @FindBy(xpath = "//div[contains(@id,'mbr-login-error') and not(contains(@class,'mbr-hide'))]")
    private WebElement wrongUsrNameMessage;


    private By backBtn = By.className("mbr-button-link-back");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage setEmailTxtField(String emailTxtField) {
        this.emailTxtField.sendKeys(emailTxtField);
        return this;
    }

    public LoginPage setPassword(String pwd) {
        this.pwdTxtField.sendKeys(pwd);
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

    public String getSorryText(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(@id,'mbr-login-error') and not(contains(@class,'mbr-hide'))]")));

        return wrongUsrNameMessage.getText();
    }

    public void navigateToLogin(){
        driver.navigate().to(APP_URL);
    }

    public MailPage loginAs(String email, String pwd) {
        navigateToLogin();
        setEmailTxtField(email);
        clickNextBtn();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(backBtn));
        setPassword(pwd);
        clickSignInBtn();

        return new MailPage(driver);
    }

    public LoginPage enterAnyUsername(String anyUsername) {
        navigateToLogin();
        setEmailTxtField(anyUsername);
        clickNextBtn();

        return this;
    }

}
