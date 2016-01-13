package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by awhittle on 1/12/16.
 */
public abstract class Tweet{
    protected Date date;
    protected String message;
    protected ArrayList<Mood> myMoods;

    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
