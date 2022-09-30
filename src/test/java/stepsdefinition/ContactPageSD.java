package stepsdefinition;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactPageSD {

    public ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("user navigate to contact us page")
    public void user_navigate_to_contact_us_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
    }

    @When("user fills the form from the give sheet {string} and row {string}")
    public void user_fills_the_form_from_the_give_sheet_and_row(String sheetName, String rowNumber)  {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = null;
        try {
            testData = reader.getData("/Users/moussa/Downloads/CucumberPOMSeries/src/test/resources/automation.xlsx",sheetName);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        String resultSucessMessage = contactUsPage.getSuccessMessg();
        Assert.assertEquals(resultSucessMessage,expectedSuccessMessage);
    }
}
