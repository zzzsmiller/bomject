package my.application.client.utils;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 7/25/12
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormSizeUtil {

    public static String pixelFormat(Integer value) {
        StringBuilder stringValue = new StringBuilder("0px");
        try {
            stringValue.replace(0, 1, value.toString()).toString();
        } catch (NullPointerException ex) {
            // Logging
        }
        return stringValue.toString();
    }
}
