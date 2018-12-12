package Tests;

import ClearTripDetailPages.Home;
import ClearTripDetailPages.SignIn;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

    private Home homePage;
    private SignIn signInPage;
    private By errorMessage = By.id(Constants.error_1);


    @BeforeTest
    public void before(){
        homePage = new Home();
        signInPage = new SignIn();
    }


    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        homePage.redirect_to_YourTrips();
        homePage.redirect_to_SignInPage();
        signInPage.clickSignIn();
        WebElement webElement = new WebDriverWait(driver,timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(errorMessage);
        assertThat(webElement.getText(),containsString(Constants.signInErrorMessage));
    }
}
