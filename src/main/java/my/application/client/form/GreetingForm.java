package my.application.client.form;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import my.application.client.common.*;
import my.application.client.i18n.GreetingFormMessages;
import my.application.shared.entity.Greeting;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/3/12
 * Time: 8:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingForm extends FormPanel {

    private FormData formLayout;
    private TextField author;
    private TextField text;
    private DateField date;
    private Button buttonA;
    private Button buttonB;
    private GreetingFormMessages msgs;
    private Greeting greeting;
    private GreetingForm instance;

    private class SaveSelectionListener extends SelectionListener<ButtonEvent> {
        @Override
        public void componentSelected(ButtonEvent ce) {
            ServiceFactory.getGreetingService().addGreeting(getFormData(), new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    ErrorWindow.showError(caught);
                }

                @Override
                public void onSuccess(Void result) {
                    SuccessLabel.addLabel(instance);
                    buttonB.setEnabled(true);
                }
            });
        }
    }

    private class ClearSelectionListener extends SelectionListener<ButtonEvent> {
        @Override
        public void componentSelected(ButtonEvent ce) {
            author.clear();
            text.clear();
            date.clear();
            ce.getButton().setEnabled(false);
        }
    }

    private Greeting getFormData() {
        Greeting greeting = new Greeting();
        greeting.setAuthor((String) author.getValue());
        greeting.setText((String) text.getValue());
        greeting.setDate(date.getValue());
        return greeting;
    }

    public GreetingForm(Menu point) {
        formLayout = new FormData();
        initForm();
        setMode(point);
        instance = this;
    }

    private void initForm() {
        setSize(800, 400);
//        setFieldWidth(50);

        msgs = MessageFacotry.getGreetingFormMessages();

        author = new TextField();
        author.setFieldLabel(msgs.author());
        author.setEmptyText("Введите ваше имя");
        author.setMinLength(1);
        add(author, formLayout);

        text = new TextArea();
        text.setFieldLabel(msgs.text());
        text.setEmptyText("Введите текст сообщения");
        text.setMinLength(1);
        add(text, formLayout);

        date = new DateField();
        date.setFieldLabel(msgs.date());
        date.setFormatValue(true);
        date.setEnabled(false);
        add(date, formLayout);

        buttonA = new Button();
        buttonB = new Button();
        add(buttonA);
        add(buttonB);
    }

    private void setMode(Menu point) {
        switch (point) {
            case ADD_COMMENT:
                buttonA.setText(msgs.add());
                buttonA.addSelectionListener(new SaveSelectionListener());
                buttonB.setText(msgs.cancel());
                buttonB.setEnabled(false);
                buttonB.addSelectionListener(new ClearSelectionListener());
                date.setVisible(false);
                break;
            case EDIT_COMMENT:
                buttonA.setText(msgs.save());
//                buttonA.addSelectionListener(new SaveSelectionListener());
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
