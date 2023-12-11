package com.test.TestCases.ForgotPassword;

import com.test.BaseTestVendor;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Forgot Password SSO")
@Feature("Forgot Password")
public class ForgotPasswordSSO extends BaseTestVendor {
    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO")
    @Test( description = "Forgot Password SSO", groups = { "forgot password" })
    public void forgotPasswordUserSSO() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordPage.clickResetButton();
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField("adasdas");
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
        loginPage.loginUser("adasdas@mailsac.com","testing123");
        loginPage.clickSignInButton();
        Assert.assertEquals(dashboardVendor.getMySchoolText(), "My Schools");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with empty email")
    @Test( description = "Forgot Password SSO with empty email", groups = { "forgot password" })
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
    @Test( description = "Forgot Password SSO with empty code", groups = { "forgot password" })
    public void forgotPasswordUserSSOEmptyCode() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("");
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
    @Test( description = "Forgot Password SSO with empty code", groups = { "forgot password" })
    public void forgotPasswordUserSSOEmptyNewPassword() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("");
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
    @Test( description = "Forgot Password SSO with wrong code", groups = { "forgot password" })
    public void forgotPasswordUserSSOWrongCode() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordPage.clickResetButton();
        forgotPasswordPage.inputCodeForgotEmailField("21414324");
        forgotPasswordPage.inputNewPasswordField("testing123");
        forgotPasswordPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordPage.getWrongCodeAlert(), "Invalid verification code provided, please try again. ");
    }

    @Story("Forgot Password SSO")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password SSO with different password")
    @Test( description = "Forgot Password SSO with different password", groups = { "forgot password" })
    public void forgotPasswordUserSSOWithDiffPass() {
        forgotPasswordPage.clickGoToForgotPassword();
        forgotPasswordPage.inputEmailField("adasdas@mailsac.com");
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
    @Test( description = "Forgot Password SSO with password under 6 character", groups = { "forgot password" })
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
