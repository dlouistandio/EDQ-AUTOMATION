package com.qa.PageObjects.DashboardSchool;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;


public class DashboardSchool extends GeneralObject {
    WebDriver driver;

    public DashboardSchool(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement dashboardText;

    @FindBy(xpath = " //div[@class='user-name']")
    private WebElement userText;

    @FindBy(xpath = "//div[@class='section-header__title']")
    private WebElement createNewProductText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement nextButton;

    @FindBy(css = ".ant-btn")
    private WebElement dateOkButton;

    @FindBy(css = "[placeholder='Select date']")
    private WebElement dateField;

    @FindBy(xpath = "//div[@class='ant-col ant-col-xs-12 ant-col-sm-12']/button[@class='sc-qRumB gyLfCK btn btn-primary']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//div[@class='addmaterial-content']/div[2]")
    private WebElement onsiteEventButton;

    @FindBy(xpath = "//Div[contains(text(),'Invitation Sent!')]")
    public WebElement invitationSentAlert;

    @FindBy(xpath = "//button[@class='btn btn-outline-primary']")
    public WebElement okModalButton;

    @FindBy(xpath = "//h1[@class='title']")
    public WebElement schoolNameText;

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement mySchoolText;

    @Step
    public String createNewProductText(){
        return createNewProductText.getText();
    }
    @Step
    public String getUsernameDashboardText(){
        waitElementsDisplay(userText);
        return userText.getText();
    }
    @Step
    public String getSchoolNameText(){
        waitElementsDisplay(schoolNameText);
        return schoolNameText.getText();
    }
    @Step
    public void chooseMenu(String menu) {
        waitElementsDisplay(dashboardText);
        String xPathSelectedMenu =  "//a[@href='"+menu+"']";
        WebElement menuContent = driver.findElement(By.xpath(xPathSelectedMenu));
        menuContent.click();
    }
    @Step
    public void chooseCourseType(String menu) {
        String xPathSelectedMenu =  "//div[@class='course-type__form']//div["+menu+"]/label[@class='radio-group']";
        WebElement menuContent = driver.findElement(By.xpath(xPathSelectedMenu));
        menuContent.click();
    }
    @Step
    public void clickNewProductButton(){
        waitElementsDisplay(buttonCreate);
        buttonCreate.click();
    }
    @Step
    public void setTitleCourse(String nameCourse){
        waitElementsDisplay(titleField);
        titleField.sendKeys(nameCourse);
    }
    @Step
    public void setDateEvent(){
        dateField.click();
        String xPathSelectedMenu =  "//tr[3]//div[.='15']";
        WebElement datePicker = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(datePicker);
        datePicker.click();
        dateOkButton.click();
    }
    @Step
    public void createNewCourse(){
        createProductButton.click();
    }
    @Step
    public void modalNewProcuctMenu(){
        waitElementsDisplay(createNewProductText);
        createBlankProductButton.click();
        nextButton.click();
    }
    @Step
    public void clickOnsiteEventButton(){
        waitElementsDisplay(onsiteEventButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", onsiteEventButton);
        onsiteEventButton.click();
    }

    @Step
    public String getSchoolText(){
        waitElementsDisplay(mySchoolText);
        return mySchoolText.getText();
    }
}
