package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by awhittle on 1/12/16.
 */
public abstract class Mood {
    protected Date date;

    public Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String formatMessage(String message);
}
