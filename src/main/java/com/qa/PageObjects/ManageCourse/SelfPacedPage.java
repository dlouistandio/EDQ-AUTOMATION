package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelfPacedPage extends GeneralObject {
    WebDriver driver;

    public SelfPacedPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".section-body__group div:nth-of-type(2) > .radio-group")
    private WebElement selfPacedCourseButton;


}
