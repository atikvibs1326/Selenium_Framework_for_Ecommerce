package Bravo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	//WebElement userEmail =	driver.findElement(By.id("userEmail"));
	
	//Above step but using the PageFactory annotaion
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public ProductCatlogue LoginApplication(String email,String passwd) {
		userEmail.sendKeys(email);
		Password.sendKeys(passwd);
		loginButton.click();
		ProductCatlogue productcatlogue = new ProductCatlogue(driver);
		return productcatlogue;
	}
}
	