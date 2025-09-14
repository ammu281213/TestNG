package com.simpleannotations;

import org.testng.annotations.Test;

public class Dependancy {

    @Test
    public void login() {
        System.out.println("LOGIN");
    }

    @Test(dependsOnMethods = {"login"})
    public void search() {
        System.out.println(10 / 2); 
        System.out.println("SEARCH");
    }

    @Test(dependsOnMethods = {"login", "search"})
    public void payment() {
        System.out.println("PAYMENT");
    }
}
