package com.testparameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test(retryAnalyzer = ReTest.class)
    public void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }
}
