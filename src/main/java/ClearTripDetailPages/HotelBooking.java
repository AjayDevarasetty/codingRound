package ClearTripDetailPages;

import AllConstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBooking extends Home{
    private By tagsTextBox = By.id(Constants.tags);
    private By searchResultsList = By.cssSelector("ul[id='ui-id-1']>li[class='list']");
    private By searchHotelsButton = By.id(Constants.search_hotels_button);
    private By hotelsList = By.cssSelector("li[class*='listItem listUnit']");
    private By traveler_on_button = By.id(Constants.travellers_on_button);

    public boolean is_hotel_search_returns(){
        WebElement webElement = returnWebElement(hotelsList);
        if (webElement.isDisplayed()){
            return true;
        }
        return false;
    }

    public void search_hotels(String location,String list_of_travellers){
        returnWebElement(tagsTextBox).sendKeys(location);
        returnWebElement(searchResultsList).click();
        waitFor(1000);
        new Select(returnWebElement(traveler_on_button)).selectByVisibleText(list_of_travellers);
        returnWebElement(searchHotelsButton).click();
    }


    public WebElement returnWebElement(By byId){
        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(byId));
    }
}
