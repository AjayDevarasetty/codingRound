package ClearTripDetailPages;

import AllConstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightBooking extends Home{
    private By searchButton = By.id(Constants.search_button);
    private By searchResults = By.className(Constants.search_summary);
    private By fromTag = By.id(Constants.from_tag);
    private By toTag = By.id(Constants.to_tag);

    public void searchForFlights (String departure_location,String destination_location,boolean oneWay){
        if(oneWay){
            WebElement originWebElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated(fromTag));
            originWebElement.click();
            originWebElement.sendKeys(departure_location);
            waitFor(1000);

            WebElement searchButtonWebElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated((searchButton));
            searchButtonWebElement.click();

        }
    }

    public boolean is_flight_search_returns(){
        WebElement webElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated((searchResults)));
        if (webElement.isDisplayed())
            return true;
        return false;

    }


}
