package my.application.client.common;

import com.google.gwt.core.client.GWT;
import my.application.client.MenuMessages;
import my.application.client.Messages;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/1/12
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageFacotry {

    private static Messages messages;

    private static MenuMessages menuMessages;

    public static Messages getMessages() {
        if (messages == null) {
            messages = GWT.create(Messages.class);
        }
        return messages;
    }

    public static MenuMessages getMenuMessages() {
        if (menuMessages == null) {
            menuMessages = GWT.create(MenuMessages.class);
        }
        return menuMessages;
    }
}
