package my.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import my.application.client.panel.GrettingsTabPanel;
import my.application.client.panel.*;
import my.application.client.panel.HeaderPanel;
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

    public static final int HEADER_SIZE = 123;
    public static final int FOOTER_SIZE = 50;
    public static final int MENU_SIZE = 220;

    private final DockLayoutPanel dockPanel = new DockLayoutPanel(PX);

    private Widget contentPanel;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get().setStyleName("bodyStyle");

        setPanelsSize();

        LayoutPanel tpanel = new LayoutPanel();
        /*tpanel.setStyleName("headerPanel");
        HorizontalPanel hpanel = new HorizontalPanel();
        tpanel.add(hpanel);
        hpanel.add(new Label("Шапка"));
        hpanel.add(new Button("Кнопка"));*/
        dockPanel.addNorth(new HeaderPanel(HEADER_SIZE), HEADER_SIZE);

        tpanel = new LayoutPanel();
        tpanel.setStyleName("footerPanel");
        tpanel.add(new Label("Подвал"));
        dockPanel.addSouth(tpanel, FOOTER_SIZE);

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setStyleName("menuPanel");
        if (contentPanel != null) {
            ((GrettingsTabPanel) contentPanel).registerObserver(menuPanel);
            menuPanel.registerObserver((GrettingsTabPanel) contentPanel);
        }

        dockPanel.addWest(menuPanel, MENU_SIZE);

        dockPanel.add(contentPanel);

        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                setPanelsSize();
            }
        });

        RootPanel.get().add(dockPanel);
    }

    private void initContentPanel() {
        contentPanel = new GrettingsTabPanel();
    }

    private void setPanelsSize() {
        dockPanel.setHeight(FormSizeUtil.pixelFormat(Window.getClientHeight()));
        dockPanel.setWidth(FormSizeUtil.pixelFormat(Window.getClientWidth()));
        if (contentPanel == null) {
            initContentPanel();
        }
        contentPanel.setHeight(FormSizeUtil.pixelFormat(Window.getClientHeight() - HEADER_SIZE - FOOTER_SIZE));
        contentPanel.setWidth(FormSizeUtil.pixelFormat(Window.getClientWidth() - MENU_SIZE));
    }


}
