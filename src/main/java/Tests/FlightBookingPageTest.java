package Tests;

import ClearTripDetailPages.FlightBooking;
import ClearTripDetailPages.Home;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingPageTest extends Home {

    private Home home;
    private FlightBooking flightBooking;
    private String origin = Constants.flightOriginLocation;
    private String destination = Constants.flightDestinationLocation;

    @BeforeTest
    public void BeforeTest(){
        home = new Home();
        flightBooking = new FlightBooking();
    }

    @Test
    public void FlightBookingTestPage(){
        home.redirect_to_FLightSearchPage();
        flightBooking.searchForFlights(origin,destination,true);
        assertThat(flightBooking.is_flight_search_returns(),is(true));
    }
}
