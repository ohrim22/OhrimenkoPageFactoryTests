package infrastructure.logging;

public interface AbstractLogger {
    public static final String WELCOME_MESSAGE = "Test suite started at %s";
    public static final String FINAL_MESSAGE = "Test suite finished at %s";

    void log(String msg);

    void atFinish();

    void atStart();


}
