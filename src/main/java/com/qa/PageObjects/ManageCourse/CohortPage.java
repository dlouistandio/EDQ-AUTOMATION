package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CohortPage extends GeneralObject {
    WebDriver driver;

    public CohortPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='curriculum-session__add']/button")
    private WebElement addNewBatchButton;

    @FindBy(css = ".section-body__group div:nth-of-type(3) > .radio-group")
    private WebElement cohortCourseButton;




}
