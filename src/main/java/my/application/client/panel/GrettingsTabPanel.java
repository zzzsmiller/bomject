package my.application.client.panel;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.ui.HTML;
import my.application.client.common.Menu;
import my.application.client.common.MessageFacotry;
import my.application.client.form.GreetingForm;
import my.application.client.form.GreetingGrid;
import my.application.client.form.LiveGreetingGrid;
import my.application.client.widgets.ErrorLabel;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/22/12
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrettingsTabPanel extends TabPanel implements MenuObserver, MenuSubject {

    private HashMap<Menu, MenuTabItem> tabs = new HashMap<Menu, MenuTabItem>();
    private HashSet<MenuObserver> observers = new HashSet<MenuObserver>();

    class MenuTabItem extends TabItem {
        private Menu point;

        MenuTabItem(Menu point) {
            this.point = point;
            setText(point.title());
            if (point == null) {
                add(new ErrorLabel(MessageFacotry.getSystemMessages().errorLabel()));
            } else if (Menu.SHOW_ALL.equals(point)) {
                add(new GreetingGrid());
            } else {
                add(new GreetingForm(point));
            }
        }

        public Menu getPoint() {
            return point;
        }
    }

    public GrettingsTabPanel() {
        initTabBar();
        addStyleName("contentPanel");
        setAnimScroll(true);
        setTabScroll(true);
        addListener(Events.Select, new Listener<BaseEvent>() {
            @Override
            public void handleEvent(BaseEvent be) {
                notifyObservers();
            }
        });
    }

    private void initTabBar() {
        MenuTabItem tabItem = new MenuTabItem(Menu.SHOW_ALL);
        tabs.put(Menu.SHOW_ALL, tabItem);
        tabItem.setScrollMode(Style.Scroll.AUTOY);
        for (int i = 0; i < 1000; i++) {
            tabItem.add(new HTML("bla-bla-bla"));
        }
        add(tabItem);

        tabItem = new MenuTabItem(Menu.ADD_COMMENT);
        tabs.put(Menu.ADD_COMMENT, tabItem);
        tabItem.addText("blu-blu-blu");
        add(tabItem);

        tabItem = new MenuTabItem(Menu.EDIT_COMMENT);
        tabs.put(Menu.EDIT_COMMENT, tabItem);
        tabItem.addText("bli-bli-bli");
        add(tabItem);

        tabItem = new MenuTabItem(Menu.DEL_COMMENT);
        tabs.put(Menu.DEL_COMMENT, tabItem);
        tabItem.addText("ble-ble-ble");
        add(tabItem);
    }

    @Override
    public void update(Menu menuItem) {
        setSelection(tabs.get(menuItem));
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
        for (MenuObserver observer : observers) {
            observer.update(((MenuTabItem)getSelectedItem()).getPoint());
        }
    }


}
