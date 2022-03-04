package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;

public class AppPage extends BaseClass {
	
	public WebDriver driver;
	
	public AppPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By registration = By.xpath(getProperty("appPage", "closeRegistration"));
	private By price = By.xpath(getProperty("appPage", "appPrice"));
	private By priceDiscount = By.xpath(getProperty("appPage", "appPriceDiscount"));
	private By dotButton = By.xpath(getProperty("appPage", "threeDotButton"));
	private By addCar = By.xpath(getProperty("appPage", "addToCar"));

	public WebElement closeRegistration() {
		return driver.findElement(registration);
	}
	
	public WebElement appPrice() {
		return driver.findElement(price);
	}
	
	public WebElement appPriceDiscount() {
		return driver.findElement(priceDiscount);
	}
	
	public WebElement threeDotButton() {
		return driver.findElement(dotButton);
	}
	
	public WebElement addToCar() {
		return driver.findElement(addCar);
	}

}
