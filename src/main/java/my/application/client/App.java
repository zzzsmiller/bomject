package my.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import my.application.client.form.GrettingsForm;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        RootPanel.get().setStyleName("bodyStyle");

        /*VerticalPanel mainPanel= new VerticalPanel();
        mainPanel.setHeight("80%");
        mainPanel.add(new Label("TEST"));*/

        /*DockLayoutPanel dockPanel = new DockLayoutPanel(Style.Unit.PCT);

//        RootPanel.get().add(new Label("TEST"));
        dockPanel.setHeight("800px");
        dockPanel.setWidth("100%");
*/
        LayoutPanel tpanel = new LayoutPanel();
        tpanel.setStyleName("headerPanel");
        tpanel.add(new Label("Шапка"));
//        dockPanel.addNorth(tpanel, 20);
        RootPanel.get("header").add(tpanel);
        RootPanel.get("header").add(new Label("header"));

        tpanel = new LayoutPanel();
        tpanel.setStyleName("menuPanel");
        tpanel.add(new Label("Меню"));
//        dockPanel.addWest(tpanel, 10);
        RootPanel.get("leftMenu").add(tpanel);
        RootPanel.get("leftMenu").add(new Label("leftMenu"));

        tpanel = new LayoutPanel();
        tpanel.setStyleName("footerPanel");
        tpanel.add(new Label("Подвал"));
//        dockPanel.addSouth(tpanel, 30);
        RootPanel.get("footer").add(tpanel);
        RootPanel.get("footer").add(new Label("footer"));

//        dockPanel.add(new GrettingsForm());
        RootPanel.get("content").add(new GrettingsForm());
        RootPanel.get("content").add(new Label("content"));

        /*mainPanel.add(dockPanel);
        mainPanel.add(new Label("TEST2"));*/
//        RootPanel.get().add(dockPanel);

//        RootPanel.get().add(new Label("TEST2"));

    }
}
