package com.test.TestCases;

import com.test.BaseTestVendor;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Login User SSO")
@Feature("Login")
public class LoginUserSSO extends BaseTestVendor {

    @Story("Login user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with valid email and password")
    @Test( description = "Login User with valid email and password", groups = { "login" })
    public void loginValidUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        Assert.assertEquals(dashboardVendor.getMySchoolText(), "My Schools");
    }

    @Story("Login user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid email and password")
    @Test( description = "Login User with invalid email and password", groups = { "login" })
    public void loginInvalidUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","Pss4eduqat");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getAlertText(), "Incorrect username or password.");
    }

    @Story("Login user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with empty email")
    @Test( description = "Login User with empty email", groups = { "login" })
    public void loginUserEmptyEmail() {
        loginPage.loginUser("","Pss4eduqat");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getValidationEmailText(), "Please fill out this field.");
    }

    @Story("Login user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with empty email")
    @Test( description = "Login User with empty email", groups = { "login" })
    public void loginUserEmptyPassword() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getValidationPasswordText(), "Please fill out this field.");
    }

    @Story("Login user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with empty email and password")
    @Test( description = "Login User with empty email and password", groups = { "login" })
    public void loginUserEmptyEmailAndPassword() {
        loginPage.loginUser("","");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getValidationEmailText(), "Please fill out this field.");
    }
}

