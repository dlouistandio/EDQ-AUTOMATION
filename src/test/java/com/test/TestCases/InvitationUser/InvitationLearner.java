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
    @Description("Invitation New Learner Self Paced")
    @Parameters(value = "emailLearnerSelfpaced")
    @Test( description = "Invitation New Learner Self Paced", groups = { "invitation new leaner" },priority = 1)
    public void invitationUserLearnerSelfPaced(String emailLearnerSelfpaced) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationLearnerPage.clickLearnerMenuButton();
        invitationLearnerPage.clickNewLearnerButton();
        invitationLearnerPage.inputEmailLearnerField(emailLearnerSelfpaced);
        invitationLearnerPage.clickSelectProductType("Self-Paced");
        invitationLearnerPage.clickSelectCourseName("Automation Test With Playwright V33");
        invitationLearnerPage.clickSendInviteLearner();
        Assert.assertEquals(invitationLearnerPage.getSuccesInvitationText(),"Invitation Sent!");
    }

    @Story("Invitation New Learner")
    @Description("Invitation New Learner Event")
    @Parameters(value = "emailLearnerEvent")
    @Test( description = "Invitation new learner event", groups = { "invitation new leaner" },priority = 1)
    public void invitationUserLearnerEvent(String emailLearnerEvent) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationLearnerPage.clickLearnerMenuButton();
        invitationLearnerPage.clickNewLearnerButton();
        invitationLearnerPage.inputEmailLearnerField(emailLearnerEvent);
        invitationLearnerPage.clickSelectProductType("Event");
        invitationLearnerPage.clickSelectCourseName("Test Event Checkout bayar gan");
        invitationLearnerPage.clickSendInviteLearner();
        Assert.assertEquals(invitationLearnerPage.getSuccesInvitationText(),"Invitation Sent!");
    }

    @Story("Invitation New Learner")
    @Description("Invitation New Learner Cohort")
    @Parameters(value = "emailLearnerCohort")
    @Test( description = "Invitation new learner cohort", groups = { "invitation new leaner" },priority = 1)
    public void invitationUserLearnerCohort(String emailLearnerCohort) {
        dashboardSchool.chooseMenu("/manage/user");
        Assert.assertEquals(invitationUserPage.getUserNavText(),"Users");
        invitationLearnerPage.clickLearnerMenuButton();
        invitationLearnerPage.clickNewLearnerButton();
        invitationLearnerPage.inputEmailLearnerField(emailLearnerCohort);
        invitationLearnerPage.clickSelectProductType("Cohort");
        invitationLearnerPage.clickSelectCourseName("COHORT: UHUYYY");
        invitationLearnerPage.clickSelectCohortBatch("INI BATCH COHORTgratiss");
        invitationLearnerPage.clickSendInviteLearner();
        Assert.assertEquals(invitationLearnerPage.getSuccesInvitationText(),"Invitation Sent!");
    }
}
