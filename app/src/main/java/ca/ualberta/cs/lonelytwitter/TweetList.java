package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sstuart on 2/14/17.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){

        try {
            if (tweets.contains(tweet)) {
                throw new IllegalArgumentException();
            }
            tweets.add(tweet);
        }catch (Exception e)
        {
           //Do things
        }

    }

    public boolean hasTweet (Tweet tweet){

        return tweets.contains(tweet);
    }

    public void deleteTweet(Tweet tweet){

        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){

        return tweets.get(index);
    }

    public int getCount(){
        return tweets.size();
    }

    public ArrayList<Tweet> getTweets()
    {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        return tweets;
    }

}
