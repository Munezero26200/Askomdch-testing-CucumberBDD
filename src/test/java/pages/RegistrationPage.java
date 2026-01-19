package pages;

import objects.RegistrationDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "reg_username") private WebElement usernameFld;
    @FindBy(id="reg_email") private WebElement emailAddressFld;
    @FindBy(id="reg_password") private WebElement passwordFld;
    @FindBy(css = "button[value='Register']") private WebElement registerBtn;
    @FindBy(css = "div[id='content'] li:nth-child(1)") private  WebElement errorMsg;

    public RegistrationPage enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameFld)).sendKeys(username);
        return this;
    }

    public RegistrationPage enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailAddressFld)).sendKeys(email);
        return this;
    }
    public RegistrationPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordFld)).sendKeys(password);
        return this;
    }
    public RegistrationPage clickRegisterBtn(){
        wait.until(ExpectedConditions.visibilityOf(registerBtn)).click();
        return this;
    }

    public String getErrorMsg(){
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }
    public RegistrationPage register(RegistrationDetail detail){
        return enterUsername(detail.getName())
                .enterEmail(detail.getEmail())
                .enterPassword(detail.getPassword())
                .clickRegisterBtn();

    }
}
