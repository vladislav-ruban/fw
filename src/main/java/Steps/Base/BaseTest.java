package Steps.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTest extends BaseUtil {

    BaseUtil base;

    public BaseTest(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        base.setDriver(driverFactory.getBrowser());
        base.getDriver()
            .manage()
            .window()
            .maximize();
        base.getDriver()
            .manage()
            .deleteAllCookies();
    }

    @After(order = 2)
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File scrFile = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotName = String.format("%s_%s", scenario.getName(), dateFormat.format(calendar.getTime()));
            try {
                FileUtils.copyFile(scrFile, new File(String.format("./Screenshots/%s.png", screenshotName)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        base.getDriver()
            .close();
    }


/*
    @After(order = 1)
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String methodName = scenario.getName();

            File scrFile = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotName = String.format("%s_%s", methodName, formater.format(calendar.getTime()));
            try {
                FileUtils.copyFile(scrFile, new File(String.format("target\\allure-results\\screenshots\\%s",
                        screenshotName)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
*/
/*
    @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult result){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotName = String.format("%s_%s.png", methodName, formater.format(calendar.getTime()));
            try {
                FileUtils.copyFile(scrFile, new File(String.format("target\\allure-results\\screenshots\\%s",
                screenshotName)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }*/
}
