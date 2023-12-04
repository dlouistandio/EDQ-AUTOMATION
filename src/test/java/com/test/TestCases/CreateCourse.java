package com.test.TestCases;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

@Epic("Create Course")
@Feature("Create Course")
@Link(name = "allure", type = "mylink")
@TmsLink("TMS Link")
public class CreateCourse extends BaseTest {

    @Story("Create Course Event")
    @Description("Create Course Event")
    @Test( description = "Create Course Event", groups = { "create course" })
    public void createCourseEvent() throws InterruptedException {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.createCourseEvent("Nama Course 6q5");
        Assert.assertEquals(dashboardSchool.eventText(),"Event");
        dashboardSchool.inputFormWebinar();
        dashboardSchool.selectMaterialLessonType("Media");
        dashboardSchool.addSessionMaterialEvent("Text");
        dashboardSchool.inputFormMaterialText();
        Assert.assertEquals(dashboardSchool.sessionText(),"Session 2");
        Thread.sleep(5000);
    }

    @Story("Create Course Self Paced")
    @Description("Create Course Self Paced")
    @Test( description = "Create Course Event", groups = { "create course" })
    public void createCourseSelfPaced() throws InterruptedException {
        loginPage.loginUser("vendor01eduqat@gmail.com","P@ss4eduqat");
        dashboardVendor.goToSchool();
        changeTabDriver();
        dashboardSchool.chooseMenu("/manage/classes");
        dashboardSchool.createCourseSelfPaced("Nama course w7");
        Assert.assertEquals(dashboardSchool.createNewProductText(),"Create New Product");
        dashboardSchool.modalNewProcuctMenu();
        dashboardSchool.addSessionMaterialSelfPaced("Text");
        dashboardSchool.inputFormMaterialText();
        Assert.assertEquals(dashboardSchool.successAddMaterialText(),"Successfully saved the text material");
        Assert.assertEquals(dashboardSchool.sessionText(),"Session 1");
        Thread.sleep(5000);
    }
}
