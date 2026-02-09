package com.mpro.ptax.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pro.ptax.driver.DriverManager;

public class CaptureScreenshot {
	
	public static String captureMessage(By locator, int timeoutSeconds) {

        try {
            WebDriverWait wait =
                    new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));

            WebElement element =
                    wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            return element.getText();

        } catch (TimeoutException e) {
            return null;
        }
    }
}

