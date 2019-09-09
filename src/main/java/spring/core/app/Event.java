package spring.core.app;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private int id;
    private String message;
    private Date date;
    private DateFormat df;

    public Event() {
    }

    public Event(int id, String message, Date date, DateFormat df) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.df = df;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    @Override
    public String toString() {
        return "spring.core.app.Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
