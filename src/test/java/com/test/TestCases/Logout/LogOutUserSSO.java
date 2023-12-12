package com.test.TestCases.Logout;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Logout User SSO")
@Feature("Logout")
public class LogOutUserSSO extends BaseTest {
    @Story("Logout SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Logout user with button in dashboard")
    @Test( description = "Logout user with button in dashboard", groups = { "logout" },priority = 0)
    public void logoutUserWithButtonDashboard() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        dashboardVendor.clickLogoutButtonDashboard();
        Assert.assertEquals(loginPage.getLoginFormText(),"Sign in with your email and password");
    }

    @Story("Logout SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Logout user with dropdown button")
    @Test( description = "Logout user with dropdown button", groups = { "logout" },priority = 0)
    public void logoutUserWithDropdownButton() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        dashboardVendor.clickLogoutButtonDropdown();
        Assert.assertEquals(loginPage.getLoginFormText(),"Sign in with your email and password");
    }

}
