package my.application.client.panel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import my.application.client.utils.FormSizeUtil;
import my.application.client.ImgResources;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/31/12
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderPanel extends FlowPanel {

    public static final String CUSTOM_SOFTWARE_DEVELOPMENT_COMPANY = "Custom Software Development Company";

    public HeaderPanel() {
        initPanel();
    }

    public HeaderPanel(int headerSize) {
        setHeight(FormSizeUtil.pixelFormat(headerSize));
        initPanel();
    }

    private void initPanel() {
        addStyleName("dartHeader");
        Label csdc = new Label(CUSTOM_SOFTWARE_DEVELOPMENT_COMPANY);
        csdc.setStyleName("dartH1");

        Image logo = new Image(ImgResources.INSTANCE.logo());
        logo.setStyleName("dartLogo");

        add(csdc);
        add(logo);
    }
}
