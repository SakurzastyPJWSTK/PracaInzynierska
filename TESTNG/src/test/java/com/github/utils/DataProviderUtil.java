package com.github.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtil {
    @DataProvider(name = "loginProvider")
    public static Object[][] loginProvider() {
        return Utils.getWorksheetData("src/test/java/com/github/data/data.xlsx", "login");
    }

    @DataProvider(name = "searchProvider")
    public static Object[][] searchProvider() {
        return Utils.getWorksheetData("src/test/java/com/github/data/data.xlsx", "search");
    }

    @DataProvider(name = "sortingProvider")
    public static Object[][] sortingProvider() {
        return Utils.getWorksheetData("src/test/java/com/github/data/data.xlsx", "sort");
    }

    @DataProvider(name = "filteringProvider")
    public static Object[][] filteringProvider() {
        return Utils.getWorksheetData("src/test/java/com/github/data/data.xlsx", "filter");
    }

    @DataProvider(name="testData")
    public static Object[][] downloadDataProvider(Method m){
        if ("testDownloadPdfFile".equals(m.getName())) {
            return new Object[][]{{"Jan Nowak", "test@test.com", "Student", "PJATK"}};
        }
        return new Object[][]{{"gradle"}};
    }


}
