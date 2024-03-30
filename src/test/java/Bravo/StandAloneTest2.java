package Bravo;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2  {
	public static void main(String args[]) throws InterruptedException {

		String prodName = "I PHONE";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/client");
		LandingPage landing = new LandingPage(driver);
		landing.goTo("https://rahulshettyacademy.com/client");
		ProductCatlogue productcatlogue = landing.LoginApplication("atik@gmail.com", "Berman_502");
		List<WebElement> products = productcatlogue.getProductList();
		productcatlogue.addProductToCart(prodName);
		CartPage cartPage = productcatlogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(prodName);
		Assert.assertTrue(match);
		CheckOut checkOutPage  = cartPage.goToCheckoutPage();
		checkOutPage.SelectCountry("india");
	    checkOutPage.SubmitOrder();
	    ConfirmationPage confirmPage = new ConfirmationPage(driver);
		String confirmMessage = confirmPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
