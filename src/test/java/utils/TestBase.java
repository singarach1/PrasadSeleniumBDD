package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
//		String browser = prop.getProperty("browser");
		String url = prop.getProperty("QAUrl");

		if (driver == null) {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome"))  {
//				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver");
				driver = new ChromeDriver();
			}
//			
			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				// firefox code
			}

			driver.get(url);
		}
		return driver;
	}

}
