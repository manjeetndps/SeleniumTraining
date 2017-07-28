package com.training.pagefactory;

import com.training.pageobjects.DragAndDropPage;
import com.training.pageobjects.FramesAndWindowsPage;
import com.training.pageobjects.HomePage;
import com.training.pageobjects.RegistrationPage;
import com.training.pageobjects.SignInPage;
import com.training.pageobjects.WThreeSchoolPage;
import com.training.pageobjects.WidgetPage;

public class PageFactory {

	
	public static SignInPage getSignInPage(){
		return new SignInPage();
	}
	
	public static HomePage getHomePage(){
		return new HomePage();
	}
	
	public static DragAndDropPage getDragAndDropPage(){
		return new DragAndDropPage();
	}
	
	public static FramesAndWindowsPage getFramesAndWindowsPage(){
		return new FramesAndWindowsPage();
	}
	
	public static RegistrationPage getRegistrationPage(){
		return new RegistrationPage();
	}
	
	public static WidgetPage getWidgetPage(){
		return new WidgetPage();
	}
}
