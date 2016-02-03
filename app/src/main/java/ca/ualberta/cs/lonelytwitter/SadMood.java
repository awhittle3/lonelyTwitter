package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Mood representing sadness
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
