package com.qa.PageObjects.InvitationUser;

import com.qa.PageObjects.DashboardSchool.DashboardSchool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitationLearnerPage extends DashboardSchool {
    WebDriver driver;

    public InvitationLearnerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Learners']")
    private WebElement learnersMenuButton;

    @FindBy(xpath = "//Button[contains(text(),'Enroll Learners')]")
    private WebElement enrollLearnersButton;

    @FindBy(xpath = "//Button[contains(text(),'New Learners')]")
    private WebElement newLearnersButton;

    @FindBy(css = "[aria-owns='rc_select_0_list']")
    private WebElement emailLearnerField;

    @FindBy(xpath = "//input[@id='course_type']")
    private WebElement productTypeField;

    @FindBy(xpath = "//input[@id='course_id']")
    private WebElement courseNameField;

    @FindBy(xpath = "//button[.='Send Invite']")
    private WebElement sendInviteButton;

    @FindBy(css = "#course_id_help > .ant-form-item-explain-error")
    private WebElement courseNameAlert;

    @FindBy(css = "#price_id_help > .ant-form-item-explain-error")
    private WebElement priceAlert;

    @FindBy(css = "#course_type_help > .ant-form-item-explain-error")
    private WebElement courseTypeAlert;

}
