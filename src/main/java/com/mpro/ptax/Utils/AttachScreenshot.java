package com.mpro.ptax.Utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttachScreenshot {

	    public static void attachScreenshot(WebDriver driver, String name) {

	        if (driver == null) return;

	        byte[] screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);

	        try {
	            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
	        } catch (Exception e) {
	            System.out.println("Allure attach skipped");
	        }

	        // Save locally
	        saveScreenshotToFile(screenshot, name);
	    }
    
	    
    private static void saveScreenshotToFile(byte[] screenshot, String name) {

        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String folderPath = System.getProperty("user.dir") + "/screenshots/";

            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File(folderPath + name + "_" + timeStamp + ".png");

            Files.write(file.toPath(), screenshot);

            System.out.println("Screenshot saved at: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}