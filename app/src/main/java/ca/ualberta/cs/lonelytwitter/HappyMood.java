package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Mood representing happiness
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
