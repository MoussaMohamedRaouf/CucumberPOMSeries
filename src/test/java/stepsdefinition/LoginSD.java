package stepsdefinition;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSD {
    private static String title;
    private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title:"+title);
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));
    }

    @Then("forget password link should be displayed")
    public void forget_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLink());
    }
    @When("user enters username {string}")
    public void user_enters_username(String email) {
        loginPage.enterEmail(email);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
    loginPage.clickLogin();
    }
}
