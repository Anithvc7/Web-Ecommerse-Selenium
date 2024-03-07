package WebAutomation.StepDefinitionImplementationCucumber;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import WebAutomation.BaseTest.BaseTest;
import WebAutomation.PageObjectModel.CartPage;
import WebAutomation.PageObjectModel.HomeProductScreen;
import WebAutomation.PageObjectModel.Loginpage;
import WebAutomation.PageObjectModel.Paymentscreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class StepDefinitionImplementationCucumber extends BaseTest{
	public Loginpage loginpage;
	
	public HomeProductScreen homeProductScreen;
	public CartPage cartPage;
	public Paymentscreen paymentscreen;
	
	
@Given("I landed on Ecommerse Page")
	
	public void I_landed_on_Ecommerse_Page() throws IOException
	{
		loginpage = launchApplication();
	}
	


@Given("^Login with username (.+) and password (.+)$")
    public void Login_with_username_and_password(String name , String password) throws InterruptedException
{
	homeProductScreen =loginpage.loginscreen(name,password);
	Thread.sleep(2000);
	
}


@When ("^When I add product (.+) to Cart$")
      public void Add_Product_to_Cart(String productneeded) throws InterruptedException
      {
	
	List<WebElement>productname=homeProductScreen.getProductList();
	CartPage cartPage= homeProductScreen.addProductToCart(productneeded);
	 homeProductScreen.printOut();
	 homeProductScreen.waitForElementTodissapear();
	 homeProductScreen.printOut();
	 homeProductScreen.selectCart();
   
    
     }
      

@And("^CheckOut (.+) and Submit the Order$")

public void Checkout_and_Submit_Order(String productneeded) throws InterruptedException
{
	Boolean match= cartPage.cardProducts(productneeded);  
    Assert.assertTrue(match);
   paymentscreen= cartPage.checkOut();
 
    
    String Countryinputgiven="India";
   
    paymentscreen.provideCountryInput(Countryinputgiven);
    paymentscreen.proceed();
}



  @Then("{string} message is displaying on Confirmation page" )
  		public void message_displaying_on_Confirmation_page(String string)
  		{
	  String status=  paymentscreen.orderdetails();
      Assert.assertEquals(status, "THANKYOU FOR THE ORDER.");
  		}
   
  @Then("{string} message is displayed")
  public void message_is_displayed(String string)
  {
	  Assert.assertEquals("Incorrect email or password.",loginpage.errorMessageHandles());
  }

}
