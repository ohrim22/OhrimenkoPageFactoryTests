package infrastructure;

import infrastructure.config.ConfigurationManager;

public class TestServer {
    public static String getUrl() {
        String testEnvironment = ConfigurationManager.getInstance().getTestEnvironment();

        switch (testEnvironment) {
            case "qa_env":
                return "https://bugsmanager.herokuapp.com/";
            case "prod_env":
                return "http://prod.env.mysite.com";
            case "staging_env":
                return "http://staging.env.mysite.com";
            default:
                return "";
        }
    }
}
