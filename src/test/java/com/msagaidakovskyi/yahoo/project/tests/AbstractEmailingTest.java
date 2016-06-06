package com.msagaidakovskyi.yahoo.project.tests;

import com.msagaidakovskyi.yahoo.project.pages.LoginPage;
import com.msagaidakovskyi.yahoo.project.pages.MailPage;
import org.testng.annotations.BeforeTest;

/**
 * Created by Mykola.Sagaidakovsky on 06.06.2016.
 */
public class AbstractEmailingTest extends AbstractTest {
    @BeforeTest(alwaysRun = true, description = "Login to email page")
    public MailPage loginToMail () {
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = loginPage.loginAs(userName, password);

        return mailPage;
    }
}
