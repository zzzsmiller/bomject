package my.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import my.application.client.form.GrettingsForm;
import my.application.client.utils.FormSizeUtil;

import static com.google.gwt.dom.client.Style.Unit.PX;


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

        final DockLayoutPanel dockPanel = new DockLayoutPanel(PX);

        setSizeDockPanel(dockPanel);
        LayoutPanel tpanel = new LayoutPanel();
        tpanel.setStyleName("headerPanel");
        HorizontalPanel hpanel = new HorizontalPanel();
        tpanel.add(hpanel);
        hpanel.add(new Label("Шапка"));
        hpanel.add(new Button("Кнопка"));
        dockPanel.addNorth(tpanel, 80);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("footerPanel");
        tpanel.add(new Label("Подвал"));
        dockPanel.addSouth(tpanel, 50);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("menuPanel");
        tpanel.add(new Label("Меню"));
        dockPanel.addWest(tpanel, 220);

        dockPanel.add(new GrettingsForm());

        dockPanel.addHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent event) {
                int i = 1;
            }
        }, ResizeEvent.getType());

        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                setSizeDockPanel(dockPanel);
            }
        });

        RootPanel.get().add(dockPanel);
    }

    private void setSizeDockPanel(DockLayoutPanel dockPanel) {
        dockPanel.setHeight(FormSizeUtil.pixelFormat(Window.getClientHeight()));
        dockPanel.setWidth(FormSizeUtil.pixelFormat(Window.getClientWidth()));
    }


}
