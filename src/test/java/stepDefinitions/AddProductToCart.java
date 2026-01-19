package stepDefinitions;

import Constants.EndPoints;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.StorePage;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;



public class AddProductToCart {

    private WebDriver driver;
    private WebDriverWait wait;
    private StorePage storePage;
    private CartPage cartPage;

    public AddProductToCart(){
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    @Given("I'm on the store page")
    public void storePage() {
        storePage = new StorePage(DriverFactory.getDriver());
        storePage.load(EndPoints.STORE.url);
    }

    @When("I add a {product} in the cart")
    public void addProduct(Product product) {
        storePage.addToCart(product);

    }

    @Then("I should see {int} {product} in the cart")
    public void assertProductInCart(int quantity, Product product) {

        cartPage = new CartPage(DriverFactory.getDriver());
        assertEquals(product.getName(), cartPage.getProductName());
       assertEquals(quantity, cartPage.getProductQuantity());

    }


}
