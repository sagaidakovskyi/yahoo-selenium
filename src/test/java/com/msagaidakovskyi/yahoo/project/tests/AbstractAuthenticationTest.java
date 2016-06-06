package com.msagaidakovskyi.yahoo.project.tests;

import com.msagaidakovskyi.yahoo.project.pages.MailPage;
import org.testng.annotations.AfterClass;

public abstract class AbstractAuthenticationTest extends AbstractTest {
    protected MailPage homePage;

    protected String userName = "java.selenium";
    protected String password = "securePWDforJAVA";

    @AfterClass(description = "Yahoo Logout")
    public void logout() {
        //homePage.logout();
    }
}
