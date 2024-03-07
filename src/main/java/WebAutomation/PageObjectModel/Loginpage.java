package WebAutomation.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webautomations.AbstractComponentsReusable.ReusableComponents;

public class Loginpage extends ReusableComponents{
	
	WebDriver driver;
	String email ="anithvc@gmail.com";
	String password ="I143you@";
	
	
	//first we need to create a constructor --
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public HomeProductScreen loginscreen(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		HomeProductScreen homeProductScreen = new HomeProductScreen(driver);
		return homeProductScreen;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	public String errorMessageHandles() 
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}
}


