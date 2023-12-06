package com.test.TestCases;

import com.test.BaseTestVendor;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewSchool extends BaseTestVendor {
    @BeforeTest
    public void loginUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
    }

    @Story("Create School")
    @Description("Create School")
    @Test( description = "Create School", groups = { "create school" })
    public void createCourseEventWebinar() {
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
        createSchoolPage.inputCountryOption("indonesia");
        createSchoolPage.clickTimezoneOption();
        createSchoolPage.selectTimezone("1");
        createSchoolPage.clickSaveInformation();
        Assert.assertEquals(dashboardSchool.getUsernameDashboardText(),"Automation Testing");
    }
}
