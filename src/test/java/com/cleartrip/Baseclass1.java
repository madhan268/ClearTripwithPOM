package com.cleartrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass1 {
	static WebDriver driver;
	
	//68.
		public static void getChrome() {
			WebDriverManager.chromedriver().setup();
	   	driver = new ChromeDriver();
		}

		 //cofig file
		  public String  getPropertyFileValue(String key) throws FileNotFoundException, IOException {
			  Properties properties = new Properties();
			  properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config\\config.properties"));
			String value  =(String)properties.get(key);
			return value;
		  }
	//1.Enter url
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	//2. Maximize window
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	//3. insert value in textbox
	public static  void text(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	//4. Click button
	public  void click(WebElement element) {
		element.click();
	}
	
	//5. Click ok in Alert
	public Alert alert() {
		Alert al = driver.switchTo().alert();
		al.accept();
		return al;
	}
	
	//6.Click cancel in Alert
	public Alert alert1() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
		return al;
	}
	
	//7.get the text from Webpage
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	//8.get the inserted value from textbox
	public  String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	
	//9. Close all window
	public static void quit() {
		driver.quit();
	}
	
	//10. Close Current Window
	public void close() {
		driver.close();
	}
	
	//11. Get the title
	public String title() {
		String title = driver.getTitle();
		return title;
	}
	
	//12.Get the Current url
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	//13. Select dropdown option by text
	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	//14. Select dropdown option by attribute
	public static  void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	//15. Select dropdown option by index
	public static void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//16. Inset value in textbox by js
	public void typeJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value'," + text + ")", element);
	}
	
	//17. Click button by Js
	public void clickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click", element);
	}
	
	//18. Launch the chrome browser
	public WebDriver launch() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	//19. Switch to Child Window
	public void child(String name) {
		driver.switchTo().window(name);
	}
	
	//20. Switch to frame by index
	public WebDriver frameindex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return frame;
	}
	
	// 21. Switch to frame by frameId
	public void frameId(String name) {
		driver.switchTo().frame(name);
	}

	// 22. Find locator by Id
	public WebElement locatorId(String id) {
		WebElement element2 = driver.findElement(By.id(id));
		return element2;
	}
		
	// 23. Find locator by name	
	public WebElement locatorName( String name) {
		WebElement element2 = driver.findElement(By.name(name));
		return element2;
	}	
	
	// 24. Find locator by classname	
	public WebElement locatorClassName( String name) {
		WebElement element2 = driver.findElement(By.className(name));
		return element2;
	}	
		

	// 25. Find locator by xpath	
	public WebElement locatorXpath( String name) {
		WebElement element2 = driver.findElement(By.xpath(name));
		return element2;
	}		
		
	//26.get the inserted value from textbox
	public String getAttributeValue1(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
		
	//27. find locator by tagname	
	public WebElement locatorTagName( String name) {
		WebElement element2 = driver.findElement(By.tagName(name));
		return element2;
	}		
		
	// 28. get the page source	
	public String getPageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
		
	//29. navigate the Url	
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	
	//30. navigate the url forward
	public void navigateUrlForward() {
		driver.navigate().forward();
	}
	
	//30. navigate the url backward
	public void navigateUrlback() {
		driver.navigate().back();
	}
	
	//31. navigate the refresh url 
	public void navigateUrlRefresh() {
		driver.navigate().refresh();
	}	
	
	//32. find locators by tagname	
	public List<WebElement> locatorsTagName(WebElement element, String name) {
		List<WebElement> elements = driver.findElements(By.tagName(name));
		return elements;
	}		
	
	// 33. Find locator by Id
	public List<WebElement> locatorsId(WebElement element, String id) {
		List<WebElement> elements = driver.findElements(By.id(id));
		return elements;
	}
			
	// 34. Find locators by name	
	public List<WebElement> locatorsName(WebElement element, String name) {
		List<WebElement> elements = driver.findElements(By.name(name));
		return elements;
	}	
		
	// 35. Find locators by classname	
	public List<WebElement> locatorsClassName(WebElement element, String name) {
		List<WebElement> elements = driver.findElements(By.className(name));
		return elements;
	}	
			

	// 36. Find locators by xpath	
	public List<WebElement> locatorsXpath(WebElement element, String name) {
		List<WebElement> elements = driver.findElements(By.xpath(name));
		return elements;
	}		
	
	// 37. Switch to frame by WebElement
	public void frameWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	// 38. Get the Parent Window id
	public String parentWindowId() {
		String handle = driver.getWindowHandle();
		return handle;
	}
	
	// 39. Get the All Window id
	public Set<String> allWindowId() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}
	
	// 40.  Get all options in dropdown
	public List<WebElement> getAllOPtions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	// 41. Get first selected options in dropdown
	public WebElement getFirstSelectedOPtion(WebElement element) {
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option;
	}
	// 42. Get All selected options in dropdown
	public List<WebElement> getAllSelectedOPtion(WebElement element) {
		Select select = new Select(element);
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		return selectedOptions;
	}	
	
	// 43. Deselect option by Index in dropdown
	public void deselectOPtionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	// 44. Deselect all in dropdown
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	// 45. Deselect option by value in dropdown
	public void deselectOPtionByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}	
		
	// 46. Deselect option by visibleText in dropdown
	public void deselectOPtionByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}	
	
	//47. Is multiple option can get selected
	public boolean isMultipleOptionSelected(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	
	//48. Scrolldown using Js
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element );
	}
	
	//49. Scrollup using Js
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	//50. Get text from popup
	public String popup() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}
	
	//51. Send message through prompt alert
	public void promptAlert(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}
	
	//52. Take Screenshot
	public File screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	
	//53. Double click
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	//54. Insert value in text box through Actions class
	public void actionsClass(WebElement element, String text, CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyDown(element, key).sendKeys(element, text).keyUp(element, key).perform();
	}
	
	//55. using enter in directly to sendkeys
	public void enterSendKey(WebElement element, String text) {
		element.sendKeys(text,Keys.ENTER);
	}
	
	// 56. Right click
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	// 57. Mouse over Action
	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click();
	}
	
	//58. Drag and Drop
	public void dragAndDrop(WebElement s, WebElement d) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}
		
	//59. Sleep by using Thread Class
	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	//60. Copy file
	public void copyFile(File s, File d) throws IOException {
		FileUtils.copyFile(s, d);
	}
	
	//61. Submit 
	public void submit(WebElement element) {
		element.submit();
	}
	
	//62. clear
	public void clear(WebElement element) {
		element.clear();
	}	
	
	//63. isEnabled
	public boolean enabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}	
	//64. isDisplayed
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}	
		
	//65. isSelected
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}		
	//66. Equals
	public boolean equals(WebElement element, Object obj) {
		boolean equals = element.equals(obj);
		return equals;
	}
	
	//67. Get value from textbox through Js
	public Object getJs(WebElement element,Object args) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Object executeScript = executor.executeScript("return arguments[0], getAttribute('value')", args);
		return executeScript;
	}
	
		

	
	
	// How to create reusable method in Excel
	public static String getData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\kumar\\eclipse-workspace\\ProjectMaven\\Excel file\\Book2.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
			
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			}else {
				double d = cell.getNumericCellValue();
				long check = Math.round(d);
				if (check == d) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(d);
				}
			}
			break;

		default:
			break;
		}
		
		return res;
		
	}
	
	
	//Write a code to update value in cell
	public void updateData(String sheetName, int rownum, int cellnum, String oldData, String newData) throws IOException {
		File file = new File("C:\\Users\\kumar\\eclipse-workspace\\ProjectMaven\\Excel file\\Book2.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	
	
	// Write a code to Insert value in cell
	public  void writeData(String sheetName, int rownum, int cellnum, String attributeValue) throws IOException {
		File file = new File("C:\\Users\\kumar\\eclipse-workspace\\ProjectMaven\\Excel file\\Book2.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(attributeValue);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

}
