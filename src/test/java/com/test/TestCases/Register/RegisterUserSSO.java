package com.test.TestCases.Register;

import com.test.BaseTestVendor;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Epic("Register User SSO")
@Feature("Register")
public class RegisterUserSSO extends BaseTestVendor {
    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with valid input")
    @Test( description = "Register user with valid input", groups = { "register" })
    public void registerUserWithValidInput() throws IOException {
        String email = emailProperties();
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField(email);
        signUpPage.inputNameField("Testing");
        signUpPage.inputPasswordField("test123");
        signUpPage.clickSignUpButton();
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(email);
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        emailInbox.clickVerifyEmailButton();
        Assert.assertEquals(signUpPage.getSuccessVerifyText(),"Your registration has been confirmed!");
        ((JavascriptExecutor) driver).executeScript("window.open('https://sso.eduqat.com')");
        changeTabDriver();
        loginPage.loginUser(email,"test123");
        loginPage.clickSignInButton();
        Assert.assertEquals(dashboardVendor.getMySchoolText(), "My Schools");
    }

    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with empty email")
    @Test( description = "Register user with empty email", groups = { "register" })
    public void registerUserWithEmptyEmail(){
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField("");
        signUpPage.inputNameField("Testing");
        signUpPage.inputPasswordField("test123");
        Assert.assertFalse(signUpPage.checkButtonDisabled());
    }

    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with empty name")
    @Test( description = "Register user with empty name", groups = { "register" })
    public void registerUserWithEmptyName(){
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField("asdad@mailsac.com");
        signUpPage.inputNameField("");
        signUpPage.inputPasswordField("test123");
        Assert.assertFalse(signUpPage.checkButtonDisabled());
    }

    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with empty password")
    @Test( description = "Register user with empty password", groups = { "register" })
    public void registerUserWithEmptyPassword(){
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField("asdad@mailsac.com");
        signUpPage.inputNameField("test");
        signUpPage.inputPasswordField("");
        Assert.assertFalse(signUpPage.checkButtonDisabled());
    }

    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with under 6 character password")
    @Test( description = "Register user with under 6 character password", groups = { "register" })
    public void registerUserWithUnderSixChar(){
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField("asdad@mailsac.com");
        signUpPage.inputNameField("test");
        signUpPage.inputPasswordField("sd");
        Assert.assertFalse(signUpPage.checkButtonDisabled());
    }

    @Story("Register user")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user with invalid email format")
    @Test( description = "Register user with invalid email format", groups = { "register" })
    public void registerUserWithInvalidEmailFormat(){
        signUpPage.clickGoToSignUpForm();
        signUpPage.inputUsernameField("asdadasd");
        signUpPage.inputNameField("test");
        signUpPage.inputPasswordField("sd");
        signUpPage.clickSignUpButton();
        Assert.assertEquals(signUpPage.getEmailAlert(), "please include an '@' in the email address. 'asdadasd' is missing an '@'.");
    }
}
