package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;

public class CarPage extends BaseClass{
	
	public WebDriver driver;
	
	public CarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By header = By.xpath(getProperty("carPage", "carHeader"));
	private By items = By.xpath(getProperty("carPage", "carItems"));
	private By carText = By.xpath(getProperty("carPage", "emptyCarText"));
	private By delete = By.xpath(getProperty("carPage", "deleteItem"));
	
	public WebElement carHeader() {
		return driver.findElement(header);
	}
	
	public List<WebElement> carItems() {
		return driver.findElements(items);
	}
	
	public WebElement emptyCarText() {
		return driver.findElement(carText);
	}
	
	public WebElement deleteItem() {
		return driver.findElement(delete);
	}

}
