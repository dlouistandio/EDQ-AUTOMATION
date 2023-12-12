package com.qa.PageObjects.EmailPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailInbox extends GeneralObject {
    WebDriver driver;

    public EmailInbox(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='anything']")
    private WebElement toEmailInboxField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn btn-primary']")
    private WebElement checkEmailButton;

    @FindBy(xpath = "//tr[2]//div[@class='inbox-subject ng-binding']")
    private WebElement emailReceive;

    @FindBy(xpath = "//a[.='Verify Email']")
    private WebElement verifyEmailButton;

    @FindBy(xpath = "//a[.='Unblock links and images ↗']")
    private WebElement unblockLink;

    @FindBy(css = "h3")
    private WebElement codeVerifyForgotPasswordText;

    @FindBy(css = "tr:nth-of-type(4) h3")
    private WebElement codeVerifySignUpSchool;

    @FindBy(xpath = "//a[.='Accept Invitation']")
    private WebElement emailInvButton;

    @FindBy(css = " .max-w-2xl")
    private WebElement invitionPageText;

    @Step
    public String getCodeVerifyForgotPasswordText(){
        waitElementsDisplay(codeVerifyForgotPasswordText);
        return codeVerifyForgotPasswordText.getText();
    }

    @Step
    public String getCodeVerifyRegisterSchool(){
        waitElementsDisplay(codeVerifySignUpSchool);
        return codeVerifySignUpSchool.getText();
    }
    @Step
    public void inputEmailInboxField(String email){
        waitElementsDisplay(toEmailInboxField);
        toEmailInboxField.sendKeys(email);
    }

    @Step
    public void clickCheckEmailButton(){
        waitElementsDisplay(checkEmailButton);
        checkEmailButton.click();
    }

    @Step
    public void clickEmail(){
        waitElementsDisplay(emailReceive);
        emailReceive.click();
    }

    @Step
    public void clickVerifyEmailButton(){
        waitElementsDisplay(verifyEmailButton);
        verifyEmailButton.click();
    }

    @Step
    public void clickUnblockLinkButton(){
        waitElementsDisplay(unblockLink);
        unblockLink.click();
    }

    @Step
    public void clickAcceptInvButton(){
        waitElementsDisplay(emailInvButton);
        emailInvButton.click();
    }

    @Step
    public String getInvitationPageText(){
        waitElementsDisplay(invitionPageText);
        return invitionPageText.getText();
    }
}
