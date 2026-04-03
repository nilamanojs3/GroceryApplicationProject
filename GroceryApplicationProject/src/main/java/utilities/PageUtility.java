package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	 public void selectDropdownWithValue(WebElement element, String value) { 
		  
	 		Select object = new Select(element); 
	 		object.selectByValue(value); 
	  
	 	}
	 public void selectDropdownWithText(WebElement element, String text) { 
		  
	 		Select object = new Select(element); 
	 		object.selectByVisibleText(text); 
	  
	 	}
	 public void selectDropdownWithIndex(WebElement element, int index) { 
		  
	 		Select object = new Select(element); 
	 		object.selectByIndex(index); 
	  
	 	}
	 public void selectRadioButton(WebElement element) {
		    if (!element.isSelected()) {
		        element.click();
		    }
		}
	 public void selectCheckbox(WebElement element) {
		    if (!element.isSelected()) {
		        element.click();
		    }
		}

		public void deselectCheckbox(WebElement element) {
		    if (element.isSelected()) {
		        element.click();
		    }
		}
		public void mouseHover(WebDriver driver, WebElement element) {
		    Actions action = new Actions(driver);
		    action.moveToElement(element).perform();
		}
		public void pressEnter(WebElement element) {
		    element.sendKeys(Keys.ENTER);
		}
		
}
