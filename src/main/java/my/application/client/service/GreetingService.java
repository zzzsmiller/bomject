package my.application.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import my.application.shared.entity.Greeting;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@RemoteServiceRelativePath("service/greetingService")
public interface GreetingService extends RemoteService{

    List<Greeting> getGreetings();

}
