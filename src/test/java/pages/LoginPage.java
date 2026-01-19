package pages;

import objects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "username") private WebElement usernameOrEmailFld;
    @FindBy(id = "password") private WebElement passwordFld;
    @FindBy(css = "button[value='Log in']") private WebElement loginBtn;
    @FindBy(css = ".woocommerce-error") private WebElement errorMsg;


    public LoginPage enterLoggedInCredentials(String credential, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameOrEmailFld)).sendKeys(credential);
        wait.until(ExpectedConditions.visibilityOf(passwordFld)).sendKeys(password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        return this;
    }
    public String getErrorMsg(){
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }
    public LoginPage login(Customer customer){
        return enterLoggedInCredentials(customer.getUsername(),customer.getPassword());

    }

}
