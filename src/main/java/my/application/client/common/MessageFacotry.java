package my.application.client.common;

import com.google.gwt.core.client.GWT;
import my.application.client.Messages;
import my.application.client.i18n.GreetingFormMessages;
import my.application.client.i18n.MenuMessages;
import my.application.client.i18n.SystemMessages;

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

    private static GreetingFormMessages greetingFormMessages;

    private static SystemMessages systemMessages;

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

    public static GreetingFormMessages getGreetingFormMessages() {
        if (greetingFormMessages == null) {
            greetingFormMessages = GWT.create(GreetingFormMessages.class);
        }
        return greetingFormMessages;
    }

    public static SystemMessages getSystemMessages() {
        if (systemMessages == null) {
            systemMessages = GWT.create(SystemMessages.class);
        }
        return systemMessages;
    }
}
