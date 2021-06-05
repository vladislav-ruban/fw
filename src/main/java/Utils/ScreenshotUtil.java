package Utils;

import com.google.common.io.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

public class ScreenshotUtil {
    public static String getScreenshotName(Scenario scenario) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        return String.format("%s_%s", scenario.getName(), dateFormat.format(calendar.getTime()));
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot(Scenario scenario, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = getScreenshotName(scenario);
        try {
            FileUtils.copyFile(scrFile, new File(String.format("./Screenshots/%s.png", screenshotName)));
            return Files.toByteArray(scrFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
