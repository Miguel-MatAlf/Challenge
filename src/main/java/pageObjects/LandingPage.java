package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;

public class LandingPage extends BaseClass{
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	we cannot define locators for Page elements on page level using Properties file in POM using Page Factory model
//	so we will need to pass directly the xpath and it will work
//	@FindBy(xpath = getProperty("landingPage", "windows"))
//	private WebElement var;
	
	private By windows = By.xpath(getProperty("landingPage", "windows"));
	private By icon = By.xpath(getProperty("landingPage", "searchIcon"));
	private By input = By.xpath(getProperty("landingPage", "searchInput"));
	private By site = By.xpath(getProperty("landingPage", "espanolSite"));
	private By buy = By.xpath(getProperty("landingPage", "buyTab"));
	
	public WebElement windowsOption() {
		return driver.findElement(windows);
		
	}
	
	public WebElement searchIcon() {
		return driver.findElement(icon);
	}
	
	public WebElement searchInput() {
		return driver.findElement(input);
	}
	
	public WebElement espanolSite() {
		return driver.findElement(site);
	}
	
	public WebElement buyTab() {
		return driver.findElement(buy);
	}

}
