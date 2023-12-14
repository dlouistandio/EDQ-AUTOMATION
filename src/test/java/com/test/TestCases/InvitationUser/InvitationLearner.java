package com.test.TestCases.InvitationUser;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Invitation Learner")
@Feature("Invitation Learner")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class InvitationLearner extends BaseTest {
    @BeforeMethod(groups = { "invitation new leaner"})
    public void loginUser() {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        dashboardVendor.goToSchoolVendor();
        changeTabDriver();
    }

    @Story("Invitation New Learner")
    @Description("Invitation New Learner")
    @Parameters(value = "emailLearner")
    @Test( description = "Invitation New Learner", groups = { "invitation new leaner" },priority = 1)
    public void invitationUserAdmin(String emailLearner) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationLearnerPage.clickLearnerMenuButton();
        invitationLearnerPage.clickNewLearnerButton();
        invitationLearnerPage.inputEmailLearnerField(emailLearner);
        invitationLearnerPage.clickSelectProductType("Self-Paced");
        invitationLearnerPage.clickSelectCourseName("Automation Test With Playwright V33");
        invitationLearnerPage.clickSendInviteLearner();
        Assert.assertEquals(invitationLearnerPage.getSuccesInvitationText(),"Invitation Sent!");
    }
}
