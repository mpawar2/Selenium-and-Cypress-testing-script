package selenium.maven.selenium.maven.demo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppTest 
{
	 static WebDriver driver;

	    @Before
	    public void setUp() {
	        // Set up the EdgeDriver
	    	System.setProperty("webdriver.edge.driver", "C:\\chromeDriver\\msedgedriver.exe");
	        driver = new EdgeDriver();
			driver.manage().window().maximize();
	        // Navigate to the website
	        driver.get("https://www.zalando.de/");
	    }
	       
	    @Test
	    public void test01SelectItem() {
	    	System.out.println("Starting test for selecting product...");
	    	//Element locator
	        By elementLocator = By.xpath("//h3[text()='BIGS - Across body bag - nero']"); 
	        selectElement(elementLocator);
	        // Find the span element (update the selector based on the actual HTML structure)
            WebElement spanElement = driver.findElement(By.xpath("//span[contains(text(), 'BIGS - Across body bag - nero')]"));
            // Get the text from the span element
            String actualText = spanElement.getText();
            // Verify if the span contains the expected text
            Assert.assertTrue(actualText.contains("BIGS - Across body bag - nero"));
            System.out.println("Product selection test passed successfully.");
	        driver.close();
	    }
	    
	    /*
	    @Test
	    public void test02AddToCart() {
	    	 
	    	//Element locator
	        By elementLocator = By.xpath("//h3[text()='BIGS - Across body bag - nero']"); // Replace with the target element's class name
	        selectElement(elementLocator);
	    
	        By addToBagLocator = By.xpath("//span[text()='Add to bag']");
			findElement(addToBagLocator);
			driver.close();
	    }
	    
		    @Test
		    public void test03ViewCart() {
		    	 
		    	By elementLocator = By.xpath("//h3[text()='BIGS - Across body bag - nero']"); // Replace with the target element's class name
			    selectElement(elementLocator);
			    
			    By addToBagLocator = By.xpath("//span[text()='Add to bag']");
				findElement(addToBagLocator);
		    	WebElement bagElement = driver.findElement(By.xpath("//a[@href='/cart/']"));
	
		    	bagElement.click();
		    	
		    	WebElement element = driver.findElement(By.cssSelector(".AGx8tI.wmyrNw.FxZV-M.HlZ_Tf"));
	
	            // Perform actions with the found element (e.g., click, get text)
	            System.out.println("Found Element Text: " + element.getText());
	            driver.close();
		    }
	    
	    @Test
	    public void test04NavigateToShoesSection() {
	    	 
	    	
	    	WebElement spanElement = driver.findElement(By.xpath("//span[contains(text(), 'Shoes')]"));
	        spanElement.click();
	        
	        WebElement shoeElement = driver.findElement(By.xpath("//span[contains(text(), 'Shoes')]"));    
	        String actualText = shoeElement.getText();
            // Verify if the span contains the expected text
            Assert.assertTrue(actualText.contains("Shoes"));
	        driver.close();
	    }
	    
	    @Test
	    public void test05verifySearchBarVisibilityAndAccessibility() {
	        // Find the search bar element by its ID, name, or other unique identifier
	        WebElement searchBar = driver.findElement(By.id("header-search-input"));  
	        // Verify the search bar is displayed (visible on the page)
	        Assert.assertTrue(searchBar.isDisplayed());
	        // Verify the search bar is enabled (accessible for user input)
	        Assert.assertTrue(searchBar.isEnabled());
	        driver.close();
	    }
	    
	    @Test
	    public void test06SearchBarSuggestionTest() {
	        // Find the search bar element by its ID, name, or other unique identifier
	        WebElement searchBar = driver.findElement(By.id("header-search-input"));  
	        searchBar.sendKeys("Shoes");

	        // Explicit wait to ensure suggestions appear after typing
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        List<WebElement> suggestions = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("header-search-option-0")) // Replace with actual class or element for suggestions
	        );

	        // Verify that suggestions are displayed
	        if (suggestions.size() > 0) {
	            System.out.println("Relevant product suggestions are displayed.");
	        } else {
	            System.out.println("No suggestions were displayed.");
	        }
	        driver.close();
	    }
	    
	    @Test
	    public void test07ProductDetailsVerificationTest() {
	    	
	        By elementLocator = By.xpath("//h3[text()='BIGS - Across body bag - nero']"); // Replace with the target element's class name
	        selectElement(elementLocator);
	        WebElement priceElement = driver.findElement(By.xpath("//span[contains(@class,'sDq_FX _4sa1cA dgII7d Km7l2y _65i7kZ')]"));

	        // Verify the element was found and output the text
	        if (priceElement != null) {
	            System.out.println("Element found with text: " + priceElement.getText());
	        } else {
	            System.out.println("Element with the given class and text was not found.");
	        }
	        driver.close();
	    } */
	    
	    public void selectElement(By elementLocator) {
	    	WebElement searchBox = driver.findElement(By.id("header-search-input"));
	        searchBox.click(); // Optional, as sendKeys will focus on the element
	        searchBox.sendKeys("bag valentino");
	        searchBox.sendKeys(Keys.ENTER);
	        
			findElement(elementLocator);
			
		}
	
	    public void findElement(By elementLocator) {
	    	// Scroll until the element is found
	        while (true) {
	            try {
	                // Attempt to find the element
	                WebElement element = driver.findElement(elementLocator);
	                if (element.isDisplayed()) {
	                    System.out.println("Element found!");
	                    element.click();
	                    break; // Exit the loop if found
	                }
	            } catch (Exception e) {
	                // If the element is not found, scroll down
	                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
	            }
	        }
			
		}

	private void assertequals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
}
