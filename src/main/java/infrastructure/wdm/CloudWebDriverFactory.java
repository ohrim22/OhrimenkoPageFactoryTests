package infrastructure.wdm;

import infrastructure.config.ConfigurationManager;
import infrastructure.wdm.Capabilities.PlatformCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class CloudWebDriverFactory implements WebDriverFactory {
    DesiredCapabilities caps = new DesiredCapabilities();
    WebDriver driver;


    public WebDriver create() {

        String username = System.getenv("BrowserStack_USERNAME");
        String accessKey = System.getenv("BrowserStack_AccessKey");
        PlatformType platform = ConfigurationManager.getInstance().getTestPlatform();

        switch (platform) {
            case MOBILE:
                caps.merge(PlatformCapabilities.mobileCapabilities());
                break;
            case DESCKTOP:
                caps.merge(PlatformCapabilities.descktopCapabilities());
                break;
            default:
                throw new IllegalArgumentException(String.format("unable to create driver with type %S", platform));
        }

        try {
            driver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+ConfigurationManager.getInstance().getRemouteHubUrl()+"/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
