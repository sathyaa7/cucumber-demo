package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    //public WebDriver  driver;

    public static ThreadLocal<WebDriver> tDriver =new ThreadLocal<WebDriver>();

    public WebDriver initBrowser(String browser)
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tDriver.set(new ChromeDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return tDriver.get();
    }
}
