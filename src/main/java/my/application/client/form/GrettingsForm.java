package my.application.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.ui.HTML;
import my.application.client.common.Menu;


/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/22/12
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrettingsForm extends TabPanel {

    public GrettingsForm() {
        initTabBar();
        addStyleName("contentPanel");
        setAnimScroll(true);
        setTabScroll(true);
    }

    private void initTabBar() {
        TabItem tabItem = new TabItem();

        tabItem.setText(Menu.SHOW_ALL.title());
//        tabItem.scrollIntoView(this);
        tabItem.setScrollMode(Style.Scroll.AUTOY);
        for (int i = 0; i < 1000; i++) {
            tabItem.add(new HTML("bla-bla-bla"));
        }
        add(tabItem);

        tabItem = new TabItem(Menu.ADD_COMMENT.title());
        tabItem.addText("blu-blu-blu");
        add(tabItem);

        tabItem = new TabItem(Menu.EDIT_COMMENT.title());
        tabItem.addText("bli-bli-bli");
        add(tabItem);

        tabItem = new TabItem(Menu.DEL_COMMENT.title());
        tabItem.addText("ble-ble-ble");
        add(tabItem);

    }

}
