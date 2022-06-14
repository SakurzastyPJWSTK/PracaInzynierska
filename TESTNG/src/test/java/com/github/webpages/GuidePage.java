package com.github.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.time.Duration;

public class GuidePage {
    private final WebDriver driver;

    /*Lokatory*/
    @FindBy(partialLinkText = "Download")
    private WebElement downloadButton;

    @FindBy(id = "gated-full-name-1")
    private WebElement userNameField;

    @FindBy(id = "gated-email-address")
    private WebElement userEmailField;

    @FindBy(id = "gated-title")
    private WebElement userJobTitleField;

    @FindBy(id = "gated-company")
    private WebElement userCompanyField;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    //Konstruktor
    public GuidePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    /*metody*/
    public boolean isPageOpened(){
        return driver.getTitle().equals("Application Security explained: Downloadable guide to learn how to put the developer first - GitHub Resources");
    }

    public void clickOnDownloadButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", downloadButton);
    }

    public void clickOnSubmitButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", submitButton);
    }

    public void enterUserName(String name){
        userNameField.clear();
        userNameField.sendKeys(name);
    }

    public void enterUserEmail(String email){
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    public void enterUserJobTitle(String title){
        userJobTitleField.clear();
        userJobTitleField.sendKeys(title);
    }

    public void enterUserCompany(String company){
        userCompanyField.clear();
        userCompanyField.sendKeys(company);
    }

    public void scrollPageToTop(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

}
