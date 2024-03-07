package WebAutomation.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webautomations.AbstractComponentsReusable.ReusableComponents;

public class Paymentscreen extends ReusableComponents {
	
	WebDriver driver;
	
	public Paymentscreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryInput;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[2]")
	WebElement countryselect;
	
	@FindBy(css=".action__submit")
	WebElement submitclick;
	
	@FindBy(css="h1.hero-primary")
	WebElement orderdetailspage;
	
	By searchresult =By.cssSelector(".ta-results");
	
	public By provideCountryInput(String Countryinputgiven)
	{
		
		Actions a = new Actions(driver);
		a.sendKeys(countryInput,Countryinputgiven).build().perform();
		waitForElementToAppear(searchresult);
		return searchresult;
		
		
	}
public void proceed() throws InterruptedException 
{
	
	countryselect.click();
	submitclick.click();
	Thread.sleep(1000);
	
	
}
	public String orderdetails()
	{
		return orderdetailspage.getText();
		
		
	}
} 
