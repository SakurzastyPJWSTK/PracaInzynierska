package com.github.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    /*Lokatory*/
    @FindBy(id = "login_field")
    private WebElement userEmailField;

    @FindBy(id = "password")
    private WebElement userPasswordField;

    @FindBy(name = "commit")
    private WebElement loginButton;

    //Konstruktor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return driver.getTitle().equals("Sign in to GitHub · GitHub");
    }

    public void enterUserEmail(String email){
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    public void enterUserPassword(String password){
        userPasswordField.clear();
        userPasswordField.sendKeys(password);
    }

    public void clickOnLogin(){
        loginButton.click();
    }
}
