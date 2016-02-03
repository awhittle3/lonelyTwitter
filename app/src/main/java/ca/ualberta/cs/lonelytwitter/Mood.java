package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Object for representing a mood
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
