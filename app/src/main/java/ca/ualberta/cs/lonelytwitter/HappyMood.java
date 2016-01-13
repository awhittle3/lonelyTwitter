package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by awhittle on 1/12/16.
 */
public class HappyMood extends Mood {

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String formatMessage(String message) {
        return ":) " + message;
    }
}
