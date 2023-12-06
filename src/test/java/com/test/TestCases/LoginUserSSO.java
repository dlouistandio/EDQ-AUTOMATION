package com.test.TestCases;

import com.test.BaseTestVendor;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Login User SSO")
@Feature("Login")
public class LoginUserSSO extends BaseTestVendor {

    @Story("Login valid user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with valid email and password")
    @Test( description = "Login valid user", groups = { "login" })
    public void loginValidUser() {
            loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
            String mySchoolText = dashboardVendor.getMySchoolText();
            Assert.assertEquals(mySchoolText, "My Schools");
    }

    @Story("Login invalid user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid email and password")
    @Test( description = "Login invalid user", groups = { "login" })
    public void loginInvalidUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","Pss4eduqat");
        String alertText = loginPage.getAlertText();
        Assert.assertEquals(alertText, "Incorrect username or password.");
    }
}

