package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;

public class WindowsPage extends BaseClass{
	
	public WebDriver driver;
	
	public WindowsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By section = By.xpath(getProperty("windowsPage", "appsSection"));
	private By list = By.xpath(getProperty("windowsPage", "appsList"));
	private String number = getProperty("windowsPage", "goToPageNumber");
	private By titleList = By.xpath(getProperty("windowsPage", "appsTitleList"));
	private String titleListText = getProperty("windowsPage", "appsTitleList");
	private By priceList = By.xpath(getProperty("windowsPage", "appsPriceList"));
	private String priceText = getProperty("windowsPage", "appsPriceList");
	
	public WebElement appsSection() {
		return driver.findElement(section);
	}
	
	public List<WebElement> appsList() {
		return driver.findElements(list);
	}
	
	public WebElement goToPageNumber(int i) {
		int page = i + 1;
		return driver.findElement(By.xpath(number + "[" + page + "]"));
	}
	
	public List<WebElement> appsTitleList() {
		return driver.findElements(titleList);
	}
	
	public List<WebElement> appsPriceList() {
		return driver.findElements(priceList);
	}
	
	public String getTitle(int element) {
		By xp = By.xpath(titleListText + "[" + element + "]");
		return driver.findElement(xp).getText();
	}
	
	public String getAppPrice(int element) {
		By xp = By.xpath(priceText + "[" + element + "]");
		return driver.findElement(xp).getText();
	}
	
	public WebElement selectCard(int element) {
		By xp = By.xpath(priceText + "[" + element + "]");
		return driver.findElement(xp);
	}

}
