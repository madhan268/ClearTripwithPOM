package com.cleartrip;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ExecuteAllPage extends Baseclass1 {
	@BeforeClass
	public static void beforeClass() {
		getChrome();
		loadUrl("https://www.cleartrip.com/flights");
		maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void afterClass() {
		 quit();

	}

	@Test
	public void test1() throws IOException, InterruptedException, AWTException {

		FlighSearchPage page = new FlighSearchPage();

		click(page.getCancelSignUp());
		click(page.getOneWay());
		click(page.getRoundTrip());
		text(page.getFrom(), "BLR");
		sleep(3000);
		List<WebElement> mumbai = driver.findElements(By.xpath("//div[@class='mr-4']//child::p"));
		for (int i = 0; i < mumbai.size(); i++) {
			String text = mumbai.get(i).getText();
			System.out.println(text);
			if (text.contains("BLR")) {
				mumbai.get(i).click();
				break;
			}
		}
		text(page.getTo(), "DEL");
		sleep(3000);
		List<WebElement> delhi = driver.findElements(By.xpath("//div[@class='mr-4']//child::p"));
		for (int i = 0; i < delhi.size(); i++) {
			String texts = delhi.get(i).getText();
			System.out.println(texts);
			if (texts.contains("DEL")) {
				delhi.get(i).click();
				break;
			}
		}

		click(page.getReturnDate());
		click(page.getClickReturnDate());
		click(page.getEconomyClass());
		click(page.getAdult());
		click(page.getChild());
		click(page.getEconomyClass());
		click(page.getSearchFlight());

		sleep(8000);
		FlightBookingPage page_2 = new FlightBookingPage();
		frameindex(0);
		driver.switchTo().defaultContent();
		click(page_2.getBookButton());
	}

}


