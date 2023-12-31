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
    @Parameters({ "emailAdm", "emailAdm2" })
    @Test( description = "Accept Invitation User Admin", groups = { "accept invitation admin" },priority = 5)
    public void acceptUserAdmin(String emailAdm, String emailAdm2) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField("eduqatautomationtest@gmail.com");
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailAdm);
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmailInvitation("Invitation to be an Admin at untukautomationtest");
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
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailInbox.inputEmailFieldOnHome(emailAdm2);
        emailInbox.clickCheckEmailOnHome();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        String code = emailInbox.getCodeVerifyRegisterSchool();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        registerPage.inputOtpCodeField(code);
        invitationUserPage.getAddingAdminLoadText();
        Assert.assertEquals(dashboardSchool.getSchoolText(),"untukautomationtest");
    }

    @Story("Accept Invitation User")
    @Description("Accept Invitation User Educator")
    @Parameters({ "emailEdu", "emailEdu2" })
    @Test( description = "Accept Invitation User Educator", groups = { "accept invitation educator" },priority = 6)
    public void acceptUserEducator(String emailEdu, String emailEdu2) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField("eduqatautomationtesting@gmail.com");
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailEdu);
        emailInbox.clickCheckEmailButton();
        emailInbox.clickEmailInvitation("Invitation to be an Educator at untukautomationtest");
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
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailInbox.inputEmailFieldOnHome(emailEdu2);
        emailInbox.clickCheckEmailOnHome();
        emailInbox.clickEmail();
        emailInbox.clickUnblockLinkButton();
        changeTabDriver();
        String code = emailInbox.getCodeVerifyRegisterSchool();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        registerPage.inputOtpCodeField(code);
        invitationUserPage.getAddingEducatorLoadText();
        Assert.assertEquals(dashboardSchool.getSchoolText(),"untukautomationtest");
    }
}
