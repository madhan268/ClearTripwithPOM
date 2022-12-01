package com.cleartrip;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlighSearchPage extends Baseclass1 {
	public FlighSearchPage() {
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(xpath="//div[@class='px-1   flex flex-middle nmx-1 pb-1']")
	private WebElement cancelSignUp;
	
	@FindBy(xpath="(//span[contains(text(),'One way')])[1]")
	private WebElement oneWay;

	@FindBy(xpath="(//div[@class='flex flex-between'])[2]")
	private WebElement roundTrip;
	
	@FindBy(xpath="(//input[@class='w-100p fs-4 fw-500 c-neutral-500'])[1]")
	private WebElement from;
	
	@FindBy(xpath="//input[@class='w-100p fs-4 fw-500 c-neutral-500']")
	private WebElement to;
	

	@FindBy(xpath="//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-6']")
	private WebElement returnDate;
	
	@FindBy(xpath="(//div[@class='DayPicker-Month'])[2]//descendant::div[@class='p-1 day-gridContent fs-14 fw-500 flex flex-middle flex-column flex-center Round-trip'][4]") 
			
	private WebElement clickReturnDate;
	

	@FindBy(xpath="//div[@class='p-relative br-4']")
	private WebElement economyClass;
	
	@FindBy(xpath="(//li[@class='flex-inline'])[1]")
	private WebElement adult;
	
	@FindBy(xpath="(//li[@class='flex-inline'])[2]")
	private WebElement child;
	
	@FindBy(xpath="//span[contains(text(),'Search flights')]")
	private WebElement searchFlight;
	
	public WebElement getCancelSignUp() {
		return cancelSignUp;
	}

	public WebElement getOneWay() {
		return oneWay;
	}

	public WebElement getRoundTrip() {
		return roundTrip;
	}

	public WebElement getFrom() {
		return from;
	}
	
	public WebElement getTo() {
		return to;
	}



	public WebElement getReturnDate() {
		return returnDate;
	}

	public WebElement getClickReturnDate() {
		return clickReturnDate;
	}

	public WebElement getEconomyClass() {
		return economyClass;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSearchFlight() {
		return searchFlight;
	}

	

}
