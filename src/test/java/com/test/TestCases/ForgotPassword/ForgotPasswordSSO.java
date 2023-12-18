package com.test.TestCases.ForgotPassword;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Forgot Password SSO")
@Feature("Forgot Password")
public class ForgotPasswordSSO extends BaseTest {
    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO")
    @Test( description = "Forgot Password SSO", groups = { "forgot password" },priority = 5)
    public void forgotPasswordUserSSO() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("ef0d56a4-aa63-4183-b8d9-0042a4c32fe9@mailsac.com");
        forgotPasswordPage.clickResetButton();
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField("eduqatautomationtest@gmail.com");
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField("ef0d56a4-aa63-4183-b8d9-0042a4c32fe9");
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        String code = emailInbox.getCodeVerifyForgotPasswordText();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        forgotPasswordPage.inputCodeForgotEmailField(code);
        forgotPasswordPage.inputNewPasswordField("testing123");
        forgotPasswordPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordPage.clickConfirmReset();
        loginPage.loginUser("ef0d56a4-aa63-4183-b8d9-0042a4c32fe9@mailsac.com","testing123");
        loginPage.clickSignInButton();
        Assert.assertEquals(dashboardVendor.getMySchoolText(), "My Schools");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with empty email")
    @Test( description = "Forgot Password SSO with empty email", groups = { "forgot password" },priority = 4)
    public void forgotPasswordUserSSOEmptyEmail() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("");
        forgotPasswordPage.clickResetButton();
        Assert.assertEquals(forgotPasswordPage.getValidationEmailText(), "Please fill out this field.");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with empty code")
    @Test( description = "Forgot Password SSO with empty code", groups = { "forgot password" },priority = 4)
    public void forgotPasswordUserSSOEmptyCode() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("");
        forgotPasswordPage.inputNewPasswordField("testing123");
        forgotPasswordPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordPage.getValidationCodeText(), "Please fill out this field.");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with empty new password")
    @Test( description = "Forgot Password SSO with empty new password", groups = { "forgot password" },priority = 3)
    public void forgotPasswordUserSSOEmptyNewPassword() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("123432432");
        forgotPasswordPage.inputNewPasswordField("");
        forgotPasswordPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordPage.getValidationPasswordText(), "Please fill out this field.");
    }


    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with wrong code")
    @Test( description = "Forgot Password SSO with wrong code", groups = { "forgot password" },priority = 1)
    public void forgotPasswordUserSSOWrongCode() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("6cf50761-8146-406b-b01d-fb0ba16fbaf3@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("21414324");
        forgotPasswordPage.inputNewPasswordField("testing123");
        forgotPasswordPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordPage.getWrongCodeAlert(), "Invalid verification code provided, please try again.");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with different password")
    @Test( description = "Forgot Password SSO with different password", groups = { "forgot password" },priority = 3)
    public void forgotPasswordUserSSOWithDiffPass() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("6ae8dd64-7d77-4f40-9e81-a780c993ea07@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("21414324");
        forgotPasswordPage.inputNewPasswordField("testing123");
        forgotPasswordPage.inputReEnterNewPasswordField("testing1sd23");
        Assert.assertFalse(forgotPasswordPage.checkButtonDisabled());
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with password under 6 character")
    @Test( description = "Forgot Password SSO with password under 6 character", groups = { "forgot password" },priority = 3)
    public void forgotPasswordUserSSOWithUnderSixChar() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("21414324");
        forgotPasswordPage.inputNewPasswordField("t823");
        forgotPasswordPage.inputReEnterNewPasswordField("t823");
        Assert.assertFalse(forgotPasswordPage.checkButtonDisabled());
    }
}
