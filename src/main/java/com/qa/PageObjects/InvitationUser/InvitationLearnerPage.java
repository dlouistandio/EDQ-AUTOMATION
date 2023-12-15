package com.qa.PageObjects.InvitationUser;

import com.qa.PageObjects.DashboardSchool.DashboardSchool;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@class='ant-select ant-select-in-form-item ant-select-single ant-select-show-arrow']/div[@class='ant-select-selector']")
    private WebElement productTypeField;

    @FindBy(xpath = "//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-single ant-select-show-arrow ant-select-show-search']/div[@class='ant-select-selector']")
    private WebElement courseNameSelect;

    @FindBy(xpath = "//input[@id='course_id']")
    private WebElement courseNameField;

    @FindBy(xpath = "//button[.='Send Invite']")
    private WebElement sendInviteButton;

    @FindBy(xpath = "//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-single ant-select-show-arrow ant-select-show-search']/div[@class='ant-select-selector']")
    private WebElement batchSelect;

    @FindBy(css = "#course_id_help > .ant-form-item-explain-error")
    private WebElement courseNameAlert;

    @FindBy(css = "#price_id_help > .ant-form-item-explain-error")
    private WebElement priceAlert;

    @FindBy(css = "#course_type_help > .ant-form-item-explain-error")
    private WebElement courseTypeAlert;

    @FindBy(xpath = "//img[@alt='ic_pending_invitation']")
    private WebElement imgPendingInvitation;


    @Step
    public void clickLearnerMenuButton(){
        waitElementsDisplay(learnersMenuButton);
        learnersMenuButton.click();
    }

    @Step
    public void clickNewLearnerButton(){
        waitElementsDisplay(imgPendingInvitation);
        newLearnersButton.click();
    }

    @Step
    public void inputEmailLearnerField(String email){
        waitElementsDisplay(emailLearnerField);
        emailLearnerField.sendKeys(email);
    }

    @Step
    public void clickSelectProductType(String option){
        waitElementsDisplay(productTypeField);
        productTypeField.click();
        String cssSelectedOption =  "[title='"+option+"'] > .ant-select-item-option-content";
        WebElement selectedOption = driver.findElement(By.cssSelector(cssSelectedOption));
        waitElementsDisplay(selectedOption);
        selectedOption.click();
        waitElementsNotDisplay(selectedOption);
    }

    @Step
    public void clickSelectCourseName(String option){
        courseNameSelect.click();
        courseNameField.sendKeys(option);
        String cssSelectedOption =  "[title='"+option+"'] > .ant-select-item-option-content";
        WebElement selectedOption = driver.findElement(By.cssSelector(cssSelectedOption));
        waitElementsDisplay(selectedOption);
        selectedOption.click();
        waitElementsNotDisplay(selectedOption);
    }

    @Step
    public void clickSelectCohortBatch(String option){
        batchSelect.click();
        batchSelect.sendKeys(option);
        String cssSelectedOption =  "[title='"+option+"'] > .ant-select-item-option-content";
        WebElement selectedOption = driver.findElement(By.cssSelector(cssSelectedOption));
        waitElementsDisplay(selectedOption);
        selectedOption.click();
        waitElementsNotDisplay(selectedOption);
    }

    @Step
    public void clickSendInviteLearner(){
        sendInviteButton.click();
    }

    @Step
    public String getSuccesInvitationText(){
        waitElementsDisplay(invitationSentAlert);
        return invitationSentAlert.getText();
    }

}
