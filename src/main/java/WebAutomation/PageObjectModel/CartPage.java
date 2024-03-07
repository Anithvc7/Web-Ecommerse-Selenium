package WebAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webautomations.AbstractComponentsReusable.ReusableComponents;

public class CartPage extends ReusableComponents {

	 WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproduct;
	
	@FindBy(xpath="//li/button[@class='btn btn-primary']")
	WebElement checkout;
	
	public Boolean cardProducts(String productneeded ) 
	
	{
		List <WebElement> cartproducts= cartproduct;

		Boolean match =cartproduct.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productneeded));
		return match;
		     
	}
	
	public Paymentscreen checkOut()
	{
		checkout.click();
		 Paymentscreen paymentscreen = new Paymentscreen(driver);
		 return paymentscreen;
	}
	
}


     
   //  driver.findElement(By.xpath("//li/button[@class='btn btn-primary']")).click();