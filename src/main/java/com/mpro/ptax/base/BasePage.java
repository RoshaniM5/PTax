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
   
	protected  static WebDriver driver; 
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
	                .executeScript("window.scrollBy(0,5000)");
	    }

	    public void scrollUp() {
	        ((JavascriptExecutor) getDriver())
	                .executeScript("window.scrollBy(7000)");
	    }
	    
	    public void scrollToElementInsideModal(By locator) {
	        WebElement element = driver.findElement(locator);
	      
	        ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    }

	    public void focusAndScroll(By locator) {

	        WebDriver driver = getDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement element = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(locator)
	        );

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // 1️⃣ Scroll main window a bit (outer scrollbar)
	        js.executeScript("window.scrollBy(0, 300);");

	        // 2️⃣ Scroll modal container
	        WebElement modal = driver.findElement(By.cssSelector(".modal-cont.collection"));
	        js.executeScript(
	                "arguments[0].scrollTop = arguments[1].offsetTop - 200;",
	                modal, element
	        );

	        // 3️⃣ Scroll inner box-body if present (VERY IMPORTANT in your DOM)
	        try {
	            WebElement inner = driver.findElement(By.cssSelector(".modal-cont.collection .box-body"));
	            js.executeScript(
	                    "arguments[0].scrollTop = arguments[1].offsetTop - 200;",
	                    inner, element
	            );
	        } catch (Exception e) {
	            // ignore if not scrollable
	        }

	        // 4️⃣ Final alignment (safety)
	        js.executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                element
	        );
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

	        WebDriverWait getwait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        getwait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	    }
	    /* ---------------- ZOOM ---------------- */

	    public void zoomOut(int percentage) {
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        js.executeScript("document.body.style.zoom='" + percentage + "%'");
	    }
	    
	    
	    public void waitForPageStable() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(d -> ((JavascriptExecutor) d)
	                .executeScript("return document.readyState").equals("complete"));
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
	    
	    public void clickWithScrollAndRetry(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        // Scroll to center (very important)
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block: 'center'});", element);

	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        try {
	            element.click();
	        } catch (ElementClickInterceptedException e) {

	            System.out.println("⚠ Intercepted, using JS click");

	            ((JavascriptExecutor) driver)
	                    .executeScript("arguments[0].click();", element);
	        }
	    }

	    public String getAttribute(By locator, String attributeName) {
	        return getWait()
	                .until(ExpectedConditions.visibilityOfElementLocated(locator))
	                .getAttribute(attributeName);
	    }
	    
	    public String getAlertTextAndAccept() {


	        //Try JS Alert
	        try {
	            WebDriverWait getwait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            Alert alert = getwait.until(ExpectedConditions.alertIsPresent());
	            String text = alert.getText();
	            alert.accept();
	            logger.info("Captured JS Alert: " + text);
	            return text.trim();
	        } catch (Exception e) {
	            logger.info("No JS alert found. Checking DOM popup...");
	        }

	        //Try DOM Popup
	        try {
	            WebDriverWait getwait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement successMsg = getwait.until(
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
	            WebDriverWait getwait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            Alert alert = getwait.until(ExpectedConditions.alertIsPresent());
	            
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

	    public void clickTo(By locator) {
	        waitForLoaderToDisappear();
	        getWait().until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector("section.modal")
	        ));

	        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }
	    
	    public void jsClick1(WebElement element) {

	        WebElement clickableElement = getWait()
	                .until(ExpectedConditions.elementToBeClickable(element));

	        ((JavascriptExecutor) getDriver())
	                .executeScript("arguments[0].click();", clickableElement);
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

	        WebDriverWait getwait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement element = getwait.until(ExpectedConditions.elementToBeClickable(locator));

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
	        handleModal();

	        waitForLoaderToDisappear();

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
	    
	    public void waitModalToDisappear() {
	    
	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    	        By.xpath("//section[contains(@class,'modal')]")
	    	    ));
	    	}
	    
	    public void selectLatestInwardO() {
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));

	    By locator = By.xpath("(//table//button[normalize-space()='View'])[last()]");

	    for (int i = 0; i < 4; i++) {
	        try {
	            // Re-locate fresh element every time
	            WebElement element = wait.until(ExpectedConditions.refreshed(
	                    ExpectedConditions.elementToBeClickable(locator)
	            ));

	            // Scroll into view (important for tables)
	            ((JavascriptExecutor) getDriver()).executeScript(
	                    "arguments[0].scrollIntoView({block:'center'});", element);

	            // JS click (avoids overlay + stale timing issues)
	            ((JavascriptExecutor) getDriver()).executeScript(
	                    "arguments[0].click();", element);

	            System.out.println("Clicked latest View button");

	            return;

	        } catch (StaleElementReferenceException e) {
	            System.out.println("Retry due to stale... attempt: " + i);
	        }
	    }

	    throw new RuntimeException("Failed to click latest View button after retries");
	}
	    
//	    public void selectLatestInwardO() {
//
//	    	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
//
//	        By viewBtnLocator = By.xpath("(//table//button[normalize-space()='View'])[last()]");
//	        
//	        waitModalToDisappear();
//	        
//	    	List<WebElement> viewButtons = wait.until(
//	    	        ExpectedConditions.numberOfElementsToBeMoreThan(viewBtnLocator, 0));
//
//	    	    logger.info("Total View buttons found: " + viewButtons.size());
//
//	    	    // click LAST record
//	    	    viewButtons.get(viewButtons.size() - 1).click();
//	    	    WebElement viewBtn = wait.until(ExpectedConditions.elementToBeClickable(viewBtnLocator));
//
//	    	    viewBtn.click();
//	    }
	    
	    public void closeModalIfPresent() {
	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

	        List<WebElement> modals = getDriver().findElements(
	            By.xpath("//section[contains(@class,'modal') and contains(@class,'ng-scope')]"));

	        if (!modals.isEmpty() && modals.get(0).isDisplayed()) {
	            try {
	                WebElement closeBtn = getDriver().findElement(
	                    By.xpath("//button[contains(@class,'close') or contains(text(),'×')]"));
	                closeBtn.click();

	                wait.until(ExpectedConditions.invisibilityOf(modals.get(0)));
	            } catch (Exception e) {
	                System.out.println("⚠ Unable to close modal, trying JS remove");
	                ((JavascriptExecutor) getDriver()).executeScript(
	                    "document.querySelectorAll('.modal').forEach(e => e.remove());");
	            }
	        }
	    }
	    public void waitUntilClickable(By locator) {

	        WebDriverWait wait =
	                new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	        wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    
	    public void waitForPageToLoad() {

	        WebDriverWait wait =
	                new WebDriverWait(getDriver(), Duration.ofSeconds(30));

	        wait.until(webDriver ->
	                ((JavascriptExecutor) webDriver)
	                        .executeScript("return document.readyState")
	                        .equals("complete"));
	    }
	    
	    public boolean selectLatestInward() {

	    	 By viewBtn = By.xpath("(//table//button[normalize-space()='View'])[last()]");

	    	    handleModal();

	    	    try {

	    	        // Wait small duration for table load
	    	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	    	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	    	                By.xpath("//table//button[normalize-space()='View']")));

	    	        List<WebElement> buttons = getDriver().findElements(viewBtn);

	    	        if (buttons.isEmpty()) {

	    	            System.out.println("View button not present, skipping...");
	    	            return false;
	    	        }

	    	        stableClick(viewBtn);

	    	        System.out.println("Clicked latest View button");

	    	        // Wait for modal/form to open
	    	        wait.until(ExpectedConditions.or(

	    	                ExpectedConditions.visibilityOfElementLocated(
	    	                        By.xpath("//*[contains(@class,'modal') and contains(@class,'show')]")),

	    	                ExpectedConditions.visibilityOfElementLocated(
	    	                        By.xpath("//select[@id='formType']"))
	    	        ));

	    	        return true;

	    	    } catch (Exception e) {

	    	        System.out.println("Failed to open latest inward: " + e.getMessage());

	    	        return false;
	    	    }
	    	}

	    	
	    public void waitForOverlaysToDisappear() {

	    	  WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	    	    try {
	    	        wait.until(driver -> {
	    	            List<WebElement> modals = driver.findElements(
	    	                By.xpath("//section[contains(@class,'modal') and contains(@class,'ng-scope')]"));

	    	            return modals.stream().noneMatch(WebElement::isDisplayed);
	    	        });
	    	    } catch (TimeoutException e) {
	    	        System.out.println("⚠ Modal still present - continuing execution");
	    	    }
	    }
	    
	    public void stableClick(By locator) {

	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

	        for (int i = 0; i < 5; i++) {
	            try {
	                // 1. Wait for loader to disappear (GLOBAL FIX)
	                wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                        By.xpath("//div[contains(@class,'loader')]")));

	                // 2. Wait for page stable (IMPORTANT)
	                wait.until(driver ->
	                        ((JavascriptExecutor) driver)
	                                .executeScript("return document.readyState")
	                                .equals("complete"));

	                // 3. Get fresh element ALWAYS
	                WebElement element = wait.until(ExpectedConditions.refreshed(
	                        ExpectedConditions.presenceOfElementLocated(locator)));

	                // 4. Scroll safely
	                ((JavascriptExecutor) getDriver())
	                        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

	                // 5. Click using locator (NOT stored element)
	                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

	                return;

	            } catch (StaleElementReferenceException e) {
	                System.out.println("Retry due to stale...");
	            } catch (ElementClickInterceptedException e) {
	                System.out.println("Retry due to intercept...");

	                WebElement element = getDriver().findElement(locator);
	                ((JavascriptExecutor) getDriver())
	                        .executeScript("arguments[0].click();", element);
	                return;
	            }
	        }

	        throw new RuntimeException("Unable to click element after retries: " + locator);
	    }
	    
	    public void handleModal() {

	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	        By modal = By.xpath("//section[contains(@class,'modal')]");
	        By closeBtn = By.xpath("//button[contains(@class,'close')]");

	        try {
	            if (getDriver().findElements(modal).size() > 0) {

	                // Wait modal visible
	                wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

	                // Click close properly (NO JS REMOVE ❌)
	                wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();

	                // Wait modal gone
	                wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));

	                System.out.println("Modal handled properly");
	            }

	        } catch (Exception e) {
	            System.out.println("Modal not present or already closed");
	        }
	    }
	    
	    public void waitForAjax() {

	        try {

	            WebDriverWait wait =
	                    new WebDriverWait(driver, Duration.ofSeconds(30));

	            wait.until(webDriver -> {

	                JavascriptExecutor js =
	                        (JavascriptExecutor) webDriver;

	                Object result = js.executeScript(
	                        "return window.jQuery != undefined && jQuery.active == 0");

	                return result.equals(true);
	            });

	            System.out.println("AJAX completed");

	        } catch (Exception e) {

	            System.out.println("No AJAX pending or jQuery not present");
	        }
	    }
	    
	    public void waitForPageToStabilize() {

	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    	    try {

	    	        // WAIT FOR VISIBLE MODAL ONLY
	    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    	                By.cssSelector(".modal.show")));

	    	    } catch (Exception e) {

	    	        System.out.println("No active modal found");
	    	    }

	    	    try {

	    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    	                By.cssSelector(".modal-backdrop")));

	    	    } catch (Exception e) {

	    	        System.out.println("No modal backdrop found");
	    	    }

	    	    wait.until(webDriver ->
	    	            ((JavascriptExecutor) webDriver)
	    	                    .executeScript("return document.readyState")
	    	                    .equals("complete"));
	    	}
	    
	    public boolean selectLatestInwardN() {

	    	    By latestViewBtn =
	    	            By.xpath("(//table//button[normalize-space()='View'])[1]");

	    	    try {

	    	        WebDriverWait wait =
	    	                new WebDriverWait(getDriver(), Duration.ofSeconds(40));

	    	        // STEP 1
	    	        waitForLoaderToDisappear();
	    	        waitForModalToDisappear();
	    	        waitForAjax();
	    	        waitForPageLoad();

	    	        // STEP 2
	    	        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	    	                latestViewBtn, 0));

	    	        // STEP 3
	    	        for (int retry = 0; retry < 4; retry++) {

	    	            try {

	    	                WebElement viewButton =
	    	                        wait.until(ExpectedConditions.refreshed(
	    	                                ExpectedConditions.elementToBeClickable(
	    	                                        latestViewBtn)));

	    	                // scroll center
	    	                ((JavascriptExecutor) driver).executeScript(
	    	                        "arguments[0].scrollIntoView({block:'center'});",
	    	                        viewButton);

	    	                Thread.sleep(1000);

	    	                try {
	    	                    viewButton.click();

	    	                } catch (Exception e) {

	    	                    ((JavascriptExecutor) driver)
	    	                            .executeScript(
	    	                                    "arguments[0].click();",
	    	                                    viewButton);
	    	                }

	    	                System.out.println("Clicked latest View button");

	    	                // STEP 4
	    	                wait.until(ExpectedConditions.or(

	    	                        ExpectedConditions.visibilityOfElementLocated(
	    	                                By.id("formType")),

	    	                        ExpectedConditions.visibilityOfElementLocated(
	    	                                By.xpath("//section[contains(@class,'modal')]"))

	    	                ));

	    	                System.out.println("Inward opened successfully");

	    	                return true;

	    	            } catch (StaleElementReferenceException e) {

	    	                System.out.println(
	    	                        "Retrying due to stale element: " + retry);

	    	                Thread.sleep(2000);
	    	            }
	    	        }

	    	    } catch (Exception e) {

	    	        System.out.println(
	    	                "Failed to open latest inward: "
	    	                        + e.getMessage());

	    	        takeScreenshot("openLatestInward");

	    	        return false;
	    	    }

	    	    return false;
	    	}	    /* ---------------- DROPDOWN ---------------- */
	    
private void takeScreenshot(String string) {
			// TODO Auto-generated method stub
			
		}

private void scrollIntoView(WebElement latestView) {
			// TODO Auto-generated method stub
			
		}

		//	    public void selectFromDropdown(By locator, String value) {
//
//	        WebDriverWait wait = getWait();
//	        waitForOverlaysToDisappear();
//	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//	        for (int i = 0; i < 3; i++) {
//	            try {
//	                WebElement element = wait.until(
//	                        ExpectedConditions.elementToBeClickable(locator));
//
//	                Select select = new Select(element);
//	                select.selectByVisibleText(value.trim());
//	                break;
//
//	            } catch (StaleElementReferenceException e) {
//	                if (i == 2) throw e; // rethrow after retry
//	            }
//	        }
//	    }
	    public void selectFromDropdownN(WebElement element, String value) {
	        Select dropdown = new Select(element);

	        for (WebElement option : dropdown.getOptions()) {
	            if (option.getText().contains(value)) {
	                option.click();
	                System.out.println("Selected: " + option.getText());
	                return;
	            }
	        }

	        throw new RuntimeException("Dropdown value not found: " + value);
	    }
	    
	    public void waitForDropdownToPopulate(By dropdownLocator) {

	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    	    // Wait for dropdown presence
	    	    WebElement dropdown = wait.until(
	    	            ExpectedConditions.presenceOfElementLocated(dropdownLocator));

	    	    // Wait for dropdown options
	    	    wait.until(driver -> {
	    	        Select select = new Select(dropdown);
	    	        return select.getOptions().size() > 1;
	    	    });

	    	    System.out.println("Dropdown populated successfully");
	    	}

	    
	    public void selectFromDropdown(By locator, String visibleText) {

	    	 WebDriverWait wait =
	    	            new WebDriverWait(driver, Duration.ofSeconds(20));

	    	    int attempts = 0;

	    	    while (attempts < 3) {

	    	        try {

	    	            WebElement dropdown =
	    	                    wait.until(ExpectedConditions.elementToBeClickable(locator));

	    	            wait.until(driver -> {

	    	                WebElement refreshedDropdown =
	    	                        driver.findElement(locator);

	    	                Select refreshedSelect =
	    	                        new Select(refreshedDropdown);

	    	                return refreshedSelect.getOptions().size() > 1;
	    	            });

	    	            dropdown = driver.findElement(locator);

	    	            Select select = new Select(dropdown);

	    	            select.selectByVisibleText(visibleText);

	    	            System.out.println("Selected Value = " + visibleText);

	    	            return;

	    	        } catch (StaleElementReferenceException e) {

	    	            System.out.println("Dropdown became stale. Retrying...");

	    	        } catch (Exception e) {

	    	            System.out.println("Failed selecting dropdown value: " + visibleText);

	    	            throw e;
	    	        }

	    	        attempts++;

	    	        try {
	    	            Thread.sleep(1000);
	    	        } catch (InterruptedException ignored) {
	    	        }
	    	    }

	    	    throw new RuntimeException(
	    	            "Unable to select dropdown value: " + visibleText);
	    	}
	        
	    public void waitForModalToDisappear() {

	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

	        try {

	            wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.xpath("//section[contains(@class,'modal') and @ng-show='showKpidetail']")
	            ));

	            System.out.println("Modal disappeared");

	        } catch (Exception e) {

	            System.out.println("Modal still active");

	            JavascriptExecutor js = (JavascriptExecutor) getDriver();

	            js.executeScript(
	                "document.querySelector(\"section.modal.ng-scope[ng-show='showKpidetail']\").style.display='none';"
	            );
	        }
	    }
	    
	    /* ---------------- INPUTTEXT ---------------- */
	    public void Input(By locator, String value) { 
	    	
	    	WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	    	
	    	 handleModal();

	    	    waitForLoaderToDisappear();

	    	    WebElement element = wait.until(
	    	            ExpectedConditions.elementToBeClickable(locator)); 
	    
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

	    	    waitForModalToDisappear();
	    	    handleAlertIfPresent();

	    	    WebDriverWait wait =
	    	            new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	    	    WebElement element =
	    	            wait.until(ExpectedConditions.elementToBeClickable(locator));

	    	    try {

	    	        element.click();

	    	    } catch (ElementClickInterceptedException e) {

	    	        System.out.println("Click intercepted. Waiting for overlay...");

	    	        waitForModalToDisappear();

	    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    	                By.cssSelector(".modal-backdrop")));

	    	        // RE-FETCH ELEMENT
	    	        element = wait.until(
	    	                ExpectedConditions.elementToBeClickable(locator));

	    	        element.click();
	    	    }
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