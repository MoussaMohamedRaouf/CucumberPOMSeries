package stepsdefinition;

import com.pages.ContactUsPage;
import com.resources.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactSD {

    public ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("user navigate to contact us page")
    public void user_navigate_to_contact_us_page() {

        contactUsPage.getToForm();
    }

    @When("user fills the form from the give sheet {string} and row {string}")
    public void user_fills_the_form_from_the_give_sheet_and_row(String sheetName, String rowNumber) throws Throwable {
        List<Map<String, String>> testData = contactUsPage.getMaps(sheetName);
        String heading = testData.get(Integer.parseInt(rowNumber)).get("Subject Heading");
        String email = testData.get(Integer.parseInt(rowNumber)).get("Email address");
        String orderRef = testData.get(Integer.parseInt(rowNumber)).get("Order reference");
        String message = testData.get(Integer.parseInt(rowNumber)).get("Message");
        contactUsPage.fillContactUsForm(heading,email,orderRef,message);
    }
    @When("user clicks ob send button")
    public void user_clicks_ob_send_button() {
        contactUsPage.clickSend();

    }

    @Then("it shows success message {string}")
    public void it_shows_success_message(String expectedSuccessMessage) {
        String resultSucessMessage = contactUsPage.getSuccessMessge();
        Assert.assertEquals(resultSucessMessage,expectedSuccessMessage);
    }
}
