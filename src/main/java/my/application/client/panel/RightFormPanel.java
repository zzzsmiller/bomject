package my.application.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/31/12
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class RightFormPanel {
    interface RightFormPanelUiBinder extends UiBinder<HTMLPanel, RightFormPanel> {
    }

    private static RightFormPanelUiBinder ourUiBinder = GWT.create(RightFormPanelUiBinder.class);

    public RightFormPanel() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);

    }
}