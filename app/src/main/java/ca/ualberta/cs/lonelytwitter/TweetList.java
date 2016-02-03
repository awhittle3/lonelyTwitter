package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * TweetList is a class that holds tweets
 */
public class TweetList {
    /**
     * Data object ArrayList for holding the tweets
     */
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add a tweet to the holder
     * @param tweet Tweet object to be stored
     */
    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    /**
     * Checks whether a tweet is contained in the class instance
     * @param tweet Tweet object to be compared
     * @return true if the tweet is in the structure, false otherwise
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Gets a tweet from a specified index
     * @param index Index of the desired tweet
     * @return The tweet at the index
     */
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    /**
     * Deletes a tweet from the structure
     * @param tweet Tweet to be removed
     */
    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * Removes a tweet from the stucture
     * @param tweet Tweet to be removed
     */
    public void removeTweet(Tweet tweet) {

    }

    /**
     * Gets a list of tweets that have been put into this object
     * @return A list of tweets
     */
    public List<Tweet> getTweets() {
        return null;
    }

    /**
     * Gets the number of tweets in this object
     * @return The number of tweets
     */
    public int getCount() {
        return 0;
    }
}