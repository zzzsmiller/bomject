package my.application.client.form;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.HTML;


/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/22/12
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrettingsForm extends TabPanel {

    /*public GrettingsForm() {
        this(2.5, EM);
    }*/
//    private GrettingsForm instance;

    public GrettingsForm() {

        initTabBar();

        setAnimScroll(true);
        setBorders(true);
//        TabPanelMessages message = new TabPanelMessages();
//        message.setCloseText("Некое сообщение");
//        setMessages(message);
        setDeferHeight(false);
        setHeight("200px");

        /*getParent().addHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent event) {
                setHeight(FormSizeUtil.pixelFormat(event.getHeight()));
                setWidth(FormSizeUtil.pixelFormat(event.getWidth()));
            }
        }, ResizeEvent.getType());*/
    }

    private void initTabBar() {
        TabItem tabItem = new TabItem();

        tabItem.setText("Просмотр всех комментариев");
        tabItem.scrollIntoView(this);
        for (int i = 0; i < 50; i++) {
            tabItem.add(new HTML("bla-bla-bla"));
        }
        add(tabItem);

        tabItem = new TabItem("Добавить комментарий");
        tabItem.addText("blu-blu-blu");
        add(tabItem);

        tabItem = new TabItem("Редактировать комментарий");
        tabItem.addText("bli-bli-bli");
        add(tabItem);

        tabItem = new TabItem("Удалить комментарий");
        tabItem.addText("ble-ble-ble");
        add(tabItem);

        /*add(new HTML("bla-bla-bla"), "Просмотр всех комментариев");
        add(new HTML("blu-blu-blu"), "Добавить комментарий");
        add(new HTML("bli-bli-bli"), "Редактировать комментарий");
        add(new HTML("ble-ble-ble"), "Удалить комментарий");
*/

    }

    @Override
    protected void onAttach() {
        super.onAttach();
//        setSize(getParent().getOffsetWidth(), getParent().getOffsetHeight());
        getParent().addHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent event) {
                setSize(event.getWidth(), event.getHeight());
            }
        }, ResizeEvent.getType());
    }

    /*@Override
    protected void onResize(int width, int height) {
        super.onResize(width, height);
        setSize(getParent().getOffsetWidth(), getParent().getOffsetHeight());
    }*/


}
