package com.github.tests.ddt;

import com.github.utils.DataProviderUtil;
import com.github.webpages.ResultPage;
import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class FilteringTest extends BaseTest{

    String phrase = "gradle";

    // Metoda testowa
    @Test(testName = "Filtrowanie danych", description = "Filtrowanie danych",
            dataProvider = "filteringProvider" , dataProviderClass = DataProviderUtil.class)
    void testFiltering(String filtrType) {
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.clickOnSearchField();
        welcomePage.enterSearchPhrase(phrase);

        //Strona z rezultatami
        ResultPage resultPage = new ResultPage(driver);
        softAssert.assertTrue(resultPage.isPageOpened(), "To nie jest strona z wynikami wyszukiwania");
        resultPage.clickChoosenFilterMenuItem(filtrType);
        softAssert.assertTrue(resultPage.hasPageURLKeyword(filtrType), "URL strony z filtrami nie jest poprawny");
        softAssert.assertEquals(resultPage.getFilteredResultProgrammingLanguageList(filtrType).size(), 10, "Niepoprawna liczba wyników po filtrowaniu");

        //Weryfikacja asercji miękkich w teście
        softAssert.assertAll();
    }
}

