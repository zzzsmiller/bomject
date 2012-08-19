package my.application.client.panel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import my.application.client.common.Menu;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuPanel extends VerticalPanel implements MenuSubject, MenuObserver {

    private HashSet<MenuObserver> observers = new HashSet<MenuObserver>();

    private MenuLabel selectedItem;

    private HashMap<Menu, MenuLabel> menuItems = new HashMap<Menu, MenuLabel>();

    class MenuLabel extends Label {
        private Menu point;

        class MenuLabelHandler implements ClickHandler {
            private MenuLabel menuItem;

            MenuLabelHandler(MenuLabel menuItem) {
                this.menuItem = menuItem;
            }

            @Override
            public void onClick(ClickEvent event) {
                selectedItem.removeStyleName("menuItemSelected");
                selectedItem = menuItem;
                selectedItem.addStyleName("menuItemSelected");
                notifyObservers();
            }
        }

        MenuLabel(Menu point) {
            setText(point.title());
            setStyleName("menuItem");
            this.point = point;
            addClickHandler(new MenuLabelHandler(this));
        }

        public Menu getPoint() {
            return point;
        }
    }

    public MenuPanel() {
        setHeight("100%");

        VerticalPanel vp = new VerticalPanel();
        add(vp);

        vp.setSpacing(20);

        for (Menu menu : Menu.values()) {
            MenuLabel menuLabel = new MenuLabel(menu);
            menuItems.put(menu, menuLabel);
            vp.add(menuLabel);
        }
        selectedItem = menuItems.get(Menu.SHOW_ALL);
    }

    public void setSelected(Menu menuItem) {
        selectedItem.removeStyleName("menuItemSelected");
        MenuLabel menuLabel = menuItems.get(menuItem);
        menuLabel.addStyleName("menuItemSelected");
        selectedItem = menuLabel;
    }

    @Override
    public void update(Menu menuItem) {
        setSelected(menuItem);
    }

    @Override
    public void registerObserver(MenuObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MenuObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Menu point;
        if (selectedItem == null) {
            point = Menu.ADD_COMMENT;
        } else {
            point = selectedItem.getPoint();
        }
        for (MenuObserver observer : observers) {
            observer.update(point);
        }
    }
}
