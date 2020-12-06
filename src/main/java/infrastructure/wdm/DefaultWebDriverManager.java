package infrastructure.wdm;

import infrastructure.config.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager {
    @Override
    public WebDriver getDriver() {
        RunOn runOn = ConfigurationManager.getInstance().getRunOn();
        WebDriverFactory factory;
        switch (runOn) {
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case REMOTE:
                factory = new RemoteWebDriverFactory();
                break;
            case CLOUD:
                factory = new CloudWebDriverFactory();
                break;

            default:
                factory = new LocalWebDriverFactory();
        }

        return factory.create();
    }

    @Override
    public void destroyBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
