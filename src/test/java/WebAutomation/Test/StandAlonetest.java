package WebAutomation.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.BaseTest.BaseTest;
import WebAutomation.PageObjectModel.CartPage;
import WebAutomation.PageObjectModel.HomeProductScreen;
import WebAutomation.PageObjectModel.Loginpage;
import WebAutomation.PageObjectModel.OrderDetailsScreen;
import WebAutomation.PageObjectModel.Paymentscreen;

public class StandAlonetest extends BaseTest {
	
	String email ="anithvc@gmail.com";
  	String password ="I143you@";
  	String productneeded ="ZARA COAT 3";
	//public static void main(String[] args) throws InterruptedException, IOException {

	@Test(dataProvider="getData")
	public void submitOrder(String email,String password, String productneeded) throws InterruptedException, IOException
	{
		
		
  	Loginpage loginpage = new Loginpage(driver);
		HomeProductScreen homeProductScreen =loginpage.loginscreen(email,password);
		
		List<WebElement>productname=homeProductScreen.getProductList();
		CartPage cartPage= homeProductScreen.addProductToCart(productneeded);
		 homeProductScreen.printOut();
		 homeProductScreen.waitForElementTodissapear();
		 homeProductScreen.printOut();
		 homeProductScreen.selectCart();
       
       Boolean match= cartPage.cardProducts(productneeded);  
       Assert.assertTrue(match);
       Paymentscreen paymentscreen= cartPage.checkOut();
    
       
       String Countryinputgiven="India";
      
       paymentscreen.provideCountryInput(Countryinputgiven);
       paymentscreen.proceed();
      String status=  paymentscreen.orderdetails();
       Assert.assertEquals(status, "THANKYOU FOR THE ORDER.");
      
     
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	
	public void orderHistoryTest()
	{
		Loginpage loginpage = new Loginpage(driver);
		HomeProductScreen homeProductScreen =loginpage.loginscreen(email,password);
		OrderDetailsScreen orderDetailsScreen=homeProductScreen.orderButton();
		Assert.assertTrue(orderDetailsScreen.ordersBookedDetails(productneeded));
		
	
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		return new Object [][] {{"anithvc@gmail.com","I143you@","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}
	};
	}

}
