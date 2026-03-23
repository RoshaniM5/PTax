package com.mpro.ptax.base;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mpro.ptax.driver.DriverManager;

public class BasePage {

	protected final Logger logger = LogManager.getLogger(this.getClass());
   
	protected static WebDriver driver; 
	protected WebDriverWait wait;
	
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
	                .executeScript("window.scrollBy(0,1500)");
	    }

	    public void scrollUp() {
	        ((JavascriptExecutor) getDriver())
	                .executeScript("window.scrollBy(5000)");
	    }
	    
	    public void scrollToElementInsideModal(By locator) {
	        WebElement element = driver.findElement(locator);

	        ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    }

	    /* ---------------- Loader ---------------- */
	    
	    public void waitForLoaderToDisappear() {
	    	By loader = By.xpath("//div[contains(@class,'waiting-box')]");
	        try {
	            getWait().until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        } catch (Exception e) {
	            System.out.println("Loader not visible or already disappeared.");
	        }
	    }
	    
	    public void waitForVisibility(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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
	    	 try {
	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	        wait.until(ExpectedConditions.alertIsPresent());
	    	        driver.switchTo().alert().accept();
	    	    } catch (TimeoutException e) {
	    	        logger.info("No alert present.");
	    	    }
	    }

	    
	    public String getAlertTextAndAccept() {


	        //Try JS Alert
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            String text = alert.getText();
	            alert.accept();
	            logger.info("Captured JS Alert: " + text);
	            return text.trim();
	        } catch (Exception e) {
	            logger.info("No JS alert found. Checking DOM popup...");
	        }

	        //Try DOM Popup
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement successMsg = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//*[contains(text(),'Successfully')]")
	                    )
	            );

	            String text = successMsg.getText();
	            logger.info("Captured DOM message: " + text);
	            return text.trim();

	        } catch (Exception e) {
	            logger.info("No success message found in DOM.");
	        }

	        return "";
	    }
	    
	    public void handleAlertIfPresent() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            
	            System.out.println("Alert found: " + alert.getText());
	            alert.accept(); // or alert.dismiss()

	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }
	    }
	    /* ---------------- CLICK METHODS ---------------- */

	    public void click(By locator) {
	    	waitForLoaderToDisappear();
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

	    public void click1(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", element);

	        try {
	            element.click();
	        } catch (ElementClickInterceptedException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
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

	    	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

	        By viewBtnLocator = By.xpath("(//table//button[normalize-space()='View'])[last()]");
	        
	    	List<WebElement> viewButtons = wait.until(
	    	        ExpectedConditions.numberOfElementsToBeMoreThan(viewBtnLocator, 0));

	    	    logger.info("Total View buttons found: " + viewButtons.size());

	    	    // click LAST record
	    	    viewButtons.get(viewButtons.size() - 1).click();
	    }

	    /* ---------------- DROPDOWN ---------------- */
	    
	    public void selectFromDropdown(By locator, String value) {

	        WebDriverWait wait = getWait();

	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	        for (int i = 0; i < 3; i++) {
	            try {
	                WebElement element = wait.until(
	                        ExpectedConditions.elementToBeClickable(locator));

	                Select select = new Select(element);
	                select.selectByVisibleText(value.trim());
	                break;

	            } catch (StaleElementReferenceException e) {
	                if (i == 2) throw e; // rethrow after retry
	            }
	        }
	    }

	    public void waitForDropdownToPopulate(By locator) {

	        WebDriverWait wait = getWait();

	        wait.until(driver -> {
	            WebElement element = driver.findElement(locator);
	            Select select = new Select(element);
	            return select.getOptions().size() > 1;
	        });
	    }
//	    public void selectFromDropdown(By dropdown, String value) {
//	    	 WebElement element = 
//	    		getWait().until(ExpectedConditions.elementToBeClickable(dropdown));
//	    	    getWait().until(ExpectedConditions.visibilityOfElementLocated(dropdown));
//
////	    	    getWait().until(d -> new Select(element).getOptions().size() > 1);
//
//	    	    Select select = new Select(element);
//	    	   
//	    	    for (WebElement option : select.getOptions()) {
//	    	       
//	    	    }
//	    	    
//	    	    
//	    	    try {
//	    	        // First try exact visible text
//	    	        select.selectByVisibleText(value.trim());
//	    	    } catch (StaleElementReferenceException  e) {
//	    	        // If fails, try selecting by value (for numeric cases)
//	    	        select.selectByValue(value.trim());
//	    	    }
//	    }
	    
	    /* ---------------- INPUTTEXT ---------------- */
	    public void Input(By locator, String value) { 
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
	    
	    /* ---------------- WaitForNumberofWindows ---------------- */
	    public void waitForNumberOfWindows(int expectedWindows) {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(driver -> driver.getWindowHandles().size() >= expectedWindows);
	    }
	    
	    /* ---------------- CLICKWHENVISIBLE ---------------- */
	    public void clickWhenVisible(By locator) { 
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
	    	wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); 
	    }
	    
	    /* ---------------- WINDOWHANDLES ---------------- */
	    
	    public void handleReportandReturn() throws InterruptedException {
	    	 // Store parent window
	        String parent = driver.getWindowHandle();
	        
	        
	        // Get all windows
	        for (String window : driver.getWindowHandles()) {

	            // Switch to child window
	            if (!window.equals(parent)) {
	                driver.switchTo().window(window);
	                Thread.sleep(2000);	        // Wait 3 seconds to see report (optional)
	                driver.close();				
	    	        // Close report tab
	            }
	        }
	        // Switch back to parent
	        driver.switchTo().window(parent);
	    }
	    	
	
	    public String getAlertMessage() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        String message = alert.getText();
	        alert.accept();

	        return message;
	    }
}