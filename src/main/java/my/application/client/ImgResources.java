package my.application.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 7/31/12
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ImgResources extends ClientBundle {

    public static final ImgResources INSTANCE = GWT.create(ImgResources.class);

    @Source("../resources/logo.jpg")
    ImageResource logo();
}
