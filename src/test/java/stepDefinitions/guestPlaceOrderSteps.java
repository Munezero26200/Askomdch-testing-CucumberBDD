package stepDefinitions;

import Constants.EndPoints;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.BillingDetail;
import objects.Country;
import objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class guestPlaceOrderSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    StorePage storePage = new StorePage(DriverFactory.getDriver());

    public guestPlaceOrderSteps(){
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage = new StorePage(DriverFactory.getDriver());
        storePage.load(EndPoints.STORE.url);
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
       new StorePage(driver).addToCart(new Product("Blue Shoes"));
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        CartPage cartPage = new CartPage(driver);
         cartPage.clickProceedToCheckout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(BillingDetail detail) {

      CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
      checkoutPage.enterBillingDetails(detail);


    }
    @And("I select {string} as payment method")
    public void selectPaymentOrder(String paymentMethod){
        CheckoutPage  checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.selectPaymentMethod(paymentMethod);
    }
    @And("I provide {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} as billing details")
    public void enterBillingdetails(String firstname,
                                    String lastname,
                                    String countryName,
                                    String addressLine1,
                                    String state,
                                    String city,
                                    String zip,
                                    String email) {
        Country country = Country.fromString(countryName);
        BillingDetail billingDetail = new BillingDetail(firstname,
                                                        lastname,
                                                        addressLine1,
                                                        zip,
                                                         email,
                                                         state,
                                                         city,
                                                          country);
        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.enterBillingDetails(billingDetail);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {

       assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getConfirmationMsg());
    }
    @Then("I should see an error message {string}")
    public void errorMsgDisplayed(String expectedErrorMsg){
        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        String actualError = checkoutPage.getErrorMsg();
        assertTrue("Expected error not found!", actualError.contains(expectedErrorMsg));
    }
}
