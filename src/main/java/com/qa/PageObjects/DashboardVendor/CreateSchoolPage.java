package com.qa.PageObjects.DashboardVendor;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSchoolPage extends GeneralObject {
    WebDriver driver;

    public CreateSchoolPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='site_title']")
    private WebElement schoolNameField;

    @FindBy(css = ".text-center")
    private WebElement saveAndContinueButton;

    @FindBy(css = ".ant-btn")
    private WebElement saveButtonForm;

    @FindBy(xpath = "//div[@class='ant-space-item']/div[contains(text(),'Tell us about yourself')]")
    private WebElement formNewSchoolHeaderText;

    @FindBy(css = ".text-2xl")
    private WebElement getStartedWithEduqatText;

    @FindBy(xpath = "//input[@id='basic_jobTitle']")
    private WebElement jobOption;

    @FindBy(xpath = "//input[@id='basic_haveTeach']")
    private WebElement haveTeachOption;

    @FindBy(xpath = "//input[@id='basic_sellingCourseRevenue']")
    private WebElement courseRevenueOption;

    @FindBy(xpath = "//input[@id='basic_audienceSize']")
    private WebElement audienceSizeOption;

    @FindBy(xpath = "//input[@id='basic_countryCode']")
    private WebElement countryOption;

    @FindBy(xpath = "//input[@id='basic_currency']")
    private WebElement currencyOption;

    @FindBy(xpath = "//input[@id='basic_timezone']")
    private WebElement timezoneOption;


    public void inputSchoolName(String name){
        waitElementsDisplay(schoolNameField);
        schoolNameField.sendKeys(name);
    }

    public void clickContinueButton(){
        saveAndContinueButton.click();
    }

    public void clickSaveInformation(){
        saveButtonForm.click();
    }

    public String getFormHeaderText(){
        waitElementsDisplay(formNewSchoolHeaderText);
        return formNewSchoolHeaderText.getText();
    }

    public String getStartedWithEduqatText(){
        waitElementsDisplay(getStartedWithEduqatText);
        return getStartedWithEduqatText.getText();
    }

    public void clickJobsOption(){
        waitElementsDisplay(jobOption);
        jobOption.click();
    }

    public void clickHaveTeachOption(){
        waitElementsDisplay(haveTeachOption);
        haveTeachOption.click();
    }

    public void clickCourseRevenueOption(){
        waitElementsDisplay(courseRevenueOption);
        courseRevenueOption.click();
    }

    public void clickAudienceSizeOption(){
        waitElementsDisplay(audienceSizeOption);
        audienceSizeOption.click();
    }

    public void inputCountryOption(String country){
        waitElementsDisplay(countryOption);
        countryOption.click();
        countryOption.sendKeys(country, Keys.ENTER);
    }

    public void clickCurrencyOption(){
        waitElementsDisplay(currencyOption);
        currencyOption.click();
    }

    public void clickTimezoneOption(){
        waitElementsDisplay(timezoneOption;
        timezoneOption.click();
    }

    public void selectOption(String option){
        String cssSelectedOption =  "[title='"+option+"'] > .ant-select-item-option-content";
        WebElement selectedOption = driver.findElement(By.cssSelector(cssSelectedOption));
        waitElementsDisplay(selectedOption);
        selectedOption.click();
    }

    public void selectLanguage(String option){
        String cssSelectedLanguage =  ".ant-space-horizontal > div:nth-of-type("+option+") .eduqate-radio__checkmark";
        WebElement selectedLanguage = driver.findElement(By.cssSelector(cssSelectedLanguage));
        waitElementsDisplay(selectedLanguage);
        selectedLanguage.click();
    }


    public void selectTimezone(String option){
        String cssSelectedTimezone =  ".ant-slide-up-leave div:nth-of-type("+option+") > .ant-select-item-option-content";
        WebElement selectedTimezone = driver.findElement(By.cssSelector(cssSelectedTimezone));
        waitElementsDisplay(selectedTimezone);
        selectedTimezone.click();
    }

}
