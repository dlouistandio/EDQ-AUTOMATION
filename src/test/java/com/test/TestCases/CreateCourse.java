package com.test.TestCases;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Create Course")
@Feature("Create Course")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class CreateCourse extends BaseTest {
    @BeforeMethod(groups = { "create course" })
    public void loginUser() {
        loginPage.loginUser("eduqatautomationtest@gmail.com","P@ss4eduqat");
        loginPage.clickSignInButton();
        dashboardVendor.goToSchool();
        changeTabDriver();
    }

    @Story("Create Course Event")
    @Description("Create Course Webinar")
    @Test( description = "Create Course Webinar", groups = { "create course" },priority = 1)
    public void createCourseEventWebinar() {
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("1");
        dashboardSchool.setDateEvent();
        dashboardSchool.createNewCourse();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Event");
        eventPage.inputFormWebinar();
        manageMaterialCoursePage.selectMaterialLessonType("Media");
        eventPage.addSessionMaterialEvent("Text");
        manageMaterialCoursePage.inputFormMaterialText();
        Assert.assertEquals(manageMaterialCoursePage.sessionText(),"Session 1");
    }

    @Story("Create Course Event")
    @Description("Create Course Event Onsite")
    @Test( description = "Create Course Event Onsite", groups = { "create course" },priority = 1)
    public void createCourseEventOnsite() {
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("1");
        dashboardSchool.setDateEvent();
        dashboardSchool.clickOnsiteEventButton();
        dashboardSchool.createNewCourse();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Event");
        eventPage.inputFormOnsite();
        Assert.assertEquals(manageMaterialCoursePage.sessionText(),"Session 1");
    }

    @Story("Create Course Self Paced")
    @Description("Create Course Self Paced")
    @Test( description = "Create Self Paced", groups = { "create course" },priority = 1)
    public void createCourseSelfPaced() {
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("2");
        dashboardSchool.createNewCourse();
        dashboardSchool.modalNewProcuctMenu();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Self-Paced");
        manageMaterialCoursePage.addSessionMaterialSelfPaced("Text");
        manageMaterialCoursePage.inputFormMaterialText();
        Assert.assertEquals(manageMaterialCoursePage.successAddMaterialText(),"Successfully saved the text material");
        Assert.assertEquals(manageMaterialCoursePage.sessionText(),"Session 1");
    }

    @Story("Create Course Cohort")
    @Description("Create Course Cohort")
    @Test( description = "Create Cohort", groups = { "create course" },priority = 1)
    public void createCourseCohort() {
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("3");
        dashboardSchool.createNewCourse();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Cohort");
    }
}
