package com.test.TestCases;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

@Epic("Create Course")
@Feature("Create Course")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class CreateCourse extends BaseTest {


    @Story("Create Course Event")
    @Description("Create Course Event")
    @Test( description = "Create Course Event", groups = { "create course" })
    public void createCourseEvent() {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
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

    @Story("Create Course Self Paced")
    @Description("Create Course Self Paced")
    @Test( description = "Create Self Paced", groups = { "create course" })
    public void createCourseSelfPaced() {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("2");
        dashboardSchool.createNewCourse();
        dashboardSchool.modalNewProcuctMenu();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Self Paced");
        manageMaterialCoursePage.addSessionMaterialSelfPaced("Text");
        manageMaterialCoursePage.inputFormMaterialText();
        Assert.assertEquals(manageMaterialCoursePage.successAddMaterialText(),"Successfully saved the text material");
        Assert.assertEquals(manageMaterialCoursePage.sessionText(),"Session 1");
    }

    @Story("Create Course Cohort")
    @Description("Create Course Cohort")
    @Test( description = "Create Cohort", groups = { "create course" })
    public void createCourseCohort() {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.clickNewProductButton();
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.setTitleCourse(generateRandomString());
        dashboardSchool.chooseCourseType("3");
        dashboardSchool.createNewCourse();
        Assert.assertEquals(manageMaterialCoursePage.getHeaderText(),"Cohort");
    }
}
