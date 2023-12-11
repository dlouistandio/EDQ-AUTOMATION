package com.test.TestCases.ForgotPassword;

import com.test.BaseTestSchool;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Forgot Password School")
@Feature("Forgot Password")
public class ForgotPasswordSchool extends BaseTestSchool {
    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School")
    @Test( description = "Forgot Password School", groups = { "forgot password" })
    public void forgotPasswordSchool() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
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
        forgotPasswordSchoolPage.inputCodeForgotEmailField(code);
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(homePage.getFormLoginText(),"Welcome back");
        homePage.inputEmailNPassword("adasdas@mailsac.com","testing123");
        homePage.clickSigninButton();
        Assert.assertEquals(homePage.getHeaderWeb(),"untukautomationtest");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School with empty email")
    @Test( description = "Forgot Password School with empty email", groups = { "forgot password" })
    public void forgotPasswordUserSchoolEmptyEmail() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("");
        forgotPasswordSchoolPage.clickResetButton();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Email is required");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School with empty code field")
    @Test( description = "Forgot Password School with empty code field", groups = { "forgot password" })
    public void forgotPasswordUserSchoolEmptyCodeField() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Code is required");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School with empty password field")
    @Test( description = "Forgot Password School with empty password field", groups = { "forgot password" })
    public void forgotPasswordUserSchoolEmptyPasswordField() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Password is required");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School with empty re-enter password field")
    @Test( description = "Forgot Password School with empty re-enter password field", groups = { "forgot password" })
    public void forgotPasswordUserSchoolEmptyReEnterPasswordField() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getFieldAlert(),"Password is required");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School")
    @Test( description = "Forgot Password School with wrong code", groups = { "forgot password" })
    public void forgotPasswordUserSchoolWithWrongCode() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
        forgotPasswordSchoolPage.inputCodeForgotEmailField("123914");
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getWrongAlert(),"Invalid verification code provided, please try again.");
    }

    @Story("Forgot Password School")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Forgot Password School with different password input")
    @Test( description = "Forgot Password School with different password input", groups = { "forgot password" })
    public void forgotPasswordUserSchoolWithDifferentPass() {
        forgotPasswordSchoolPage.clickGoToForgotPassword();
        forgotPasswordSchoolPage.inputEmailField("adasdas@mailsac.com");
        forgotPasswordSchoolPage.clickResetButton();
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
        forgotPasswordSchoolPage.inputCodeForgotEmailField(code);
        forgotPasswordSchoolPage.inputNewPasswordField("testing123");
        forgotPasswordSchoolPage.inputReEnterNewPasswordField("testing123weqw");
        forgotPasswordSchoolPage.clickConfirmReset();
        Assert.assertEquals(forgotPasswordSchoolPage.getWrongAlert(),"Password not match!");
    }
}
