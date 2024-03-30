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

public class StandAloneTest {
	public static void main(String args[]) {

		String prodName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("atik@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Berman_502");
		driver.findElement(By.id("login")).click();
		LandingPage landing = new LandingPage(driver);

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

// Using for loop		
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod = null;
//
//		for (WebElement product : products) {
//		    if (product.findElement(By.cssSelector(".b")).getText().equals()) {
//		        prod = product;
//		        break; // Exit the loop once a matching product is found
//		    }
//		}

		// Now 'prod' contains the desired WebElement, or it's null if not found

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//popup name = toast-container
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//loading name = ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cart = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		
		Boolean match = cart.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(prodName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//*[@class='input txt']")).sendKeys("123");
		driver.findElement(By.xpath("(//*[@class='input txt']) [2]")).sendKeys("Mylove Bravo Khochikar");
		
		driver.findElement(By.xpath("//*[@name='coupon']")).sendKeys("rahulshettyacademy");
		
		//Auto-suggest Dropdown
		//driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
		//wait.until(ExpectedConditions.visibilityOfElementLocated("")) 
		//rahulshettyacademy
		
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		// regex xpath (//button[contains(@class,'ta-item')])[2]
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
