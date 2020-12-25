package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginDefinitions {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is in login page")
    public void LoginApp() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


    }

    @When("I verify the title of the page")
    public void verifyPage() {
        System.out.println("Going to verify title-----------");
    }

    @Then("^page title should be \"([^\"]+)\"$")
    public void verifyTitle(String title) {
        System.out.println("Verifying title-----------");
        Assert.assertTrue(loginPage.getLoginPageTitle().equals(title));
    }


    @Then("the forgot password link should be displayed")
    public void verifyLink() {
        Assert.assertTrue(loginPage.isFPlinkExists());
    }


    @When("^the user enters the \"([^\"]+)\" and \"([^\"]+)\"$")
    public void enterCred(String username, String password) {
        System.out.println(username+""+password);
        loginPage.enterCred(username, password);
    }

    @When("the user clicks the login button")
    public void clickLogin() {
        loginPage.signIn();
    }

}
