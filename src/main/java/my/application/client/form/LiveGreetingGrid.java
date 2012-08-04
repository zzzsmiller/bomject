package my.application.client.form;

import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import my.application.client.common.MessageFacotry;
import my.application.client.i18n.GreetingFormMessages;
import my.application.shared.entity.Greeting;

import java.util.ArrayList;
import java.util.List;

import static com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat.DATE_TIME_FULL;

/**
 * @deprecated not finished. CompileError
 */
@Deprecated
public class LiveGreetingGrid extends Grid {

    public LiveGreetingGrid() {
        setBorders(true);
        setLoadMask(true);
        setStripeRows(true);
        initGrid();
    }

    private void initGrid() {
        ColumnModel columnModel = initColumnModel();
        ListStore<ModelData> store = initStore();
    }

    private ListStore<ModelData> initStore() {
        DataProxy proxy = new RpcProxy<Greeting>() {
            @Override
            protected void load(Object loadConfig, AsyncCallback<Greeting> callback) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        DataReader reader;
//        BasePagingLoader<PagingLoadResult<ModelData>> loader =
//                new BasePagingLoader<PagingLoadResult<ModelData>>(proxy, reader);
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private ColumnModel initColumnModel() {
        GreetingFormMessages msgs = MessageFacotry.getGreetingFormMessages();

        ColumnConfig author = new ColumnConfig("author", msgs.author(), 100);
        ColumnConfig text = new ColumnConfig("text", msgs.text(), 300);
        ColumnConfig date = new ColumnConfig("date", msgs.date(), 150);
        date.setDateTimeFormat(DateTimeFormat.getFormat(DATE_TIME_FULL));

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
        columns.add(author);
        columns.add(text);
        columns.add(date);

        ColumnModel columnModel = new ColumnModel(columns);
        return columnModel;
    }
}
