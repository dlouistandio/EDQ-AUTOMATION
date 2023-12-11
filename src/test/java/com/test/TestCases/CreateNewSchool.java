package com.test.TestCases;

import com.test.BaseTestVendor;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewSchool extends BaseTestVendor {
    @BeforeMethod(groups = { "create school" })
    public void loginUser() {
        loginPage.loginUser("6cf50761-8146-406b-b01d-fb0ba16fbaf3@mailsac.com","test123");
        loginPage.clickSignInButton();
    }

    @Story("Create School")
    @Description("Create School")
    @Test( description = "Create School", groups = { "create school" })
    public void createSchool() {
        dashboardVendor.clickCreateNewSchool();
        Assert.assertEquals(createSchoolPage.getStartedWithEduqatText(),"Get started with Eduqat");
        createSchoolPage.inputSchoolName(generateRandomString());
        createSchoolPage.clickContinueButton();
        Assert.assertEquals(createSchoolPage.getFormHeaderText(),"Tell us about yourself");
        createSchoolPage.clickJobsOption();
        createSchoolPage.selectOption("Author/Blogger");
        createSchoolPage.clickHaveTeachOption();
        createSchoolPage.selectOption("I am just getting started");
        createSchoolPage.clickCourseRevenueOption();
        createSchoolPage.selectOption("Never sold an online course before");
        createSchoolPage.clickAudienceSizeOption();
        createSchoolPage.selectOption("500 - 1.000 people");
        createSchoolPage.clickCountryOption();
        createSchoolPage.selectCountry("Indonesia");
        createSchoolPage.clickTimezoneOption();
        createSchoolPage.selectTimezone("Western Indonesian Time");
        createSchoolPage.clickSaveInformation();
        Assert.assertEquals(dashboardSchool.getUsernameDashboardText(),"Testing");
    }
}
