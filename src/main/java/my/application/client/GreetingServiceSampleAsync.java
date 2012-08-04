package my.application.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface GreetingServiceSampleAsync {
    void greetServer(String name, AsyncCallback<String> async);
}
