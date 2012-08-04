package my.application.shared.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 8/4/12
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Greeting implements Serializable {

    private static final long serialVersionUID = 586687042133180491L;

    private String author;

    private String text;

    private Date date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
