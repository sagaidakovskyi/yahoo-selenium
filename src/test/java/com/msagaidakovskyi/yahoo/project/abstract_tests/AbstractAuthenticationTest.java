package com.msagaidakovskyi.yahoo.project.abstract_tests;

import com.msagaidakovskyi.yahoo.project.pages.MailPage;
import org.testng.annotations.AfterClass;

public abstract class AbstractAuthenticationTest extends AbstractTest {
    protected MailPage homePage;

    @AfterClass(description = "Yahoo Logout")
    public void logout() {
        //homePage.logout();
    }
}
