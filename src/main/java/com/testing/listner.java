package com.testing

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.listeners.MyTestListener.class)
public class MyTestClass {

    @Test
    public void test1() {
        System.out.println("Running Test 1");
    }

    @Test
    public void test2() {
        throw new RuntimeException("Failing Test 2");
    }
}
