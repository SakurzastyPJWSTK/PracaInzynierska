package com.github.tests.ddt;

import com.github.utils.DataProviderUtil;
import com.github.webpages.GuidePage;
import com.github.webpages.SecurityPage;
import com.github.webpages.WelcomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class DownloadTest extends BaseTest{

    @Test(testName = "Download pliku pdf", description = "Download pliku pdf", dataProvider = "testData", dataProviderClass = DataProviderUtil.class)
    void testDownloadPdfFile(String name, String email, String title, String company){
        SoftAssert softAssert = new SoftAssert();

        //Strona powitalna
        WelcomePage welcomePage = new WelcomePage(driver);
        softAssert.assertTrue(welcomePage.isPageOpened(), "To nie jest strona powitalna");
        welcomePage.clickOnSecurityLink();

        //Strona security
        SecurityPage securityPage = new SecurityPage(driver);
        softAssert.assertTrue(securityPage.isPageOpened(), "To nie jest strona security");
        securityPage.clickOnDownloadButton();

        //Strona guide
        GuidePage guidePage = new GuidePage(driver);
        softAssert.assertTrue(guidePage.isPageOpened(), "To nie jest strona z guidem");

        guidePage.enterUserName(name);
        guidePage.enterUserEmail(email);
        guidePage.enterUserJobTitle(title);
        guidePage.enterUserCompany(company);
        guidePage.clickOnSubmitButton();
        guidePage.scrollPageToTop();
        guidePage.clickOnDownloadButton();

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }
}
