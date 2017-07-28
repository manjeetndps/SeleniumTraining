package com.training.abcofselenium;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class LaunchHTMUUnitDriver {


	@SuppressWarnings("resource")
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		HtmlPage webPage = null;
		HtmlInput searchBox = null;
		HtmlSubmitInput submitButton;
		WebClient webClient;

		webClient = new WebClient(BrowserVersion.FIREFOX_38);
		webClient.getOptions().setThrowExceptionOnScriptError(false);

		webPage = webClient.getPage("https://www.google.co.in/");

		searchBox = webPage.getFirstByXPath("//input[@name='q']");
		searchBox.setValueAttribute("q");

		submitButton = webPage.getFirstByXPath("//input[@name='btnK']");
		HtmlPage pageAfterLogin = submitButton.click();

		System.out.println(pageAfterLogin.getUrl().toString());

		System.out.println("Page title is->> " + webPage.getTitleText());
	}

}
