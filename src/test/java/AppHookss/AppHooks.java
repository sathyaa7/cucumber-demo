package AppHookss;

import Factory.DriverFactory;
import Utilities.ConfigBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory=new DriverFactory();
    private WebDriver driver;
    private ConfigBuilder configBuilder;

    @Before
    public void launchBrowser()
    {
        configBuilder = new ConfigBuilder();
       Properties prop=configBuilder.initProp();
       driver=driverFactory.initBrowser(prop.getProperty("browser"));
    }

    @After
    public void closeBrowser(Scenario sce)
    {
        if(sce.isFailed())
        {
            String screenshotName= sce.getName();
            byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sce.attach(srcPath,"image/png",screenshotName);
        }
        driver.quit();
    }
}
