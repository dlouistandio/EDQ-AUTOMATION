package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralObjectManageCourse extends GeneralObject {
    WebDriver driver;

    public GeneralObjectManageCourse(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='preview-tab']/a[.='Curriculum']")
    private WebElement tabCurriculum;

    @FindBy(xpath = "//div[@class='preview-tab']/a[.='Price']")
    private WebElement tabPrice;

    @FindBy(xpath = "//div[@class='preview-tab']/a[.='Course Information']")
    private WebElement tabCourseInformation;

    @FindBy(xpath = "//div[@class='preview-tab']/a[.='Advanced Setting']")
    private WebElement tabAdvancedSetting;

    @FindBy(xpath = "//div[@class='preview-tab']/a[.='Publish']")
    private WebElement tabPublish;

    @Step
    public void clickTabCurriculum(){
        tabCurriculum.click();
    }

    @Step
    public void clickTabPrice(){
        tabPrice.click();
    }

    @Step
    public void clickTabCourseInformation(){
        tabCourseInformation.click();
    }

    @Step
    public void clickTabAdvancedSetting(){
        tabAdvancedSetting.click();
    }

    @Step
    public void clickTabPublish(){
        tabPublish.click();
    }



}
