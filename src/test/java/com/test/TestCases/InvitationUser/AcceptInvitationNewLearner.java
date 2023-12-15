package com.test.TestCases.InvitationUser;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Accept Invitation New Learner")
@Feature("Accept Invitation Learner")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class AcceptInvitationNewLearner extends BaseTest {
    @Story("Accept Invitation User")
    @Description("Accept Invitation Learner Self-paced")
    @Parameters({ "emailSelfpaced", "emailSelfpaced2" })
    @Test( description = "Accept Invitation Learner Self-paced", groups = { "accept invitation learner" },priority = 3)
    public void acceptLearnerSelfPaced(String emailSelfpaced, String emailSelfpaced2) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailSelfpaced);
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
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailInbox.inputEmailFieldOnHome(emailSelfpaced2);
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
        Assert.assertEquals(homePage.getHeaderWeb(),"UAT Academy");
    }

    @Story("Accept Invitation User")
    @Description("Accept Invitation Learner Event")
    @Parameters({ "emailEvent", "emailEvent2" })
    @Test( description = "Accept Invitation Learner Event", groups = { "accept invitation learner" },priority = 4)
    public void acceptLearnerEvent(String emailEvent, String emailEvent2) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailEvent);
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
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailInbox.inputEmailFieldOnHome(emailEvent2);
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
        Assert.assertEquals(homePage.getHeaderWeb(),"UAT Academy");
    }

    @Story("Accept Invitation User")
    @Description("Accept Invitation Learner Cohort")
    @Parameters({ "emailCohort", "emailCohort2" })
    @Test( description = "Accept Invitation Learner Cohort", groups = { "accept invitation learner" },priority = 5)
    public void acceptLearnerCohort(String emailCohort, String emailCohort2) {
        emailLoginPage.goToLoginPage();
        emailLoginPage.inputEmailField();
        emailLoginPage.inputPasswordField();
        emailLoginPage.clickLoginButton();
        emailInbox.inputEmailInboxField(emailCohort);
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
        Assert.assertEquals(registerPage.getOtpLabelText(),"Enter OTP Code");
        ((JavascriptExecutor) driver).executeScript("window.open('https://mailsac.com/')");
        changeTabDriver();
        emailInbox.inputEmailFieldOnHome(emailCohort2);
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
        Assert.assertEquals(homePage.getHeaderWeb(),"UAT Academy");
    }
}
