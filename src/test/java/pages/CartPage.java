package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameField;
    @FindBy(css = "input[type='number']") private WebElement productQuantityField;
    @FindBy(css = ".checkout-button") private WebElement proceedToCheckoutBtn;

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productNameField)).getText();
    }
    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityField)).getAttribute("value"));
    }

    public void clickProceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }


}
