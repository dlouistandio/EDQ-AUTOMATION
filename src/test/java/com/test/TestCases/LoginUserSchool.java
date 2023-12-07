package com.test.TestCases;

import com.test.BaseTestSchool;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Login User School")
@Feature("Login School")
public class LoginUserSchool extends BaseTestSchool {
    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with valid email and password")
    @Test( description = "Login valid user", groups = { "login school" })
    public void loginValidUserSchool() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woofpuffy@gmail.com","P@ss4eduqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getHeaderWeb(),"untukautomationtest");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid email and password")
    @Test( description = "Login User with invalid email and password", groups = { "login school" })
    public void loginInvalidUserSchool() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woofuffy@gmail.com","P@ssuqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertInvalidCred(),"Incorrect username or password.");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid email")
    @Test( description = "Login User with invalid email", groups = { "login school" })
    public void loginInvalidEmail() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woossfuffy@gmail.com","P@s4eduqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertInvalidCred(),"Incorrect username or password.");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid password")
    @Test( description = "Login User with invalid password", groups = { "login school" })
    public void loginInvalidPassword() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woofuffy@gmail.com","P@asds4eduqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertInvalidCred(),"Incorrect username or password.");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with empty email")
    @Test( description = "Login User with empty email", groups = { "login school" })
    public void loginWithEmptyEmail() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("","P@s4eduqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertEmail(),"Email is required");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with empty password")
    @Test( description = "Login User with empty password", groups = { "login school" })
    public void loginWithEmptyPassword() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woofuffy@gmail.com","");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertPassword(),"Password is required");
    }

    @Story("Login user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with invalid email format")
    @Test( description = "Login with invalid email format", groups = { "login school" })
    public void loginWithInvalidEmailFormat() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("woofuffy","P@s4eduqat");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getAlertEmail(),"Please enter a valid email address without any spaces.");
    }
}
