package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
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

    public void clickTabCurriculum(){
        tabCurriculum.click();
    }

    public void clickTabPrice(){
        tabPrice.click();
    }

    public void clickTabCourseInformation(){
        tabCourseInformation.click();
    }

    public void clickTabAdvancedSetting(){
        tabAdvancedSetting.click();
    }

    public void clickTabPublish(){
        tabPublish.click();
    }



}
