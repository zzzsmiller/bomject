package my.application.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import my.application.shared.entity.Greeting;

import java.util.List;

public interface GreetingServiceAsync {

    void getAllGreetings(AsyncCallback<List<Greeting>> async);

    void addGreeting(Greeting greeting, AsyncCallback<Void> async);

    void removeGreeting(int id, AsyncCallback<Void> async);

    void getGreeting(int id, AsyncCallback<Greeting> async);

    void getGreetingByAuthor(String author, AsyncCallback<List<Greeting>> async);

    void test(AsyncCallback<String> async);
}
