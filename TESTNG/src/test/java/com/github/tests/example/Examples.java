package com.github.tests.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Examples {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeSuite
    public static void startService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterSuite
    public void stopService(){
        service.stop();
    }

    @BeforeTest
    public void tearUp(){
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    // Metoda testowa
    @Ignore
    @Test
    void testLoginWithCorrectData(){
        Reporter.log("Ten test weryfikuje poprawność procesu logowania " +
                "dla użytkownika posługującego się prawidłowymi danymi");
        SoftAssert softAssert = new SoftAssert();
        String exceptedTitle;

        //Strona powitalna
        driver.get("https://github.com/");
        exceptedTitle = "GitHub: Where the world builds software · GitHub";
        softAssert.assertEquals(driver.getTitle(), exceptedTitle);

        //Strona logowania
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        exceptedTitle = "Sign in to GitHub · GitHub";
        softAssert.assertEquals(driver.getTitle(), exceptedTitle);

        //Strona domowa
        driver.findElement(By.cssSelector("#login_field")).sendKeys("Sakurzasty");
        driver.findElement(By.cssSelector("#password")).sendKeys("VmSv8[].7BJ\\/52W4{WsZl%;");
        driver.findElement(By.cssSelector("[name='commit']")).click();
        exceptedTitle = "GitHub";
        softAssert.assertEquals(driver.getTitle(), exceptedTitle);

        //Weryfikacja asercji w teście
        softAssert.assertAll();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    void testNoSuchException(){
        driver.get("https://github.com/");
        driver.findElement(By.cssSelector("a[href*='loginy']")).click();
    }

    @Test()
    void openBrowser(){
        driver.get("https://github.com/");
    }

    @Test(dependsOnMethods = {"openBrowser"})
    void checkPageTitle(){
        String exceptedTitle = "GitHub: Where the world builds software · GitHub";
        Assert.assertEquals(driver.getTitle(), exceptedTitle);
    }
}
