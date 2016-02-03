package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet and its metadata
 */
public abstract class Tweet {
    /**
     * Date the tweet was tweeted
     */
    protected Date date;

    /**
     * Message the tweet contains
     */
    protected String message;

    /**
     * Returns level of importance
     * @return True if important, false otherwise
     */
    public abstract Boolean isImportant();

    /**
     * Constructor
     * @param date date of tweet
     * @param message message of tweet
     */
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    /**
     * Constructor
     * @param message message of tweet
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}