package infrastructure.utils;

import java.util.Random;

public class StringUtils {

    public String alphabet = "abcdefghijklmnopqrstuvwxyx";
    public String nums = "0123456789";

    public enum StringType {
        alphabet("alpha"),
        alphanumeric("alphanumeric"),
        numeric("numeric");

        private final String type;

        StringType(String type) {
            this.type = type;
        }
    }

    String mode = StringType.values().toString();

    public String stringGenerator(StringType type, int length) {

        String tempString = "";

        if (type.type.equals("alpha")) {
            tempString = alphabet;
        } else if (type.type.equals("alphanumeric")) {
            tempString = alphabet + nums;
        } else if (type.type.equals("numeric")) {
            tempString = nums;
        }
        Random rand = new Random();

        StringBuilder build = new StringBuilder();

        for (int i = 0; i < length; i++) {
            build.append(tempString.charAt(rand.nextInt(tempString.length())));
        }

        return build.toString();

    }

}
