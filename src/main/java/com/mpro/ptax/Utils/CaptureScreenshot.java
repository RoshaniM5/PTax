package com.mpro.ptax.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mpro.ptax.base.BasePage;

import org.apache.commons.io.FileUtils;

public class CaptureScreenshot extends BasePage{

    public static void takeScreenshot() {

        if (driver == null) {
            System.out.println("Driver is null, cannot take screenshot");
            return;
        }

        try {
            // 📅 Timestamp for unique file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // 📁 Folder path
            String folderPath = System.getProperty("user.dir") + "/screenshots/";

            // Create folder if not exists
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }

            // 📸 Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 📂 Destination file
            File dest = new File(folderPath + "FailedTest_" + timeStamp + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}