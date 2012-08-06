package my.application.client.common;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/6/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuccessLabel extends Label {

    static SuccessLabel instance;
    public static final String DEFAULT_MESSAGE = "Данные успешно сохранены";

    public SuccessLabel() {
        instance = this;
    }

    public static void addLabel(final LayoutContainer container, String s) {
        getInstance().setText(s);
        container.add(getInstance());
        getInstance().addListener(Events.OnClick, new Listener<BaseEvent>() {
            @Override
            public void handleEvent(BaseEvent be) {
                container.remove(getInstance());
                instance = null;
            }
        });
    }

    public static void addLabel(LayoutContainer container) {
        addLabel(container, DEFAULT_MESSAGE);

    }

    public static SuccessLabel getInstance() {
        if (instance == null) {
            instance = new SuccessLabel();
        }
        return instance;
    }
}
