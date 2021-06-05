package Steps.Base;

import DriverFactory.DriverFactory;
import Utils.ScreenshotUtil;
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
        if (scenario.isFailed()) {
            scenario.attach(ScreenshotUtil.screenshot(scenario, base.getDriver()),
                    "image/png",
                    ScreenshotUtil.getScreenshotName(scenario));
        }
        base.getDriver()
            .close();
    }
}
