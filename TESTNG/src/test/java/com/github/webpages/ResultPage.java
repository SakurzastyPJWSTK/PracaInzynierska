package com.github.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ResultPage {
    private final WebDriver driver;

    /*Lokatory*/
    @FindBys({
            @FindBy(css =".f4.text-normal"),
            @FindBy(css = ".v-align-middle")
    })
    private List<WebElement> resultsFieldList;

    @FindBys({
            @FindBy(css =".f4.text-normal"),
            @FindBy(css = ".v-align-middle")
    })
    private WebElement firstResult;

    @FindBy(css = ".d-none.d-md-block.mt-2.mt-sm-0.details-reset.details-overlay.select-menu")
    private WebElement sortMenu;

    @FindBy(className = "select-menu-item")
    private List<WebElement> sortMenuItemsList;

    @FindBy(className = "filter-item")
    private List<WebElement> filterMenuItemsList;

    //Konstruktor
    public ResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return driver.getTitle().contains("Search");
    }

    public boolean hasPageURLKeyword(String keyword){
        return driver.getCurrentUrl().contains(keyword);
    }

    public int getResultsFieldListLength(){
        return resultsFieldList.size();
    }

    public boolean isKeywordVisibleInResultList(String phrase){
        for (WebElement element: resultsFieldList
             ) {
            if (element.getText().toLowerCase().contains(phrase.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void sortMenuClick(){
        sortMenu.click();
    }

    public void clickChoosenSortMenuItem(String name){
        //for klasyczny, bo foreach nie da rady przerwać
        for(int i = 0; i < sortMenuItemsList.size(); i++){
            if (sortMenuItemsList.get(i).getText().equalsIgnoreCase(name)) {
                sortMenuItemsList.get(i).click();
                break;
            }
        }
    }

    public List<WebElement> getFilteredResultProgrammingLanguageList(String name){
        driver.navigate().refresh(); // aby ominąć problem z odświeżaniem listy wyników
        return driver.findElements(By.xpath("//*[@itemprop='programmingLanguage' and text()='" + name + "']"));
    }

    public void clickChoosenFilterMenuItem(String name){
        for(int i = 0; i < filterMenuItemsList.size(); i++){
            if (filterMenuItemsList.get(i).getText().contains(name)) {
                filterMenuItemsList.get(i).click();
                break;
            }
        }
    }
}
