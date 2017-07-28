package com.training.basicseleniumscripts;

import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;

public class TestClass {
	
	public FindElement findElement;
	@SuppressWarnings("static-access")
	public void test(){
		
		findElement = new FindElement();
		
		findElement.getElement(Identifier.xpath, "//head/body");
	}

}
