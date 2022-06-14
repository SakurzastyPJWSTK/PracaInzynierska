package com.github.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class WelcomePage {
    private final WebDriver driver;
    Actions actions;

    //URL strony
    private static final String WELCOMEPAGE_URL = "https://github.com/";

    /*Lokatory*/
    @FindBy(css = "a[href*='login']")
    private WebElement loginButton;

    @FindBy(how=CSS, using= ".HeaderMenu-details.details-overlay.details-reset.width-full")
    private List<WebElement> expandItems;

    @FindBys({
            @FindBy(css = "a[href*='features/security']"),
            @FindBy(xpath = "//*[contains(text(), 'Learn more about advanced security')]")
    })
    private WebElement securityLink;

    @FindBy(name = "q")
    private WebElement searchField;

    //Konstruktor
    public WelcomePage(WebDriver driver){
        this.driver=driver;
        driver.get(WELCOMEPAGE_URL);
        PageFactory.initElements(driver, this);
    }

    /*metody*/
    public boolean isPageOpened(){
        return driver.getTitle().equals("GitHub: Where the world builds software · GitHub");
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public void moveToProductItem(){
        actions = new Actions(driver);
        actions.moveToElement(expandItems.get(0)).build().perform();
    }

    public void moveToExploreItem(){
        actions = new Actions(driver);
        actions.moveToElement(expandItems.get(1)).build().perform();
    }

    public void moveToPricingItem(){
        actions = new Actions(driver);
        actions.moveToElement(expandItems.get(2)).build().perform();
    }

    public boolean isMenuProductExpand(){
        try {
            String value = expandItems.get(0).getAttribute("open");
            return value.equalsIgnoreCase("true");
        }catch(NullPointerException e){
            return false;
        }
    }

    public boolean isMenuExploreExpand(){
        try {
            String value = expandItems.get(1).getAttribute("open");
            return value.equalsIgnoreCase("true");
        }catch(NullPointerException e){
            return false;
        }
    }

    public boolean isMenuPricingExpand(){
        try {
            String value = expandItems.get(2).getAttribute("open");
            return value.equalsIgnoreCase("true");
        }catch(NullPointerException e){
            return false;
        }
    }

    public void clickOnSecurityLink(){
        securityLink.click();
    }

    public void clickOnSearchField(){
        searchField.click();
    }

    public void enterSearchPhrase(String phrase){
        searchField.clear();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.ENTER);
    }
}
