package com.qa.PageObjects.SchoolWebPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordSchoolPage extends GeneralObjectSchool{
    WebDriver driver;

    public ForgotPasswordSchoolPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Log in']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[.='Forgot Password?']")
    private WebElement goToForgotPasswordButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(css = ".submit-btn")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@id='code']")
    private WebElement codeField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='re_password']")
    private WebElement reEnterPasswordField;

    @FindBy(css = ".Button2-sc-12miqch-0")
    private WebElement confirmChangePasswordButton;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    private WebElement fieldAlert;

    @FindBy(xpath = "//div[@class='ant-alert-message']")
    private WebElement wrongAlert;

    @FindBy(xpath = "//h2[contains(text(),'Reset Password')]")
    private WebElement resetPasswordText;


    @Step
    public String getFieldAlert(){
        waitElementsDisplay(fieldAlert);
        return fieldAlert.getText();
    }

    @Step
    public String getWrongAlert(){
        waitElementsDisplay(wrongAlert);
        return wrongAlert.getText();
    }

    @Step
    public void clickGoToForgotPassword(){
        waitElementsDisplay(goToForgotPasswordButton);
        goToForgotPasswordButton.click();
    }

    @Step
    public void inputEmailField(String email){
        waitElementsDisplay(emailField);
        emailField.sendKeys(email);
    }

    @Step
    public void clickResetButton(){
        waitElementsDisplay(resetPasswordButton);
        resetPasswordButton.click();
    }

    @Step
    public void inputCodeForgotEmailField(String code){
        waitElementsDisplay(codeField);
        codeField.sendKeys(code);
    }

    @Step
    public void inputNewPasswordField(String pass){
        waitElementsDisplay(newPasswordField);
        newPasswordField.sendKeys(pass);
    }

    @Step
    public void inputReEnterNewPasswordField(String reEnter){
        waitElementsDisplay(reEnterPasswordField);
        reEnterPasswordField.sendKeys(reEnter);
    }

    @Step
    public void clickConfirmReset(){
        waitElementsDisplay(confirmChangePasswordButton);
        confirmChangePasswordButton.click();
        waitElementsNotDisplay(resetPasswordText);
    }

    @Step
    public void clickLoginButton(){
        waitElementsDisplay(loginButton);
        loginButton.click();
    }
}
