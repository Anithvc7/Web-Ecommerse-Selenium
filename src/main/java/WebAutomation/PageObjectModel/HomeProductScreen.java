package WebAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import webautomations.AbstractComponentsReusable.ReusableComponents;

public class HomeProductScreen extends ReusableComponents {
	WebDriver driver;
public HomeProductScreen(WebDriver driver) 
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
	
@FindBy(css=".mb-3")
List<WebElement> productname;

@FindBy(css="#toast-container")
WebElement systemPrint;
	
By productBy =By.cssSelector(".mb-3");
By addTocart=By.cssSelector(".btn.w-10.rounded");
By toastMessage =By.cssSelector("#toast-container");

public List<WebElement> getProductList() {
	
	waitForElementToAppear(productBy);
	return productname;
}

public WebElement getProductByName(String productneeded)
{
	
	WebElement prod= getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productneeded)).findFirst().orElse(null);
	return prod;
}


public CartPage addProductToCart(String productneeded)
{
	WebElement prod =getProductByName(productneeded);
	prod.findElement(addTocart).click();
	waitForElementToAppear(toastMessage);
	CartPage cartPage =new CartPage(driver); 
	return cartPage;
	
	
}
public void printOut()
{
	  String popup1 =systemPrint.getText();
      System.out.println(popup1);
      
}


}
//
//