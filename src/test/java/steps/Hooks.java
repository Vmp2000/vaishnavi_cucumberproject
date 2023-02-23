package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserManager;

public class Hooks {
    private BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Before(
            order = 0
    )
    public void setUp() {
        this.browserManager.setDriver();
    }

    @After(
            order = 1
    )
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot)this.browserManager.getDriver();
            byte[] src = (byte[])ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }

    }

    @After(
            order = 0
    )
    public void tearDown() {
        this.browserManager.getDriver().quit();
    }
}

