package com.github.tests.ddt;

import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class MouveHoverTest extends BaseTest{

    // Metoda testowa
    @Test(testName = "Weryfikacja Product Item", description = "Weryfikacja Product Item")
    void testExpandProductItemList(){
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.moveToProductItem();
        softAssert.assertTrue(welcomePage.isMenuProductExpand(), "Menu nie jest otwarte");

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }

    // Metoda testowa
    @Test(testName = "Weryfikacja Explore Item", description = "Weryfikacja Explore Item")
    void testExpandExploreItemList() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.moveToExploreItem();
        softAssert.assertTrue(welcomePage.isMenuExploreExpand(), "Menu nie jest otwarte");

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }

    // Metoda testowa
    @Test(testName = "Weryfikacja Pricing Item", description = "Weryfikacja Pricing Item")
    void testExpandPricingItemList(){
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.moveToPricingItem();
        softAssert.assertTrue(welcomePage.isMenuPricingExpand(), "Menu nie jest otwarte");

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }
}

