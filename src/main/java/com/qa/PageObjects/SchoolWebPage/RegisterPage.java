package com.qa.PageObjects.SchoolWebPage;

import io.qameta.allure.Step;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends GeneralObjectSchool{
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Sign up']")
    private WebElement goToSignUpPageButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='stack']/label[1]//input[@class='ant-checkbox-input']")
    private WebElement checkBoxAgrementPrivacy;

    @FindBy(xpath = "//label[.='I have read and agree the SaaS Agreement']")
    private WebElement checkBoxAgrementSaas;

    @FindBy(xpath = "//button[.='Enter OTP Code']")
    private WebElement enterOtpCodeButton;

    @FindBy(css = ".Button2-sc-12miqch-0")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[@id='confirmMessage']")
    private WebElement successVerifyText;

    @FindBy(css = ".ant-form-item-explain-error")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@class='ant-alert ant-alert-error ant-alert-banner']")
    private WebElement alertMessageRadioButton;

    @FindBy(css = ".otp-label")
    private WebElement otpLabelText;

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement myCoursesText;


    @Step
    public String getOtpLabelText(){
        waitElementsDisplay(otpLabelText);
        return otpLabelText.getText();
    }

    @Step
    public String getMyCoursesText(){
        waitElementsDisplay(myCoursesText);
        return myCoursesText.getText();
    }

    @Step
    public String getAlertMessage(){
        waitElementsDisplay(alertMessage);
        return alertMessage.getText();
    }

    @Step
    public String getAlertRadioButton(){
        waitElementsDisplay(alertMessageRadioButton);
        return alertMessageRadioButton.getText();
    }

    @Step
    public void clickGoToSignUpForm(){
        waitElementsDisplay(goToSignUpPageButton);
        goToSignUpPageButton.click();
    }

    @Step
    public void inputEmailField(String username){
        waitElementsDisplay(emailField);
        emailField.sendKeys(username);
    }

    @Step
    public void clickEnterOTPCodeButton(){
        waitElementsDisplay(enterOtpCodeButton);
        enterOtpCodeButton.click();
    }

    @Step
    public void inputNameField(String name){
        waitElementsDisplay(nameField);
        nameField.sendKeys(name);
    }

    @Step
    public void inputPasswordField(String pass){
        waitElementsDisplay(passwordField);
        passwordField.sendKeys(pass);
    }

    @Step
    public void clickSignUpButton(){
        waitElementsDisplay(signUpButton);
        signUpButton.click();
    }

    @Step
    public void clickAgrementPrivacy(){
        checkBoxAgrementPrivacy.click();
    }

    @Step
    public void clickAgrementSaas(){
        checkBoxAgrementSaas.click();
    }

    @Step
    public void inputOtpCodeField(String code) {
        String[] otpCode = code.split(",");

        for (int i = 1; i <= otpCode.length; i++) {
            // Get the current digit
            String digit = otpCode[i-1];

            String locator =  "//div[@class='otp-container-style']/div["+i+"]/input";
            WebElement otpInput = driver.findElement(By.xpath(locator));
            otpInput.sendKeys(String.valueOf(digit));
        }
    }

}
