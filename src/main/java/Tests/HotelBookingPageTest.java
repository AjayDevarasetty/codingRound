package Tests;

import AllConstants.Constants;
import ClearTripDetailPages.Home;
import ClearTripDetailPages.HotelBooking;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingPageTest extends Home {

    private Home home;
    private HotelBooking hotelBooking;
    private String area_location;
    private String travellers_list;

    @BeforeTest
    public void BeforeTest(){
        home = new Home();
        hotelBooking = new HotelBooking();
        area_location = Constants.hotels_area_location;
        travellers_list = Constants.travellers_list;
    }

    @Test
    public void search_for_hotels(){
        home.redirect_to_HotelSearchPage();
        hotelBooking.search_hotels(area_location,travellers_list);
        assertThat(hotelBooking.is_hotel_search_returns(),is(true));
    }
}
