package WebAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webautomations.AbstractComponentsReusable.ReusableComponents;

public class OrderDetailsScreen extends ReusableComponents {

	 WebDriver driver;
	public OrderDetailsScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProductslist;
	
	
	
	public Boolean ordersBookedDetails(String productneeded)
	{
		
		List <WebElement> orderProductslists= orderProductslist;

		Boolean match =orderProductslist.stream().anyMatch(orderProductslist->orderProductslist.getText().equalsIgnoreCase(productneeded));
		return match;
	}
	
	
	
}


     
  