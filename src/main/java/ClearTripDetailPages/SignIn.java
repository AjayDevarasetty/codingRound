package ClearTripDetailPages;

import AllConstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver.*;

public class SignIn extends Home{
    private By signInBtn = By.id(Constants.signInId);
    private By loginFrame = By.id(Constants.moralWindow);
    private By errorMessage = By.id(Constants.error_l);

    public void clickSignIn(){
        // Switching the focus to login frame after clicking "Your Trips" --> "Sign In"
        WebElement webElement = new WebDriverWait(webDriver, 5)).until(ExpectedConditions.presenceOfElementLocated(loginFrame));
        webDriver.switchTo().frame(webElement);
        WebElement signInwebElement = new WebDriverWait(webDriver, 5)).until(ExpectedConditions.presenceOfElementLocated(signInBtn));
        signInwebElement.click();
    }
}
