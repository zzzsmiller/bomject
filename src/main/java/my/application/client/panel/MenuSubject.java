package my.application.client.panel;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/2/12
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MenuSubject {

    void registerObserver(MenuObserver observer);

    void removeObserver(MenuObserver observer);

    void notifyObservers();
}
