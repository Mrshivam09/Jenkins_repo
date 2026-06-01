package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    // ------------------------------------------------
    // CAPTURE SCREENSHOT METHOD
    // ------------------------------------------------

    public static String captureScreenshot(
    WebDriver driver,
    String screenshotName) {

    	
        String timeStamp =
        new SimpleDateFormat(
        "yyyyMMdd_HHmmss")
        .format(new Date());

        String destination =
        System.getProperty("user.dir")
        + "/Screenshots/"
        + screenshotName + "_"
        + timeStamp + ".png";

        TakesScreenshot ts =
        (TakesScreenshot) driver;

        File source =
        ts.getScreenshotAs(OutputType.FILE);

        File finalDestination =
        new File(destination);

        try {

            FileUtils.copyFile(
            source,
            finalDestination);

            System.out.println(
            "Screenshot captured successfully");

        }

        catch(IOException e) {

            e.printStackTrace();
        }

        return destination;
    }
}