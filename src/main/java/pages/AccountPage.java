package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    @FindBy(xpath = "//div[@class=\"row addresses-lists\"]/div/ul/li/a/span")
    private List<WebElement> accountOptions;

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public List<String> user_gets_account_section() {
       List<String> list= new ArrayList<>();
       for(WebElement element:accountOptions)
       {
           list.add(element.getText());
       }
       return list;
    }

    public int accounts_section_count_should_be() {
        return accountOptions.size();
    }


}
