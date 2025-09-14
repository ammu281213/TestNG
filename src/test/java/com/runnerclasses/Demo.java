package com.runnerclasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo {
	@BeforeClass
	public void launchURL() {
		System.out.println("URL Launched");
		
	}
	@Test(priority = 1)
public void login() {
	System.out.println("Login done");
}
}
