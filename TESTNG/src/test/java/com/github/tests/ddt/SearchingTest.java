package com.github.tests.ddt;

import com.github.utils.DataProviderUtil;
import com.github.webpages.ResultPage;
import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SearchingTest extends BaseTest{

    // Metoda testowa
    @Test(testName = "Wyszukiwanie danych", description = "Wyszukiwanie danych",
            dataProvider = "searchProvider" , dataProviderClass = DataProviderUtil.class)
    void testSearching(String phrase){
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.clickOnSearchField();
        welcomePage.enterSearchPhrase(phrase);

        //Strona z rezultatami
        ResultPage resultPage = new ResultPage(driver);
        softAssert.assertTrue(resultPage.isPageOpened(), "To nie jest strona z wynikami wyszukiwania");
        softAssert.assertNotEquals(resultPage.getResultsFieldListLength(), 0, "Brak wyników wyszukiwania");
        softAssert.assertTrue(resultPage.isKeywordVisibleInResultList(phrase), "Pośród wyników wyszukiwania brakuje wskazanego keyworda");

        //Weryfikacja asercji miękkich w teście
        softAssert.assertAll();
    }
}

