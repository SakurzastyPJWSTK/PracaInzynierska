package com.github.tests.ddt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    private static ChromeDriverService service;
    private final int waitTimeInSeconds = 10;
    protected WebDriver driver;

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
    @BeforeMethod
    public void tearUp(){
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> hmap = new HashMap<>();
        hmap.put("download.default_directory", "G:\\Download");
        hmap.put("download.prompt_for_download", false);
        hmap.put("plugins.always_open_pdf_externally", true);
        options.addArguments("--test-type");
        //HEADLESS
       // options.addArguments("--headless");
       // options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("prefs", hmap);

        driver = new RemoteWebDriver(service.getUrl(), options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        //ODKOMENTOWAC TYLKO DLA POTRZEB TESTOW POROWNAN
       // pause(15000);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result){
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date today = Calendar.getInstance().getTime();
        String name = result.getName() + "_" +  dateFormat.format(today);
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path = "src/test/resources/screenshots/" + name + ".png";
            try {
                FileUtils.copyFile(scrFile, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //metoda do testow aby ominac problem z Second Rate Limit
    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
