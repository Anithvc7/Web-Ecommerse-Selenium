package WebAutomation.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

public class HashMapStandAlonetest extends BaseTest {
	
	String email ="anithvc@gmail.com";
  	String password ="I143you@";
  	String productneeded ="ZARA COAT 3";
	//public static void main(String[] args) throws InterruptedException, IOException {

	@Test(dataProvider="getData")
	public void submitOrder(HashMap <String,String> input) throws InterruptedException, IOException
	//(HashMap <Object,Object> input) -- changing to string 
	{
		
		
  	Loginpage loginpage = new Loginpage(driver);
		HomeProductScreen homeProductScreen =loginpage.loginscreen(input.get(email),input.get(password));
		
		List<WebElement>productname=homeProductScreen.getProductList();
		CartPage cartPage= homeProductScreen.addProductToCart(input.get(productneeded));
		 homeProductScreen.printOut();
		 homeProductScreen.waitForElementTodissapear();
		 homeProductScreen.printOut();
		 homeProductScreen.selectCart();
       
       Boolean match= cartPage.cardProducts(input.get(productneeded));  
       Assert.assertTrue(match);
       Paymentscreen paymentscreen= cartPage.checkOut();
    
       
       String Countryinputgiven="India";
      
       paymentscreen.provideCountryInput(Countryinputgiven);
       paymentscreen.proceed();
      String status=  paymentscreen.orderdetails();
       AssertJUnit.assertEquals(status, "THANKYOU FOR THE ORDER.");
      
     
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		HashMap<String ,String> map = new HashMap<String ,String>();
		map.put(email, "anithvc@gmail.com");
		map.put(password, "I143you@");
		map.put(productneeded, "ZARA COAT 3");
		
		HashMap<String ,String> map1 = new HashMap<String ,String>();
		map1.put(email, "shetty@gmail.com");
		map1.put(password, "Iamking@000");
		map1.put(productneeded, "ADIDAS ORIGINAL");
		
	
		return new Object [][] {{map},{map1}};
	}

}
