package com.simpleannotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {

	@Test

	private void softAssertDemo() {
		String word1 = "Login";
		String word2 = "login";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(word1, word2);
		System.out.println("VALIDATION DONE");
	}
	
	
}