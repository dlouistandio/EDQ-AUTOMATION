package com.test.TestCases.Logout;

import com.test.BaseTestSchool;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Logout User School")
@Feature("Logout School")
public class LogOutUserSchool extends BaseTestSchool {
    @Story("Logout user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Logout user school")
    @Test( description = "Logout user school", groups = { "logout school" })
    public void loginValidUserSchool() {
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("adasdas@mailsac.com","testing123");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getHeaderWeb(),"untukautomationtest");
        homePage.moveToProfile();
        homePage.clickSignOutButton();
        Assert.assertEquals(homePage.getLoginButtonText(),"Log in");
    }
}
