package com.github.tests.ddt;

import com.github.utils.DataProviderUtil;
import com.github.webpages.HomePage;
import com.github.webpages.LoginPage;
import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

    @AfterMethod
    void clearCookies(){
        driver.manage().deleteAllCookies();
    }

    // Metoda testowa
    @Test(testName = "Logowanie z poprawnymi danymi", description = "Logowanie z poprawnymi danymi",
            dataProvider = "loginProvider", dataProviderClass = DataProviderUtil.class)
    void testLoginWithCorrectData(String userLogin, String userPassword){
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.clickOnLogin();

        //Strona logowania
        LoginPage loginPage = new LoginPage(driver);
        softAssert.assertTrue(loginPage.isPageOpened(), "To nie jest strona logowania");
        loginPage.enterUserEmail(userLogin);
        loginPage.enterUserPassword(userPassword);
        loginPage.clickOnLogin();


        //Strona domowa
        HomePage homePage = new HomePage(driver);
        softAssert.assertTrue(homePage.isPageOpened(), "To nie jest strona domowa");

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }
}

