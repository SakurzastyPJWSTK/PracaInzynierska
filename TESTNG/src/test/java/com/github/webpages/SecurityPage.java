package com.github.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityPage {
    private final WebDriver driver;

    /*Lokatory*/
    @FindBy(partialLinkText = "Download the guide")
    private WebElement downloadButton;

    //Konstruktor
    public SecurityPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    /*metody*/
    public boolean isPageOpened(){
        return driver.getTitle().equals("Features · Security · GitHub");
    }

    public void clickOnDownloadButton(){
        downloadButton.click();
    }


}
