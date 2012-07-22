package my.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.widget.client.TextButton;import my.application.client.form.GrettingsForm;



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

    private DockLayoutPanel dockPanel = new DockLayoutPanel(Style.Unit.PCT);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get().add(new Label("TEST"));



        LayoutPanel tpanel = new LayoutPanel();
        tpanel.setStyleName("headerPanel");
        tpanel.add(new Label("Шапка"));
        dockPanel.addNorth(new Label("Шапка"), 20);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("menuPanel");
        tpanel.add(new Label("Меню"));
        dockPanel.addWest(tpanel, 30);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("footerPanel");
        tpanel.add(new Label("Меню"));
        dockPanel.addSouth(tpanel, 20);

        dockPanel.add(new GrettingsForm());

        RootPanel.get().add(dockPanel.asWidget());

        RootPanel.get().add(new Label("TEST2"));

    }
}
