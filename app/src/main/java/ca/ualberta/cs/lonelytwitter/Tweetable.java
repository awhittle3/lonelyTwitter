package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Interface for objects being tweetable
 */
public interface Tweetable {
    /**
     * Gets the tweet's message
     * @return A message
     */
    public String getMessage();

    /**
     * Get's the tweet's date
     * @return Date of the tweet
     */
    public Date getDate();
}
