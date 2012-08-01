package my.application.client.panel;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import my.application.client.common.Menu;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuPanel extends VerticalPanel {

    //TODO сделать паттерном Наблюдатель (Observable)
    class MenuLabel extends Label {
        MenuLabel(Menu point) {
            setText(point.title());
        }
    }

    public MenuPanel() {
        setHeight("100%");

        VerticalPanel vp = new VerticalPanel();
        add(vp);

        vp.setSpacing(20);
        vp.add(new MenuLabel(Menu.ADD_COMMENT));
        vp.add(new MenuLabel(Menu.EDIT_COMMENT));
        vp.add(new MenuLabel(Menu.DEL_COMMENT));
        vp.add(new MenuLabel(Menu.SHOW_ALL));
    }
}
