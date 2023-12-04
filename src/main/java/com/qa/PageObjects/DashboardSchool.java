package com.qa.PageObjects;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@class='ant-col ant-col-xs-12 ant-col-sm-12']/button[@class='sc-qRumB gyLfCK btn btn-primary']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//div[@class='section-body__group']//input[@name='courseName']")
    private WebElement titleField;

    @FindBy(xpath = "//div[@class='course-type__form']//div[1]/label[@class='radio-group']")
    private WebElement eventCourseButton;

    @FindBy(css = ".section-body__group div:nth-of-type(2) > .radio-group")
    private WebElement selfPacedCourseButton;

    @FindBy(css = ".ant-btn")
    private WebElement dateOkButton;

    @FindBy(css = "[placeholder='Select date']")
    private WebElement dateField;

    @FindBy(xpath = "//div[@class='section-footer']//button[@class='sc-qRumB gyLfCK btn btn-primary']")
    private WebElement createProductButton;

    @FindBy(xpath = "//div[@class='left-header__text']")
    private WebElement headerText;

    @FindBy(xpath = "//div[@class='form-group']/input[@placeholder='Write lesson title']")
    private WebElement titleMaterial;

    @FindBy(xpath = "//div[@class='form-group']/input[@placeholder='Insert your webinar link here..']")
    private WebElement linkWebinar;

    @FindBy(xpath = "//div[@class='DraftEditor-root']")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']/span[1]")
    private WebElement descriptionFieldInput;

    @FindBy(xpath = "//div[@class='duration-picker']/input[1]")
    private WebElement durationField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement saveMaterialButton;

    @FindBy(xpath = "//h3[.='Session 1']")
    private WebElement sessionText;

    @FindBy(xpath = "//div[@class='section-header__title']")
    private WebElement createNewProductText;

    @FindBy(xpath = "//div[@class='ant-card ant-card-bordered active']/div[@class='ant-card-body']")
    private WebElement createBlankProductButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='curriculum-session__add']/button")
    private WebElement addLessonButton;

    @FindBy(xpath = "//div[@class='session-add']/button")
    private WebElement addMaterialSessionButton;

    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement successAddMaterialAlert;


    public String eventText(){
        waitElementsDisplay(headerText);
        return headerText.getText();
    }

    public String sessionText(){
        return sessionText.getText();
    }

    public String createNewProductText(){
        return createNewProductText.getText();
    }

    public String successAddMaterialText(){
        return successAddMaterialAlert.getText();
    }

    public void chooseMenu(String menu) {
        waitElementsDisplay(dashboardText);
        String xPathSelectedMenu =  "//a[@href='"+menu+"']";
        WebElement menuContent = driver.findElement(By.xpath(xPathSelectedMenu));
        menuContent.click();
    }

    public void createCourseEvent(String nameCourse){
        waitElementsDisplay(buttonCreate);
        buttonCreate.click();
        waitElementsDisplay(titleField);
        titleField.sendKeys(nameCourse);
        eventCourseButton.click();
        dateField.click();
        String xPathSelectedMenu =  "//tr[3]//div[.='15']";
        WebElement datePicker = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(datePicker);
        datePicker.click();
        dateOkButton.click();
        createProductButton.click();
    }

    public void createCourseSelfPaced(String nameCourse){
        waitElementsDisplay(buttonCreate);
        buttonCreate.click();
        waitElementsDisplay(titleField);
        titleField.sendKeys(nameCourse);
        selfPacedCourseButton.click();
        createProductButton.click();
    }

    public void modalNewProcuctMenu(){
        waitElementsDisplay(createNewProductText);
        createBlankProductButton.click();
        nextButton.click();
    }

    public void addSessionMaterialSelfPaced(String material){
        waitElementsDisplay(headerText);
        addLessonButton.click();
        addMaterialSessionButton.click();
        String xPathSelectedMenu =  "//div[.='"+ material +"']";
        WebElement addMaterialButton = driver.findElement(By.xpath(xPathSelectedMenu));
        addMaterialButton.click();
    }

    public void addSessionMaterialEvent(String material){
        String xPathSelectedMenu =  "//div[.='"+ material +"']";
        WebElement addMaterialButton = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(addMaterialButton);
        addMaterialButton.click();
    }

    public void inputFormWebinar(){
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Zoom");
        linkWebinar.sendKeys("zoom");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        durationField.sendKeys("1");
        saveMaterialButton.click();
    }

    public void inputFormMaterialText(){
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Ini Text");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        durationField.sendKeys("1");
        saveMaterialButton.click();
        waitElementsDisplay(successAddMaterialAlert);
    }
    //Select material lesson Exam, Media
    public void selectMaterialLessonType(String type){
        waitElementsDisplay(addMaterialSessionButton);
        addMaterialSessionButton.click();
        String xPathSelectedMenu =  "//div[.='"+ type +"']";
        WebElement materialLessonType = driver.findElement(By.xpath(xPathSelectedMenu));
        materialLessonType.click();
    }

}
