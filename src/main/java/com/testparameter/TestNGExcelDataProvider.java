package com.testparameter;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExcelDataProvider {

    WebDriver driver;

    @DataProvider(name = "excelDataProvider")
    public Object[][] dataProviderMethod() {
        String filePath = System.getProperty("user.dir") + "\\Excel\\TestData.xlsx"; // corrected user.dir
        String sheetName = "data";
        return ExcelReader.getExcelData(filePath, sheetName); // ExcelReader utility
    }

    @Test(dataProvider = "excelDataProvider")
    public void testMethod(String username, String password) {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

       
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

       
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

       
        System.out.println("Username: " + username + " | Password: " + password);

        driver.quit();
    }
}

