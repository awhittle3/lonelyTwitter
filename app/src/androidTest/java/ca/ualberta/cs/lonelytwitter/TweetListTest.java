package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

        try{
            tweets.add(tweet);
        } catch(IllegalArgumentException e){

        }
        fail();

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testRemoveTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.add(tweet);
        tweets.removeTweet(tweet);
        // Assert tweet is removed
        assertFalse(tweets.hasTweet(tweet));

    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        List<Tweet> listGetTweets = tweets.getTweets();
        assertTrue(listGetTweets.isEmpty());
        Tweet a = new NormalTweet(new Date(1), "Test a");
        Tweet b = new NormalTweet(new Date(3), "Test b");

        tweets.add(a);
        tweets.add(b);

        listGetTweets = tweets.getTweets();

        // Assert first tweet is older than second tweet
        assertTrue(listGetTweets.get(0).getDate().before(listGetTweets.get(1).getDate()));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        assertEquals(0, tweets.getCount());
        Tweet a = new NormalTweet("Test a");
        Tweet b = new NormalTweet( "Test b");
        Tweet c = new NormalTweet( "Test c");
        tweets.add(a);
        assertEquals(1, tweets.getCount());
        tweets.add(b);
        assertEquals(2, tweets.getCount());
        tweets.add(c);
        assertEquals(3, tweets.getCount());
    }

}
