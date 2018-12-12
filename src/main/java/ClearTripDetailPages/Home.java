//Author : Ajay Devarasetty
//Date : 12/12/2018

package ClearTripDetailPages;

/*
This class is responsible for opening the Home Page
It is the common method for opening the
SignIn Page
Flight Booking Page
Hotel Booking Page
*/

import AllConstants.Constants;
import com.sun.javafx.PlatformUtil;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;

public class Home {

    public static WebDriver webDriver;
    private static CompositeConfiguration compositeConfiguration;
    private By tripsLink = By.linkText(Constants.tripsLink);
    private By signInIdLink = By.id(Constants.signInId);
    private By hotelLinkText = By.linkText(Constants.hotelsLinkText);
    private By flightLinkText = By.linkText(Constants.flightsLinkText);




    static {
        try {
            compositeConfiguration = new CompositeConfiguration();
            compositeConfiguration.addConfiguration(new SystemConfiguration());
        } catch (org.apache.commons.configuration.ConfigurationException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void waitFor(int durationInMilliSeconds){
        try
        {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void initializeDriver() throws IOException, InterruptedException{
        if (PlatformUtil.isMac()){
            System.setProperty("webdriver.chrome.driver","chromedriver");
        }
        else if(PlatformUtil.isWindows()){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }if (PlatformUtil.isLinux()){
            System.setProperty("webdriver.chrome.driver","chromedriver_linu");
        }
        Thread.sleep(500);

        HashMap<String,Object> preferences = new HashMap<String, Object>();
        preferences.put("profile.default_content_settings_popups",0);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs",preferences);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("disable-extensions");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        cap.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        webDriver = new ChromeDriver(cap);
    }

    public void redirect_to_YourTrips(){
        WebElement webElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated(tripsLink));
        webElement.click();
    }

    public void redirect_to_SignInPage(){
        WebElement webElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated(signInIdLink));
        webElement.click();
    }

    public void redirect_to_HotelSearchPage(){
        WebElement webElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated(hotelLinkText));
        webElement.click();
    }

    public void redirect_to_FLightSearchPage(){
        WebElement webElement = new WebDriverWait(webDriver,5)).until(ExpectedConditions.presenceOfElementLocated(flightLinkText));
        webElement.click();
    }
}
