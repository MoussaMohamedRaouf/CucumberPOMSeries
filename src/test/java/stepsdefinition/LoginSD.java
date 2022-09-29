package stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("user is on login page");

    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        System.out.println("user gets the title of the page");

    }
    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        System.out.println("page title should be moussaraouf@outlook.fr");

    }

    @Then("forget password link should be displayed")
    public void forget_password_link_should_be_displayed() {
        System.out.println("forget password link should be displayed");

    }


    @When("user enters username {string}")
    public void user_enters_username(String string) {
        System.out.println("user enters username moussaraouf@outlook.fr");

    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        System.out.println("user enters password ");

    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        System.out.println("user clicks on Login button");
    }
}
