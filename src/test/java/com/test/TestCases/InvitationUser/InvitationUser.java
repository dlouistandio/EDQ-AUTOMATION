package com.test.TestCases.InvitationUser;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Invitation User")
@Feature("Invitation User")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class InvitationUser extends BaseTest {
    @BeforeMethod(groups = { "create course" })
    public void loginUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        dashboardVendor.goToSchool();
        changeTabDriver();
    }

    @Story("Invitation User")
    @Description("Invitation user Admin")
    @Parameters(value = "emailAdm")
    @Test( description = "Invitation User Admin", groups = { "invitation user" },priority = -1)
    public void invitationUserAdmin(String emailAdm) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationUserPage.clickNewUserButton();
        invitationUserPage.inputEmailField(emailAdm);
        invitationUserPage.clickAddButton();
        invitationUserPage.clickRoleSelector();
        invitationUserPage.selectRole("Admin");
        invitationUserPage.clickSendInvitation();
        Assert.assertEquals(invitationUserPage.getSuccesInvitationText(),"Invitation Sent!");
        invitationUserPage.clickOkButtonModal();
    }

    @Story("Invitation User")
    @Description("Invitation user Educator")
    @Parameters(value = "emailEdu")
    @Test( description = "Invitation user Educator", groups = { "invitation user" },priority = -1)
    public void invitationUserEducator(String emailEdu) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationUserPage.clickNewUserButton();
        invitationUserPage.inputEmailField(emailEdu);
        invitationUserPage.clickAddButton();
        invitationUserPage.clickSendInvitation();
        Assert.assertEquals(invitationUserPage.getSuccesInvitationText(),"Invitation Sent!");
        invitationUserPage.clickOkButtonModal();
    }

    @Story("Invitation User")
    @Description("Invitation user with invalid email")
    @Test( description = "Invitation user with invalid email format", groups = { "invitation user" },priority = 2)
    public void invitationUserWithInvalidEmailFormat() {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationUserPage.clickNewUserButton();
        invitationUserPage.inputEmailField("adsaddfas");
        invitationUserPage.clickAddButton();
        Assert.assertEquals(invitationUserPage.getAlertMessage(),"Please enter a valid email address.");
    }

    @Story("Invitation User")
    @Description("Invitation user with email")
    @Test( description = "Invitation user with empty format", groups = { "invitation user" },priority = 2)
    public void invitationUserWithEmptyEmail() {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationUserPage.clickNewUserButton();
        invitationUserPage.inputEmailField("");
        invitationUserPage.clickSendInvitation();
        Assert.assertEquals(invitationUserPage.getAlertMessage(),"Please add at least one user email!");
    }


}
