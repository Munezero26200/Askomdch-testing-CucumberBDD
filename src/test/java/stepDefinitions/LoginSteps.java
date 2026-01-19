package stepDefinitions;

import Constants.EndPoints;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Customer;
import pages.AccountPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

  private  LoginPage loginPage;

    @Given("I am on the login page")
    public void onLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.load(EndPoints.ACCOUNT.url);

    }
    @When("I login with {string} and {string}")
    public void loggedInWithCredentials(String usernameOrEmail, String password) {
        Customer customer = new Customer(usernameOrEmail, password);
        loginPage.login(customer);
        loginPage.clickLoginBtn();
    }
    @Then("I should see a confirmation message {string}")
    public void confirmationMsgDisplayed(String expectedMsg) {
        AccountPage accountPage = new AccountPage(DriverFactory.getDriver());
        String actualMsg = accountPage.getConfirmationMsg();

        assertEquals("Greeting message mismatch!", expectedMsg,actualMsg.trim());
    }
    @Then("I should see an error message")
    public void errMsgDisplayed() {
        String actualErroMsg = loginPage.getErrorMsg();
        assertTrue(actualErroMsg.contains("Error"));
    }


}
