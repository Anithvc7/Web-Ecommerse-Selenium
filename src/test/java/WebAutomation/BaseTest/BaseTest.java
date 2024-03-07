package WebAutomation.BaseTest;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import WebAutomation.PageObjectModel.Loginpage;

public class BaseTest {
	
	public WebDriver driver;
	public Loginpage loginpage;
	
	
	
	public WebDriver initalizeDriver() throws IOException
	{
		
		//properties class -- 
		
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + "/src/main/java/WebAutomation/resourses/GlobalDatas.properties");
		
		//hear its expecting input stream -- so we need to create a object for FileInputStream
		prop.load(fis);
		
	//	String BrowserName=prop.getProperty("browser"); -- We changed this to bellow one as we need to change the  browser from maven terminal
		
		String BrowserName=System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
	     	
		
		if(BrowserName.contains("Chrome"))
			
		{
			ChromeOptions options = new ChromeOptions();
			 
			 if(BrowserName.contains("headless"))
			 {
				 options.addArguments("headless");
			 }
			 driver = new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1400,900));// for fullscreen
		}
		
		else if (BrowserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
			
			//for firefox code
		}
		
		else if (BrowserName.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();
		}
		
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
	
	String jsonContent =	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	
	ObjectMapper mapper = new ObjectMapper();
List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
 return data;
			
	
	
	
	
	
	}
	
	
	
	
	public String takeScreenShot(String testCaseName , WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//Report//" + testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//Report//" + testCaseName +".png";
		
	}

	@BeforeMethod
	public Loginpage launchApplication() throws IOException
	{
		driver=initalizeDriver();
		Loginpage loginpage=new Loginpage(driver);
		loginpage.goTo();
		return loginpage;
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
