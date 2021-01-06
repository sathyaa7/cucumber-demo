package parallel;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import pages.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @When("^I do data driven testing with \"([^\"]+)\"$")
    public void performDataDrivenTesting(String sheetName)
    {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("\\src\\test\\resources\\Book1.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    System.out.println(cell.getRichStringCellValue());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
