package stepsdefinition;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountPageSD {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credentialTable) {
        List<Map<String, String>> list = credentialTable.asMaps();
        String userName = list.get(0).get("username");
        String password = list.get(0).get("password");
        System.out.println(userName+" and "+password);
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountPage = loginPage.login(userName, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String pageTitle = accountPage.getTitle();
        System.out.println("Account page title: "+pageTitle);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expectedAccountsList = sectionsTable.asList();
        List<String> accountsList =accountPage.getAccountsSectionList();
        System.out.println("Expected:"+expectedAccountsList);
        System.out.println("Actual  :"+accountsList);
        Assert.assertEquals(expectedAccountsList,accountsList);
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedCount) {
        System.out.println("Actual count : "+accountPage.getAccountSections()+"expected count :"+expectedCount);
        Assert.assertTrue(accountPage.getAccountSections()==expectedCount);

    }
}
