package stepDefinitions;

import Constants.EndPoints;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.RegistrationDetail;
import pages.AccountPage;
import pages.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationSteps {

    private RegistrationPage registrationPage;

    @Given("I am on the registration page")
    public void onRegistrationPage() {
        registrationPage = new RegistrationPage(DriverFactory.getDriver());
        registrationPage.load(EndPoints.ACCOUNT.url);
    }
    @When("I register with {string}, {string}, and {string}")
    public void enterCredentials(String username, String email, String password) {
        RegistrationDetail detail = new RegistrationDetail(username,email,password);
        registrationPage.register(detail);
    }
    @Then("I should see a confirmation message for {string}")
    public void confirmationMsgDisplayed(String username) {
       AccountPage accountPage= new AccountPage(DriverFactory.getDriver());
       String actualConfirmationMsg = accountPage.getConfirmationMsg();

        String expectedMsg = "Hello " + username + " (not " + username + "? Log out)";
        assertEquals("Expected greeting not found", expectedMsg, actualConfirmationMsg.trim());
    }

    @Then("I should see the error message")
    public void errorMsgDisplayed() {
        String actualErrorMsg = registrationPage.getErrorMsg();
        assertTrue(actualErrorMsg.contains("Error"));
    }

}
