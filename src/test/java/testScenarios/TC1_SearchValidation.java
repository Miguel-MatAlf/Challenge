package testScenarios;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AppPage;
import pageObjects.CarPage;
import pageObjects.LandingPage;
import pageObjects.WindowsPage;

public class TC1_SearchValidation extends BaseClass{
	
	@BeforeMethod
	public void goToURL() throws InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		String URL = getProperty("configuration", "url");
//		1. Go to https://www.microsoft.com/es-mx/
		driver.get(URL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void tearDown() { 
		driver.quit(); 
	}
	
	@Test
	public void searchValidation() throws InterruptedException {
		LandingPage LP = new LandingPage(driver);
		WindowsPage WP = new WindowsPage(driver);
		AppPage AP = new AppPage(driver);
		CarPage CP = new CarPage(driver);
				
//		2. Go to Windows
		LP.windowsOption().click();
		
//		3. Go to Search
		LP.searchIcon().click();
		
//		4. Search for “Xbox” and click on "Comprar"
		LP.searchInput().sendKeys("xbox");
		LP.searchIcon().click();
		LP.buyTab().click();
		
//		5. Once in the result page you will see "Aplicaciones" click on it
		WP.appsSection().click();
		
//		6. Count the elements on the first 3 pages and print the sum of elements and all the titles
		int elementsCount = 0;
		elementsCount = WP.appsTitleList().size();
		for (int index = 1; index <= elementsCount; index++) {
			System.out.println(WP.getTitle(index));
		}
		
		WP.goToPageNumber(2).click();
		elementsCount = elementsCount + WP.appsTitleList().size();
		for (int index = 1; index <= WP.appsTitleList().size(); index++) {
			System.out.println(WP.getTitle(index));
		}
		
		WP.goToPageNumber(3).click();
		elementsCount = elementsCount + WP.appsTitleList().size();
		for (int index = 1; index <= WP.appsTitleList().size(); index++) {
			System.out.println(WP.getTitle(index));
		}
		
		System.out.println("NUMBER OF ELEMENTS: " + elementsCount);
		
		
//		7. Go back to the first page and select the first NON-FREE option and STORE the price for later comparison
		WP.goToPageNumber(1).click();
		int nonF = 0;
		String priceList = "";
		for (int in = 1; in <= WP.appsPriceList().size(); in++) {
			priceList = WP.getAppPrice(in);
			if(priceList.contains("Gratis")) {
				//go to next iteration
			} else {
				nonF = in;
				break;
			}
		}
		
		WP.selectCard(nonF).click();
		
//		8. If you see a "Registration" pop up, close it
		AP.closeRegistration().click();
		
//		9. In this page, you will see the price again, compare first price vs current prince and they should match
		String currentPrice = AP.appPrice().getText();
		String[] list = priceList.split("\\$");
		String[] current = currentPrice.split("\\$");
		
		Assert.assertEquals(current[1], list[1]);
		
//		10. Click on the "3 dot" button next to "Comprar" button and add the item to the CART
		AP.threeDotButton().click();
		AP.addToCar().click();
		
//		11. Verify the app takes you to the Shopping Cart page and verify you have one element available
		Assert.assertEquals(CP.carItems().size(), 1);
		
		Assert.assertEquals(CP.carHeader().getText(), "Carro");
		
//		12. Delete the item and verify you have 0 elements: "Tu carro está vacío" message should be present
		CP.deleteItem().click();
		
		Assert.assertEquals(CP.carItems().size(), 0);
		
		Assert.assertEquals(CP.emptyCarText().getText(), "Tu carro está vacío.");
		
	}

}
