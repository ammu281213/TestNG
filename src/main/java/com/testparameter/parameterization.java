package com.testparameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;

public class Parameterization extends Baseclass {

    @Parameters({"username", "password"})
    @Test
    
    public void testMethod(String username, String password, By driver) {
    	
        launchBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElements(By.name("username")).sendKeys(username);
        driver.findElements(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
    }
}
