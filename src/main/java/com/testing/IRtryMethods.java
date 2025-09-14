package com.testing;

import org.junit.Assert;
import org.testng.annotations.Test;

public class IRtryMethods extends BaseClass {

    @Test(retryAnalyzer = Restest.class)  
    public void Retrymethod() {
        
        browserLanuch("chrome");
 LaunchUrl("https://www.facebook.com");
String currentUrl = driver.getCurrentUrl();
Assert.assertEquals(currentUrl, "https://www.facebook.com/");

     
        browserClose();
    }
}

		 		
	