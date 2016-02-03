package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Tweet of high importance
 */
public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    public ImportantTweet(String message) {
        super(message);
        isImportant();
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public String getMessage() {
        return "***" + this.message + "***";
    }

    public Date getDate() {
        return null;
    }
}
