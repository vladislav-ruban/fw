package Utils;

public class Converters {
    public static int stringCutAndParseToInt(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]", ""));
    }
}
