package my.application.client.form;


import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import my.application.client.common.ErrorWindow;
import my.application.client.common.MessageFacotry;
import my.application.client.common.ServiceFactory;
import my.application.client.i18n.GreetingFormMessages;
import my.application.shared.entity.Greeting;

import java.util.ArrayList;
import java.util.List;

import static com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat.DATE_TIME_FULL;
import static my.application.client.form.GreetingModel.*;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingGrid {

    private Grid<GreetingModel> grid;

    public Grid<GreetingModel> getGrid() {
        return grid;
    }

    public GreetingGrid() {
        grid = new Grid<GreetingModel>(new ListStore<GreetingModel>(), initColumnModel());
        grid.setSize(800, 400);
        grid.setBorders(true);
        updateData();
    }

    private ColumnModel initColumnModel() {
        GreetingFormMessages msgs = MessageFacotry.getGreetingFormMessages();

        ColumnConfig author = new ColumnConfig(AUTHOR, msgs.author(), 100);
        ColumnConfig text = new ColumnConfig(TEXT, msgs.text(), 300);
        ColumnConfig date = new ColumnConfig(DATE, msgs.date(), 150);
        date.setDateTimeFormat(DateTimeFormat.getFormat(DATE_TIME_FULL));

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
        columns.add(author);
        columns.add(text);
        columns.add(date);

        ColumnModel columnModel = new ColumnModel(columns);
        return columnModel;
    }

    private ListStore<GreetingModel> initStore(List<Greeting> data) {
        ListStore<GreetingModel> store = new ListStore<GreetingModel>();
        for (Greeting greeting : data) {
            store.add(new GreetingModel(greeting));
        }
        return store;
    }

    public void updateData() {
        ServiceFactory.getGreetingService().getAllGreetings(new AsyncCallback<List<Greeting>>() {
            @Override
            public void onFailure(Throwable caught) {
                ErrorWindow.showError(caught);
            }

            @Override
            public void onSuccess(List<Greeting> result) {
                updateData(result);
            }
        });
    }

    public void updateData(List<Greeting> data) {
        ListStore<GreetingModel> store = initStore(data);
        grid.reconfigure(store, grid.getColumnModel());
    }
}
