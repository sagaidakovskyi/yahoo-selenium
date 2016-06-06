package com.msagaidakovskyi.yahoo.project.tests;

import com.msagaidakovskyi.yahoo.project.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractAuthenticationTest extends AbstractTest {

    protected String wrongUserName = "notexistinglogin";
    protected String wrongPassword = "qwerty";
    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true, description = "Create clean object loginPage")
    public void createNewLoginPageObject(){
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "delete loginPage")
    public void deleteLoginPageObject() {
        loginPage = null;
    }

}
