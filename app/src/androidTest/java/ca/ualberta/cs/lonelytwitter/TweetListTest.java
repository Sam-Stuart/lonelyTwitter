package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sstuart on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {


    public TweetListTest(){
     super(LonelyTwitterActivity.class);

    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.addTweet(tweet);
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));

        //adding same tweet shouldnt create a 2ns instance of tweet
        assertEquals(tweets.getCount(),1);

    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Date testDate;
        Tweet tweet = new NormalTweet(" 2nd test tweet");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(tweet.getMessage(),returnedTweet.getMessage());
        assertEquals(tweet.getDate(),returnedTweet.getDate());


    }


    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last test tweet");

        tweets.addTweet(tweet);
        tweets.deleteTweet(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testStrings(){
        assertEquals("Test should be 'test'", "test","test");
        assertTrue("'test' sould start with 't'","test".startsWith("t"));
    }

    //Lab 6 problem completion
    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetCount()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet(" test tweet");
        Tweet tweet2 = new NormalTweet("2 test tweet");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);

        assertEquals(tweets.getCount(),2);
    }

    public void testGetTweets()
    {
        TweetList tweets = new TweetList();
        Date testDate;
        Tweet tweet = new NormalTweet(" 2nd test tweet");
        //Tweet tweet2 = new NormalTweet(" Another test tweet");

        Calendar testCal = Calendar.getInstance();
        testCal.set(Calendar.MONTH,11);
        testDate = testCal.getTime();

        Tweet tweet2 = new NormalTweet(" Another test tweet",testDate);

        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);

        testCal.set(Calendar.MONTH,0);
        testDate = testCal.getTime();
        Tweet tweet3 = new NormalTweet(" Another test tweet",testDate);
        tweets.addTweet(tweet3);

        ArrayList<Tweet> returnedTweets = tweets.getTweets();

        for (int i=0; i < returnedTweets.size()-2;i++)
        {
            assertTrue(returnedTweets.get(i).getDate().compareTo(returnedTweets.get(i + 1).getDate()) < 0);
        }


    }

}
