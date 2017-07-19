package com.training.basicseleniumscripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class LaunchHTMUUnitDriver {

	@SuppressWarnings("resource")
	@Test
	public void main() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		HtmlPage webPage = null;
		HtmlInput searchBox = null;
		HtmlSubmitInput submitButton;
		WebClient webClient;

		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

		webClient = new WebClient(BrowserVersion.FIREFOX_38);
		webClient.getOptions().setThrowExceptionOnScriptError(false);

		webPage = (HtmlPage) webClient.getPage("https://www.google.co.in/");

		searchBox = webPage.getFirstByXPath("//input[@name='q']");
		searchBox.setValueAttribute("q");

		submitButton = webPage.getFirstByXPath("//input[@name='btnK']");
		HtmlPage pageAfterLogin = submitButton.click();

		System.out.println(pageAfterLogin.getUrl().toString());

		System.out.println(webPage.getTitleText());
		Assert.assertEquals("Google", webPage.getTitleText(), "Actual and expected page title did not matched.");

	}

}
