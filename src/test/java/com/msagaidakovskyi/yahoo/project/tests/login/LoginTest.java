package com.msagaidakovskyi.yahoo.project.tests.login;

import com.msagaidakovskyi.yahoo.project.pages.MailPage;
import com.msagaidakovskyi.yahoo.project.tests.AbstractAuthenticationTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mykola.Sagaidakovsky on 01.06.2016.
 */
public class LoginTest extends AbstractAuthenticationTest {

    @Test(description = "Login successfully to Yahoo Mail")
    public void testLoginToYahoo() {
        MailPage mailPage = loginPage.loginAs(userName, password);
        assertEquals(mailPage.getTitle(), userName + " - Yahoo Mail");
    }

    @Test(description = "Use wrong login to Yahoo Mail")
    public void testWrongLoginToYahoo() {
        assertEquals(loginPage.enterAnyUsername(wrongUserName).getSorryText().toString(), "Sorry, we don't recognize this email.");
    }


}
