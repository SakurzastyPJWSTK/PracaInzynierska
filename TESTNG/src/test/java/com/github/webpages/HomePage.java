package com.github.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    /*Lokatory*/

    //Konstruktor
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return driver.getTitle().equals("GitHub");
    }
}
