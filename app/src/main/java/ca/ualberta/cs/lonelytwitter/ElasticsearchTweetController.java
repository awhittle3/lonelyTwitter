package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>>{
        @Override
        protected ArrayList<Tweet> doInBackground(String... searchStrings){
            verifyClient();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            // NOTE: Only first search term will be used
            Search search = new Search.Builder(searchStrings[0]).addIndex("testing").addType("tweet").build();

            try {
                SearchResult execute = client.execute(search);
                if(execute.isSucceeded()){
                    List<NormalTweet> retTweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(retTweets);
                } else {
                    Log.i("TODO", "doInBackground: Failed in searching tweets");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return tweets;
        }
    }

    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void>{
        @Override
        protected Void doInBackground(NormalTweet... tweets){
            verifyClient();

            for(int i = 0; i < tweets.length; i++){
                NormalTweet tweet = tweets[i];
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()){
                        // Set ID
                        tweet.setId(result.getId());
                    } else {
                        Log.i("TODO", "doInBackground: Add tweet did not succeed");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return null;
        }
    }

    public static void verifyClient(){
        // Verify client exists
        if(client == null){
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}
