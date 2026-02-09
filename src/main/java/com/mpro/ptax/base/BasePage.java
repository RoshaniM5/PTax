package com.mpro.ptax.base;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pro.ptax.driver.DriverManager;

public class BasePage {

	protected final Logger logger = LogManager.getLogger(this.getClass());
   
	protected WebDriver driver; protected WebDriverWait wait;
	
	 public BasePage() {
	        this.driver = DriverManager.getDriver();
	        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    // Always use this instead of DriverManager directly
	    protected  WebDriver getDriver() {
	        return DriverManager.getDriver();
	    }

	    protected  WebDriverWait getWait() {
	        return new WebDriverWait(getDriver(), Duration.ofSeconds(15));
	    }

	    /* ---------------- SCROLL ---------------- */

	    public void scrollDown() {
	        ((JavascriptExecutor) getDriver())
	                .executeScript("window.scrollBy(0,2000)");
	    }

	    public void scrollUp() {
	        ((JavascriptExecutor) getDriver())
	                .executeScript("window.scrollBy(0,-500)");
	    }

	    /* ---------------- ZOOM ---------------- */

	    public void zoomOut(int percentage) {
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        js.executeScript("document.body.style.zoom='" + percentage + "%'");
	    }

	    public void zoomIn(int percentage) {
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        js.executeScript("document.body.style.zoom='" + percentage + "%'");
	    }

	    /* ---------------- ALERT ---------------- */

	    public void acceptAlert() {
	        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
	        alert.accept();
	    }

	    /* ---------------- CLICK METHODS ---------------- */

	    public void click(By locator) {
	        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }

	    public void jsClick(By locator) {
	        WebElement element = getWait()
	                .until(ExpectedConditions.presenceOfElementLocated(locator));
	        ((JavascriptExecutor) getDriver())
	                .executeScript("arguments[0].click();", element);
	    }

	    public void safeClick(By locator) {
	        try {
	            getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	        } catch (Exception e) {
	            logger.warn("Element not clickable: {}", locator);
	        }
	    }

	    /* ---------------- INPUT ---------------- */

	    protected void input(By locator, String value) {
	        WebElement element = getWait()
	                .until(ExpectedConditions.elementToBeClickable(locator));
	        element.clear();
	        element.sendKeys(value);
	    }

	    protected String getText(By locator) {
	        return getWait()
	                .until(ExpectedConditions.visibilityOfElementLocated(locator))
	                .getText();
	    }

	    protected boolean isDisplayed(By locator) {
	        try {
	            return getDriver().findElement(locator).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    /* ---------------- PAGE LOAD ---------------- */

	    protected void waitForPageLoad() {
	        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(
	            wd -> ((JavascriptExecutor) wd)
	                    .executeScript("return document.readyState")
	                    .equals("complete")
	        );
	    }

	    /* ---------------- ACTIONS ---------------- */

	    public void closePopupUsingESC() {
	        new Actions(getDriver())
	                .sendKeys(Keys.ESCAPE)
	                .perform();
	    }

	    /* ---------------- TABLE: AUTO-INCREMENT RECORD ---------------- */

	    public void selectLatestInward() {

	    	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	        By viewBtnLocator = By.xpath("//table//button[normalize-space()='View']");
	        
	    	List<WebElement> viewButtons = wait.until(
	    	        ExpectedConditions.numberOfElementsToBeMoreThan(viewBtnLocator, 0)
	    	    );

	    	    logger.info("Total View buttons found: " + viewButtons.size());

	    	    // click LAST record
	    	    viewButtons.get(viewButtons.size() - 1).click();
	    }

	    /* ---------------- DROPDOWN ---------------- */

	    protected void selectFromDropdown(By dropdown, String visibleText) {
	        WebElement dd = getWait()
	                .until(ExpectedConditions.elementToBeClickable(dropdown));
	        new Select(dd).selectByVisibleText(visibleText);
	    }
	    
	    /* ---------------- INPUTTEXT ---------------- */
	    protected void Input(By locator, String value) { 
	    	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
	    
	    	       wait.until(ExpectedConditions.elementToBeClickable(locator)); 
	               element.clear(); 
	               element.sendKeys(value); 
	    }
	    
	    /* ---------------- UPLOAD FILE ---------------- */
	    protected void uploadFile(By fileInput, String filepath)
	    { 
	    	Input(fileInput, filepath); 
	    }
	    
	    /* ---------------- CLICKWHENVISIBLE ---------------- */
	    public void clickWhenVisible(By locator) { 
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
	    	wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); 
	    	}
	}
