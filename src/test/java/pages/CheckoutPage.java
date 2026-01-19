package pages;


import objects.BillingDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "billing_first_name") private WebElement billingFirstNamefld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNamefld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressLine1fld;
    @FindBy(id = "billing_postcode" ) private WebElement billingZipCodefld;
    @FindBy(id = "billing_email") private WebElement billingEmailfld;
    @FindBy(id = "billing_state") private WebElement  billingStatefld;
    @FindBy(id = "billing_city") private WebElement billingCityfld;
    @FindBy( id  = "place_order") private WebElement placeOrderBtnfld;
    @FindBy(css = ".woocommerce-notice") private WebElement orderConfirmationMsg;
    @FindBy(id = "billing_country") private WebElement billingCountryfld;
    @FindBy(css = "label[for='payment_method_cod']") private WebElement codLabel;
    @FindBy(css = "ul.woocommerce-error li") private WebElement errorMsg;

    public CheckoutPage placeOrder(){
       wait.until(ExpectedConditions.visibilityOf(placeOrderBtnfld)).click();
       return this;
    }
    public String getConfirmationMsg(){
       return wait.until(ExpectedConditions.visibilityOf(orderConfirmationMsg)).getText();
    }
    public String getErrorMsg(){
       return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }

    public void selectPaymentMethod(String method){
       if(method.equalsIgnoreCase("Cash on delivery")){
           wait.until(ExpectedConditions.elementToBeClickable(codLabel)).click();
       }
    }

    public CheckoutPage enterBillingDetails(BillingDetail detail){
       wait.until(ExpectedConditions.visibilityOf(billingFirstNamefld)).sendKeys(detail.getBillingFirstName());
       billingLastNamefld.sendKeys(detail.getBillingLastName());
        Select countrySelect = new Select(wait.until(ExpectedConditions.visibilityOf(billingCountryfld)));
        countrySelect.selectByVisibleText(detail.getCountry().getName());
       billingAddressLine1fld.sendKeys(detail.getBillingAddressLine1());
       billingCityfld.sendKeys(detail.getBillingCity());
        if(detail.getCountry().hasStates()){
            Select stateSelect = new Select(wait.until(ExpectedConditions.visibilityOf(billingStatefld)));
            List<WebElement> options = stateSelect.getOptions();
            for(WebElement option : options){
                if(option.getText().equalsIgnoreCase(detail.getBillingState())){
                    option.click();
                    break;
                }
            }
        }
       billingZipCodefld.sendKeys(detail.getBillingZipCode());
       billingEmailfld.sendKeys(detail.getBillingEmail());

        return this;
    }



}
