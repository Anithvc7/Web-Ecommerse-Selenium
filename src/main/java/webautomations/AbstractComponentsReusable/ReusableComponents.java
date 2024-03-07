package webautomations.AbstractComponentsReusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebAutomation.PageObjectModel.OrderDetailsScreen;

public class ReusableComponents {
	
	WebDriver driver;
	public ReusableComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartSelect;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	
	
	public void waitForElementToAppear(By FindBy)
	{
		 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForElementTodissapear() throws InterruptedException
	
	{
		Thread.sleep(2000);
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
//		 wait.until(ExpectedConditions.invisibilityOf(animation));
	}
	
	public void waitForWebElementToAppear(WebElement FindBy)
	{
		 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void selectCart()
	{
		cartSelect.click();
	}
	
	public OrderDetailsScreen orderButton()
	{
		orders.click();
		OrderDetailsScreen orderDetailsScreen = new OrderDetailsScreen(driver);
		return orderDetailsScreen;
		
		
	}
	
	
	

}
