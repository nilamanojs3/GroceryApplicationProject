package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static int explicitwait=5;
	 public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.elementToBeClickable(element));
}
	 public void waitUntilAlertToBePresent(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.alertIsPresent());
}
	 public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.elementToBeSelected(element));
}
	 public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.visibilityOf(element));
}
	 public void waitUntilElementToBeInvisible(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.invisibilityOf(element));
}
	 public void waitUntilTitleIsLocated(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.titleIs("Admin Users"));
}
	 public void waitUntilTextIsLocated(WebDriver driver, WebElement element) { 
		  
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); 
	 		
	 		wait.until(ExpectedConditions.textToBePresentInElementValue(element, "News"));
}
}
