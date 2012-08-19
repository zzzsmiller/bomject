package my.application.client.form;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.sun.xml.internal.bind.v2.model.core.ID;
import my.application.shared.entity.Greeting;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingModel extends BaseModel{
    private static final long serialVersionUID = 2083738721076028692L;
    public static final String AUTHOR = "author";
    public static final String TEXT = "text";
    public static final String DATE = "date";
    public static final String ID = "id";

    public GreetingModel(Greeting data) {
        set(AUTHOR, data.getAuthor());
        set(TEXT,data.getText());
        set(DATE, data.getDate());
        set(ID,data.getId());
    }


}
