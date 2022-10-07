package stepsdefinition;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuySD {
    public HomePage homePage = new HomePage(DriverFactory.getDriver());
    public LoginPage loginPage;
    public AccountPage accountPage;
    public TShirtsPage tshirtPage;
    public DetailPage detailPage;
    @Given("the user is on home page of the website")
    public void the_user_is_on_home_page_of_the_website() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php");
        String pageTitle = homePage.getTitle();
        System.out.println("Home Page Title: "+pageTitle);
    }
    @When("User clicks sign in button")
    public void user_clicks_sign_in_button() {
        System.out.println("User clicks sign in button");
        loginPage = homePage.clickOnSignInButton();
    }

    @Then("User enters username and password and click login")
    public void user_enters_username_and_password_and_click_login() {
        accountPage = loginPage.login();
    }

    @Then("Move your cursor over women's link")
    public void move_your_cursor_over_women_s_link() {
        System.out.println("Move your cursor over women's link");
        homePage.Hover_Over_Women_Button();

    }
    @Then("Click on sub menu T-shirts")
    public void click_on_sub_menu_t_shirts() {
        tshirtPage = homePage.clickTShirtButton();
    }
    @Then("Mouse hover on the first product displayed")
    public void mouse_hover_on_the_first_product_displayed() {
        System.out.println("Mouse hover on the first product displayed");
        tshirtPage.hoverFirstProduct();
    }
    @Then("More button will be displayed click on More button")
    public void more_button_will_be_displayed_click_on_more_button() {
        System.out.println("More button will be displayed click on More button");
        detailPage = tshirtPage.clickMoreButton();
    }
    @Then("Increase quantity to two select size L select color")
    public void increase_quantity_to_two_select_size_l_select_color() {
        System.out.println("Increase quantity to two select size L select color");
        detailPage.increaseQte();
        detailPage.updateSize("L");
        detailPage.updateColor();
    }
    @Then("Click add to cart")
    public void click_add_to_cart() {
        System.out.println("Click add to cart");
    }
    @Then("Click procees to checkout")
    public void click_procees_to_checkout() {
        System.out.println("Click procees to checkout");
    }
    @Then("Complete the buy order process till payment")
    public void complete_the_buy_order_process_till_payment() {
        System.out.println("Complete the buy order process till payment");
    }
    @Then("Make sure that Product is ordered")
    public void make_sure_that_product_is_ordered() {
        System.out.println("Make sure that Product is ordered");
    }

}
