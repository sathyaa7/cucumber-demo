package AppHookss;

import Factory.DriverFactory;
import Utilities.ConfigBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppHooks {

    private DriverFactory driverFactory = new DriverFactory();
    private static WebDriver driver;
    private ConfigBuilder configBuilder;

//    @Before
//    public void launchBrowser()
//    {
//        configBuilder = new ConfigBuilder();
//       Properties prop=configBuilder.initProp();
//       driver=driverFactory.initBrowser(prop.getProperty("browser"));
//    }
//
//    @After
//    public void closeBrowser(Scenario sce)
//    {
//        if(sce.isFailed())
//        {
//            String screenshotName= sce.getName();
//            byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            sce.attach(srcPath,"image/png",screenshotName);
//        }
//        driver.quit();
//    }

    public static final String USERNAME = "usernamehere";
    public static final String AUTOMATE_KEY = "key here";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //@Parameters({"browser", "browser_version", "os", "os_version"})
    @Before
    public void setUp(Scenario scenario) {
       String browserName = "Chrome";
        String browser_version = "87.0";
        String  os = "windows";
        String  os_version="10";


        System.out.println("browser name is : " + browserName);
        String methodName = scenario.getName();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", os);
        caps.setCapability("os_version", os_version);
        caps.setCapability("browser_version", browser_version);
        caps.setCapability("name", methodName);
         //ThreadLocal<WebDriver> tDriver =new ThreadLocal<WebDriver>();
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            caps.setCapability("browser", "Firefox");
        }
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            System.out.println("driver initialized========");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
