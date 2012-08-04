package my.application.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import my.application.shared.entity.Greeting;

import java.util.List;

public interface GreetingServiceAsync {
    void getGreetings(AsyncCallback<List<Greeting>> async);
}
