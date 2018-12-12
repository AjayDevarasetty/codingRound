package ClearTripDetailPages;

import org.openqa.selenium.By;
import main.java.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends Home{
    private By signInBtn = By.id(Constants.signinId);
    private By loginFrame = By.id(Constants.moralWindow);
    private By errorMessage = By.id(Constants.error_1);

    public void clickSignIn(){
        // Switching the focus to login frame after clicking "Your Trips" --> "Sign In"
        driver.switchTo().frame(findElementWithTimeOut(loginFrame));
        WebElement webElement = new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(signInBtn));
        webElement.click();
    }
}
