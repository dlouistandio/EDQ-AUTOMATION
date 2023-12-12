package com.test.TestCases.InvitationUser;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Accept Invitation User")
@Feature("Accept Invitation User")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class AcceptInvitationUser extends BaseTest {
    @Story("Accept Invitation User")
    @Description("Accept Invitation User Admin")
    @Parameters(value = "emailAdm")
    @Test( description = "Accept Invitation User Admin", groups = { "accept invitation admin" },priority = 3)
    public void acceptUserAdmin(String emailAdm) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailAdm);
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        emailInbox.clickAcceptInvButton();
        Assert.assertEquals(emailInbox.getInvitationPageText(),"You have been personally invited to enroll in our course. To proceed and gain access to the course, please complete the registration process.");
        invitationUserPage.clickRegisterEmailButton();
        Assert.assertEquals(registerPage.getRegisterPageText(),"Register");
        registerPage.inputNameField("Testing");
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        registerPage.clickEnterOTPCodeButton();

    }

    @Story("Accept Invitation User")
    @Description("Accept Invitation User Educator")
    @Parameters(value = "emailEdu")
    @Test( description = "Accept Invitation User Educator", groups = { "accept invitation educator" },priority = 2)
    public void acceptUserEducator(String emailEdu) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailEdu);
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        emailInbox.clickAcceptInvButton();
        Assert.assertEquals(emailInbox.getInvitationPageText(),"You have been personally invited to enroll in our course. To proceed and gain access to the course, please complete the registration process.");
        invitationUserPage.clickRegisterEmailButton();
        Assert.assertEquals(registerPage.getRegisterPageText(),"Register");
        registerPage.inputNameField("Testing");
        registerPage.inputPasswordField("test123");
        registerPage.clickAgrementPrivacy();
        registerPage.clickAgrementSaas();
        registerPage.clickSignUpButton();
        registerPage.clickEnterOTPCodeButton();

    }
}
