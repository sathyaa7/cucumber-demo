package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="email")
    private WebElement email;


    @FindBy(id="passwd")
    private WebElement passwd;


    @FindBy(id="submitLogin")
    private WebElement submitLogin;



    private WebDriver webDriver;

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.webDriver=driver;
    }

    public String getLoginPageTitle()
    {
        return webDriver.getTitle();
    }

    public boolean isFPlinkExists()
    {
        return webDriver.findElement(By.linkText("Forgot your password?")).isDisplayed();
    }


    public void enterCred(String userName,String passWord)
    {
//        webDriver.findElement(By.id("email")).sendKeys(userName);
//        webDriver.findElement(By.id("passwd")).sendKeys(passWord);
        email.sendKeys(userName);
        passwd.sendKeys(passWord);
    }

    public void signIn()

    {
        webDriver.findElement(By.id("SubmitLogin")).click();
       // submitLogin.click();
    }





}
