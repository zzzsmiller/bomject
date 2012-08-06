package my.application.server.service;

import my.application.client.service.GreetingService;
import my.application.server.service.persistence.GreetingMapper;
import my.application.shared.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/5/12
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("greetingService2")
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    GreetingMapper mapper;

    @Override
    public List<Greeting> getAllGreetings() {
        return mapper.getAllGreetings();
//        return new ArrayList<Greeting>();
    }

    @Override
    public void addGreeting(Greeting greeting) {
        mapper.addGreeting(greeting);
    }

    @Override
    public void removeGreeting(int id) {
        mapper.removeGreeting(id);
    }

    @Override
    public Greeting getGreeting(int id) {
        return mapper.getGreeting(id);
//        return null;
    }

    @Override
    public List<Greeting> getGreetingByAuthor(String author) {
        return mapper.getGreetingByAuthor(author);
//        return null;
    }

    @Override
    public String test() {
        return "test works";
    }
}
