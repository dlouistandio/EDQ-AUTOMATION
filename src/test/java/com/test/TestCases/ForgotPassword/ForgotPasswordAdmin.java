package com.test.TestCases.ForgotPassword;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Forgot Password Admin")
@Feature("Forgot Password")
public class ForgotPasswordAdmin extends BaseTest {
    @Story("Forgot Password Admin")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin")
    @Test( description = "Forgot Password Admin", groups = { "forgot password" },priority = 2)
    public void forgotPasswordSchool() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("qe81hb1172asdc@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField("eduqatautomationtesting@gmail.com");
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField("qe81hb1172asdc@mailsac.com");
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        String code = emailInbox.getCodeVerifyForgotPasswordText();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        forgotPasswordSchoolPage.inputCodeForgotEmailField(code);
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        forgotPasswordSchoolPage.resetPasswordTextInvisible();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("qe81hb1172asdc@mailsac.com","testing123");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getHeaderWeb(),"untukautomationtest");
    }
    @Story("Forgot Password Admin")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with empty email")
    @Test( description = "Forgot Password Admin with empty email", groups = { "forgot password" },priority = 2)
    public void forgotPasswordUserSchoolEmptyEmail() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("");
        forgotPasswordSchoolPage.clickResetButton();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Email is required");
    }

    @Story("Forgot Password Admin")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with empty code field")
    @Test( description = "Forgot Password Admin with empty code field", groups = { "forgot password" },priority = 2)
    public void forgotPasswordUserSchoolEmptyCodeField() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("cvnbcf23@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Code is required");
    }

    @Story("Forgot Password Admin")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with empty password field")
    @Test( description = "Forgot Password Admin with empty password field", groups = { "forgot password" },priority = 2)
    public void forgotPasswordUserSchoolEmptyPasswordField() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("asdasdasfas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Password is required");
    }

    @Story("Forgot Password Educator")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with empty re-enter password field")
    @Test( description = "Forgot Password Admin with empty re-enter password field", groups = { "forgot password" },priority = 2)
    public void forgotPasswordUserSchoolEmptyReEnterPasswordField() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("123axczzxc@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Password is required");
    }

    @Story("Forgot Password Educator")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with wrong code")
    @Test( description = "Forgot Password Admin with wrong code", groups = { "forgot password" },priority = 2)
    public void forgotPasswordUserSchoolWithWrongCode() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("vasaseqw@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getWrongAlert(),"Invalid verification code provided, please try again.");
    }

    @Story("Forgot Password Educator")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password Admin with different password input")
    @Test( description = "Forgot Password Admin with different password input", groups = { "forgot password" },priority = 5)
    public void forgotPasswordUserSchoolWithDifferentPass() {
        forgotPasswordSchoolPage.clickLoginButton();
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("qe81hb1172asdc@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField("eduqatautomationtest@gmail.com");
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField("qe81hb1172asdc@mailsac.com");
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        String code = emailInbox.getCodeVerifyForgotPasswordText();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        forgotPasswordSchoolPage.inputCodeForgotEmailField(code);
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123weqw");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getWrongAlert(),"Password not match!");
    }
}
