package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    protected WebDriver driver;

    public void browserLanuch(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void LaunchUrl(String url) {
        driver.get(url);
    }

    public void browserClose() {
        if (driver != null) {
            driver.quit();
        }
    }
}

