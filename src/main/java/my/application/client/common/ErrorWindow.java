package my.application.client.common;

import com.extjs.gxt.ui.client.widget.Window;
import my.application.client.widgets.ErrorLabel;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorWindow extends Window {

    private static ErrorWindow instance;

    private ErrorWindow() {
        instance = this;
    }

    public static void showError() {
        getInstance().add(new ErrorLabel(MessageFacotry.getSystemMessages().errorLabel()));
        getInstance().show();
    }

    public static void showError(Throwable caught) {
        getInstance().add(new ErrorLabel(caught.getMessage()));
        getInstance().show();
    }

    private static ErrorWindow getInstance() {
        if (instance == null) {
            instance = new ErrorWindow();
        }
        return instance;
    }
}
