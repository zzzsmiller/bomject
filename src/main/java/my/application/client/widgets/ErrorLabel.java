package my.application.client.widgets;

import com.extjs.gxt.ui.client.widget.Label;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/3/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorLabel extends Label {
    public ErrorLabel() {
        setStyleName("errorLabel");
        setBorders(true);
    }

    public ErrorLabel(String text) {
        super(text);
    }
}
