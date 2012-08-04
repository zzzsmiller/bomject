package my.application.client.form;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import my.application.client.common.Menu;
import my.application.client.common.MessageFacotry;
import my.application.client.i18n.GreetingFormMessages;
import my.application.client.widgets.ErrorLabel;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/3/12
 * Time: 8:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingForm extends FormPanel {

    private FormData formData;
    private TextField author;
    private TextField text;
    private DateField date;
    private Button buttonA;
    private Button buttonB;
    private GreetingFormMessages msgs;

    public GreetingForm(Menu point) {
        formData = new FormData();
        initForm();
        setMode(point);
    }

    private void initForm() {
        setSize(400, 300);
//        setFieldWidth(50);

        msgs = MessageFacotry.getGreetingFormMessages();

        author = new TextField();
        author.setFieldLabel(msgs.author());
        add(author, formData);

        text = new TextField();
        text.setFieldLabel(msgs.text());
        add(text, formData);

        date = new DateField();
        date.setFieldLabel(msgs.date());
        date.setFormatValue(true);
        date.setEnabled(false);
        add(date, formData);

        buttonA = new Button();
        buttonB = new Button();
        add(buttonA);
        add(buttonB);
    }

    private void setMode(Menu point) {
        switch (point) {
            case ADD_COMMENT:
                buttonA.setText(msgs.add());
                buttonB.setText(msgs.cancel());
                date.setVisible(false);
                break;
            case EDIT_COMMENT:
                buttonA.setText(msgs.save());
                buttonB.setText(msgs.cancel());
                date.setVisible(true);
                break;
            case DEL_COMMENT:
                buttonA.setText(msgs.del());
                buttonB.setText(msgs.update());
                date.setVisible(false);
                break;
        }
    }


}
