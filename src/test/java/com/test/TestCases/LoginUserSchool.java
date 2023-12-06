package com.test.TestCases;

import com.test.BaseTestSchool;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Login User School")
@Feature("Login")
public class LoginUserSchool extends BaseTestSchool {
    @Story("Login valid user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Login User with valid email and password")
    @Test( description = "Login valid user", groups = { "login school" })
    public void loginValidUserSchool() {
        homePage.clickLoginButton();
    }
}
