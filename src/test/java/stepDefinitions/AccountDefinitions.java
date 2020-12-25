package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.LoginPage;

import java.util.*;


public class AccountDefinitions {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage=new AccountPage(DriverFactory.getDriver());


    @Given("The user has already logged into the application")
    public void user_is_on_accounts_page(io.cucumber.datatable.DataTable dataTable) {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        List<Map<String, String>> listOfMaps = dataTable.asMaps(String.class, String.class);
        loginPage.enterCred(listOfMaps.get(0).get("username"), listOfMaps.get(0).get("password"));
        loginPage.signIn();
    }


    @When("user is on accounts page")
    public void user_gets_title_of_the_page() {
        System.out.println("User is in accounts page--------");
    }


    @Then("user gets account section")
    public void user_gets_account_section(io.cucumber.datatable.DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        List<String> expectedList=new ArrayList<>();
        for(String currentValue :list) {
            expectedList.add(currentValue.toUpperCase());
        }
        Collections.sort(expectedList);
        List<String> actualList=accountPage.user_gets_account_section();
        Collections.sort(actualList);
        System.out.println(expectedList +" "+actualList);
Assert.assertTrue(expectedList.equals(actualList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer int1) {
        Assert.assertTrue(accountPage.accounts_section_count_should_be()==int1);

    }


}
