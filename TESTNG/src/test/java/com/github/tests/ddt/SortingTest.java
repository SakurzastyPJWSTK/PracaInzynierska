package com.github.tests.ddt;

import com.github.utils.DataProviderUtil;
import com.github.webpages.ResultPage;
import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SortingTest extends BaseTest{

    String phrase = "bdd";

    // Metoda testowa
    @Test(testName = "Sortowanie danych", description = "Sortowanie danych",
            dataProvider = "sortingProvider" , dataProviderClass = DataProviderUtil.class)
    void testSorting(String sortType, String firstKeyword, String secondKeyword) {
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.clickOnSearchField();
        welcomePage.enterSearchPhrase(phrase);

        //Strona z rezultatami
        ResultPage resultPage = new ResultPage(driver);
        softAssert.assertTrue(resultPage.isPageOpened(), "To nie jest strona z wynikami wyszukiwania");
        resultPage.sortMenuClick();
        resultPage.clickChoosenSortMenuItem(sortType);
        softAssert.assertTrue(resultPage.hasPageURLKeyword(firstKeyword), "URL strony z sortowaniem nie jest poprawny, brak:" + firstKeyword);
        softAssert.assertTrue(resultPage.hasPageURLKeyword(secondKeyword), "URL strony z sortowaniem nie jest poprawny, brak:" + secondKeyword);

        //Weryfikacja asercji miękkich w teście
        softAssert.assertAll();
    }
}

