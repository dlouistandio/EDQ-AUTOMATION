package com.test.TestCases.Register;

import com.test.BaseTestSchool;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

@Epic("Register User School")
@Feature("Register")
public class RegisterUserSchool extends BaseTestSchool {
    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school with valid input")
    @Test( description = "Register user school with valid input", groups = { "register" })
    public void registerUserSchoolWithValidInput() throws IOException {
        String email = emailProperties();
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("Testing");
        registerPage.inputEmailField(email);
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        registerPage.clickEnterOTPCodeButton();
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
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
        String code = emailInbox.getCodeVerifyRegisterSchool();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        registerPage.inputOtpCodeField(code);
       Assert.assertEquals(registerPage.getMyCoursesText(),"My Courses");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school with empty email")
    @Test( description = "Register user school with empty email", groups = { "register" })
    public void registerUserSchoolWithEmptyEmail() {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("Testing");
        registerPage.inputEmailField("");
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertMessage(),"Email is required");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school with empty name")
    @Test( description = "Register user school with empty name", groups = { "register" })
    public void registerUserSchoolWithEmptyName()  {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("");
        registerPage.inputEmailField("qwewdas@mailsac.com");
        registerPage.inputPasswordField("asdasdas");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertMessage(),"Name is required");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school with empty password")
    @Test( description = "Register user school with empty password", groups = { "register" })
    public void registerUserSchoolWithEmptyPassword()  {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("adsda");
        registerPage.inputEmailField("qwewdas@mailsac.com");
        registerPage.inputPasswordField("");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertMessage(),"Password is required");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school without tick agreement privacy")
    @Test( description = "Register user school without tick agreement privacy", groups = { "register" })
    public void registerUserSchoolWithoutTickAgrementPrivacy()  {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("adsda");
        registerPage.inputEmailField("qwewdas@mailsac.com");
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertRadioButton(),"You Must Accept the Terms Above");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school without tick agreement SaaS")
    @Test( description = "Register user school without tick agreement SaaS", groups = { "register" })
    public void registerUserSchoolWithoutTickAgrementSaas()  {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("adsda");
        registerPage.inputEmailField("qwewdas@mailsac.com");
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementPrivacy();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertRadioButton(),"You Must Accept the SaaS Agreement");
    }

    @Story("Register user school")
    @Link(name = "allure", type = "mylink")
    @TmsLink("TMS Link")
    @Description("Register user school without tick agreement SaaS")
    @Test( description = "Register user school without tick agreement SaaS", groups = { "register" })
    public void registerUserSchoolWithWrongEmailFormat()  {
        registerPage.clickGoToSignUpForm();
        registerPage.inputNameField("adsda");
        registerPage.inputEmailField("qwewdas");
        registerPage.inputPasswordField("testes");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        Assert.assertEquals(registerPage.getAlertMessage(),"Please enter a valid email address without any spaces.");
    }
}
