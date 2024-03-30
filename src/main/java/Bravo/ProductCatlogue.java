package Bravo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableComponent.AbstractComponent;

public class ProductCatlogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatlogue(WebDriver driver) {
		//intialization code
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products ; 
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css=".ng-animating")
	WebElement spinner; 
	
	By prod = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(prod);
		return products;
	}
	
	public WebElement getProductName(String prodName) {
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void addProductToCart(String prodName) throws InterruptedException {
		WebElement prod = getProductName( prodName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitforElementToDisappear(spinner);
	}
	

	

}
	