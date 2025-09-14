package com.simpleannotations;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.retrylogic.RetryAnalyzer;

public class RetryTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test1() {
        System.out.println("Running test1");
        Assert.assertTrue(false); 
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test2() {
        System.out.println("Running test2");
        Assert.assertTrue(true);
    }
}
