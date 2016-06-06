package com.msagaidakovskyi.yahoo.project.tests;

import com.msagaidakovskyi.yahoo.project.abstractTests.AbstractAuthenticationTest;
import com.msagaidakovskyi.yahoo.project.pages.LoginPage;
import com.msagaidakovskyi.yahoo.project.pages.MailPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mykola.Sagaidakovsky on 01.06.2016.
 */
public class LoginTest extends AbstractAuthenticationTest {

    @Test(description = "Login to Yahoo Mail")
    public void testLoginToYahoo() {
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = loginPage.loginAs(userName, password);
        assertEquals(mailPage.getTitle(), userName + " - Yahoo Mail");
    }
}
