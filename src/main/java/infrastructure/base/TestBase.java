package infrastructure.base;

import infrastructure.TestServer;
import infrastructure.config.ConfigurationManager;
import infrastructure.logging.AbstractLogger;
import infrastructure.logging.FileTestLogger;
import infrastructure.logging.StdTestLogger;
import infrastructure.wdm.DefaultWebDriverManager;
import infrastructure.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TestBase {
    private WebDriverManager wdm;
    protected TestServer server;
    protected AbstractLogger logger;

    private WebDriver driver;

    public void setup() {
        wdm = new DefaultWebDriverManager();
        logger = getLogger();
        driver = wdm.getDriver();
        server = new TestServer();
        String url = server.getUrl();
        logger.log(url);
        beforeTest();

    }

    public void tearDown() {
        wdm.destroyBrowser(driver);
        afterTest();

    }

    public void beforeTest() {

    }

    public void afterTest(){
        logger.atFinish();

    }

    public AbstractLogger getLogger() {
       return ConfigurationManager.getInstance().getCurrentEnvironment().equals("local")
               ? new StdTestLogger() : new FileTestLogger();
    }


}
