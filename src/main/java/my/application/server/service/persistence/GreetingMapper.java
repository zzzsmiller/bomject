package my.application.server.service.persistence;

import com.google.gwt.i18n.client.Messages;
import my.application.shared.entity.Greeting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/5/12
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GreetingMapper {

    String SELECT_ALL = "SELECT * FROM greetings ORDER BY date DESC";
    String INSERT = "INSERT INTO greetings (author, text) VALUES (#{author}, #{text})";
    String DELETE = "DELETE FROM greetings WHERE id=#{id}";
    String SELECT_BY_ID = "SELECT * FROM greetings WHERE id=#{id}";
    String SELECT_BY_AUTHOR = "SELECT * FROM greetings WHERE upper(author)=upper(#{author})";

    @Select(SELECT_ALL)
    List<Greeting> getAllGreetings();

    @Insert(INSERT)
    void addGreeting(Greeting greeting);

    @Delete(DELETE)
    void removeGreeting(int id);

    @Select(SELECT_BY_ID)
    Greeting getGreeting(int id);

    @Select(SELECT_BY_AUTHOR)
    List<Greeting> getGreetingByAuthor(String author);
}
