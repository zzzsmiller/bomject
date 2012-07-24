package my.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
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

        final DockLayoutPanel dockPanel = new DockLayoutPanel(Style.Unit.PCT);

//        RootPanel.get().add(new Label("TEST"));
        setSizeDockPanel(dockPanel);
        LayoutPanel tpanel = new LayoutPanel();
        tpanel.setStyleName("headerPanel");
        tpanel.add(new Label("Шапка"));
        dockPanel.addNorth(tpanel, 20);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("menuPanel");
        tpanel.add(new Label("Меню"));
        dockPanel.addWest(tpanel, 30);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("footerPanel");
        tpanel.add(new Label("Подвал"));
        dockPanel.addSouth(tpanel, 20);

        dockPanel.add(new GrettingsForm());

        /*mainPanel.add(dockPanel);
        mainPanel.add(new Label("TEST2"));*/
        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                String height = new StringBuilder("px").insert(0, resizeEvent.getHeight()).toString();
                dockPanel.setHeight(height);
                String width = new StringBuilder("px").insert(0, resizeEvent.getWidth()).toString();
                dockPanel.setWidth(width);
            }
        });

        RootPanel.get().add(dockPanel);

//        RootPanel.get().add(new Label("TEST2"));



    }

    private void setSizeDockPanel(DockLayoutPanel dockPanel) {
        String height = new StringBuilder("px").insert(0, Window.getClientHeight()).toString();
        dockPanel.setHeight(height);
        String width = new StringBuilder("px").insert(0, Window.getClientWidth()).toString();
        dockPanel.setWidth(width);
    }


}
