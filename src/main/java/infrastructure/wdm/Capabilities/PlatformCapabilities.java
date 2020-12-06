package infrastructure.wdm.Capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities {
    public static Capabilities mobileCapabilities() {
        ChromeOptions mobileOptions = new ChromeOptions();
        mobileOptions.setCapability("name", "\"Bstack-[Junit] Sample Test);");
        mobileOptions.setCapability("browserstack.debug", true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(mobileOptions);
        return desiredCapabilities;

    }

    public static Capabilities descktopCapabilities() {
        ChromeOptions descktopCapabilities = new ChromeOptions();
        descktopCapabilities.setCapability("name", "\"Bstack-[Junit] Sample Test);");
        descktopCapabilities.setCapability("browserstack.debug", true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(descktopCapabilities);
        return desiredCapabilities;

    }




}
