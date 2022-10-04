package stepsdefinition;

import com.pages.HomePage;
import com.pages.SearchPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FillCartSD {
    private HomePage homePage= new HomePage(DriverFactory.getDriver());
    private SearchPage searchPage;
    @Given("user is on home page")
    public void user_is_on_home_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php");
    }
    @Given("user is on Search page")
    public void user_is_on_search_page() {
        String pageTitle = homePage.getTitle();
        if (pageTitle == "My Store") {
        System.out.println("Account page title: "+pageTitle);
        }else
            DriverFactory.getDriver().get("http://automationpractice.com/index.php");
    }

    @Given("products are displayed")
    public void products_are_displayed() {


    }

    @Given("displayed products count {int}")
    public void displayed_products_count(Integer int1) {

    }

    @When("user adds product to cart")
    public void user_adds_product_to_cart() {

    }

    @When("clicks the proceed to checkout button")
    public void clicks_the_proceed_to_checkout_button() {

    }


    @When("user fills search input with {string}")
    public void userFillsSearchInputWith(String searchText) {
        homePage.enterSearch(searchText);
        searchPage = homePage.clickSearch();
    }
}
