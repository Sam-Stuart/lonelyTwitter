package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date of the tweet
     * @param message the message
     * @throws TweetToLongException the tweet to long exception
     */
    public NormalTweet(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @throws TweetToLongException the tweet to long exception
     */
    public NormalTweet(String message) throws TweetToLongException {
        super(message);
    }

    public boolean isImportant() {
        return Boolean.FALSE;
    }


}
