package com.qa.PageObjects.InvitationUser;
import com.qa.PageObjects.DashboardSchool.DashboardSchool;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitationUserPage extends DashboardSchool {
    WebDriver driver;

    public InvitationUserPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//Button[contains(text(),'New User')]")
    private WebElement newUserButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inviteEmailField;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@class='ant-select-selector']")
    private WebElement roleSelectorDropdown;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement removeUserButton;

    @FindBy(xpath = "//Button[contains(text(),'Send Invitation')]")
    private WebElement sendInvitationButton;

    @FindBy(xpath = "//div[@class='ant-alert-message']")
    private WebElement alertMessage;

    @FindBy(xpath = "//li[.='Users']")
    private WebElement userNavText;

    @FindBy(xpath = "//th[.='Name']")
    private WebElement tableText;

    @FindBy(xpath = "//Button[contains(text(),'Register')]")
    private WebElement registerEmailButton;

    @Step
    public void clickNewUserButton(){
        waitElementsDisplay(tableText);
        newUserButton.click();
    }

    @Step
    public void inputEmailField(String email){
        waitElementsDisplay(inviteEmailField);
        inviteEmailField.sendKeys(email);
    }

    @Step
    public void clickAddButton(){
        addButton.click();
    }

    @Step
    public void clickRoleSelector(){
        roleSelectorDropdown.click();
    }

    @Step
    public void clickRemoveUser(){
        removeUserButton.click();
    }

    @Step
    public void clickSendInvitation(){
        sendInvitationButton.click();
    }

    @Step
    public String getAlertMessage(){
        waitElementsDisplay(alertMessage);
        return alertMessage.getText();
    }

    @Step
    public String getSuccesInvitationText(){
        waitElementsDisplay(invitationSentAlert);
        return invitationSentAlert.getText();
    }

    @Step
    public String getUserNavText(){
        waitElementsDisplay(userNavText);
        return userNavText.getText();
    }

    @Step
    public void clickOkButtonModal(){
        okModalButton.click();
    }

    @Step
    public void selectRole(String option){
        String cssSelectedOption =  "[title='"+option+"'] > .ant-select-item-option-content";
        WebElement selectedOption = driver.findElement(By.cssSelector(cssSelectedOption));
        waitElementsDisplay(selectedOption);
        selectedOption.click();
    }

    @Step
    public void clickRegisterEmailButton(){
        registerEmailButton.click();
    }
}
