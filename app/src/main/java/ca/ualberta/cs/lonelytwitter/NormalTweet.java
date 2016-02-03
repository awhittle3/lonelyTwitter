package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Normal Tweet for regular tweets
 */
public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    public String getMessage() {
        return null;
    }

    public Date getDate() {
        return null;
    }
}
