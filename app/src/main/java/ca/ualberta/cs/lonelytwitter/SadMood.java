package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by awhittle on 1/12/16.
 */
public class SadMood extends Mood {

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String formatMessage(String message) {
        return ":( " + message;
    }
}
