package infrastructure.config;

import infrastructure.wdm.BrowserType;
import infrastructure.wdm.PlatformType;
import infrastructure.wdm.RunOn;

public class ConfigurationManager {

    private static ConfigurationManager instance;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();

        return instance;
    }

    public String getEnvironmentVariableOrDefault(String envVar, String defaultValue) {
        String currentValue = System.getenv(envVar);
        return currentValue == null || currentValue.isEmpty() ?
                defaultValue : currentValue;

    }

    public BrowserType getTestBrowser() {
        return BrowserType.valueOf(getEnvironmentVariableOrDefault("browser", "chrome").toUpperCase());
    }

    public String getTestEnvironment() {
        return getEnvironmentVariableOrDefault("environment", "qa_env");
    }

    public String getCurrentEnvironment() {
        return getEnvironmentVariableOrDefault("runEnv", "local");
    }

    public RunOn getRunOn() {
        return RunOn.valueOf(getEnvironmentVariableOrDefault("runOn", "local").toUpperCase());
    }

    public String getRemouteHubUrl() {return getEnvironmentVariableOrDefault("HubUrl", "hub-cloud.browserstack.com");
    }

    public PlatformType getTestPlatform() { return PlatformType.valueOf(getEnvironmentVariableOrDefault("Platform", "DESCKTOP"));
    }

}
