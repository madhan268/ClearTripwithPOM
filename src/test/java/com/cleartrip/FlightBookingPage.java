package com.cleartrip;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPage extends Baseclass1 {

	public FlightBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='checkbox__mark bs-border bc-neutral-500 bw-1 ba'])[3]")
	private WebElement checkBox;
	
	@FindBy(xpath="//p[contains(text(),'Flight details')]")
	private WebElement flightDetails;
	
	@FindBy(xpath="//button[@class='bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-1 px-3 h-8 fs-3 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")
	private WebElement bookButton;
	
	@FindBy(xpath="(//div[@class='flex'])[3]")
	private WebElement fareButton;

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getFlightDetails() {
		return flightDetails;
	}

	public WebElement getBookButton() {
		return bookButton;
	}

	public WebElement getFareButton() {
		return fareButton;
	}
	
}
