package my.application.client.form;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget; /**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/22/12
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrettingsForm extends TabLayoutPanel {

    public GrettingsForm() {
        this(100, Style.Unit.PCT);
    }

    public GrettingsForm(double barHeight, Style.Unit barUnit) {
        super(barHeight, barUnit);
        setStyleName("contentPanel");
        initTabBar();
    }

    private void initTabBar() {
        add(new HTML("bla-bla-bla"), "Просмотр всех комментариев");
        add(new HTML("blu-blu-blu"), "Добавить комментарий");
        add(new HTML("bli-bli-bli"), "Редактировать комментарий");
        add(new HTML("ble-ble-ble"), "Удалить комментарий");
    }
}
