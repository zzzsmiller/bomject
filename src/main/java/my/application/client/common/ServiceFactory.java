package my.application.client.common;

import com.google.gwt.core.client.GWT;
import my.application.client.service.GreetingService;
import my.application.client.service.GreetingServiceAsync;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceFactory {

    private static GreetingServiceAsync greetingService;

    public static GreetingServiceAsync getGreetingService() {
        if (greetingService == null) {
            greetingService = GWT.create(GreetingService.class);
        }
        return greetingService;
    }
}
