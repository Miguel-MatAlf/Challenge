package baseClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver = null;
	
	public static WebDriver initializeDriver() {
        
		String browser = getProperty("configuration", "browser");
        
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			//firefox driver
			driver = new FirefoxDriver();
		} else if(browser.equals("ie")) {
			//ie driver
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public static String getProperty(String section, String sub) {
		
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\baseClasses\\data.json";
        JSONParser jsonParser = new JSONParser();
        FileReader jsonFile = null;
		try {
			jsonFile = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject data = null;
		try {
			data = (JSONObject) jsonParser.parse(jsonFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject configuration = (JSONObject) data.get(section);
        return (String) configuration.get(sub);
		
	}

}
