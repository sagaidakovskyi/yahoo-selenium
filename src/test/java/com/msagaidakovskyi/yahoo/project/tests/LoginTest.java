package com.msagaidakovskyi.yahoo.project.tests;

import com.msagaidakovskyi.yahoo.project.abstract_tests.AbstractAuthenticationTest;
import com.msagaidakovskyi.yahoo.project.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Created by Mykola.Sagaidakovsky on 01.06.2016.
 */
public class LoginTest extends AbstractAuthenticationTest {



    @Test(description = "Login to Yahoo")
    public void testLoginToYahoo() {
        LoginPage page = new LoginPage(driver);
        page.loginAs("java.selenium", "securePWDforJAVA");

    }
}
