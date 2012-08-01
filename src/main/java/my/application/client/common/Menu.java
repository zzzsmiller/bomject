package my.application.client.common;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 8/1/12
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Menu {

    SHOW_ALL(MessageFacotry.getMenuMessages().showAll()),
    ADD_COMMENT(MessageFacotry.getMenuMessages().addComment()),
    EDIT_COMMENT(MessageFacotry.getMenuMessages().editComment()),
    DEL_COMMENT(MessageFacotry.getMenuMessages().delComment());


    private String title;

    Menu(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
