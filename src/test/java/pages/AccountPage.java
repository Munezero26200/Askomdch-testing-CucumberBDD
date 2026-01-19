package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//p[contains(text(),'Hello')]") private WebElement confirmationMsg;


    public String getConfirmationMsg(){
        return wait.until(ExpectedConditions.visibilityOf(confirmationMsg)).getText();
    }
}
