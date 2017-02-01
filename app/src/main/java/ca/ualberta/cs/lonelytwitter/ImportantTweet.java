package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 * ImportantTweet is a subclass of the Tweet class
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message of the tweet.
     * @throws TweetToLongException the tweet to long exception
     */
    public ImportantTweet(String message) throws TweetToLongException {
        super(message);
    }

    /**
     * Instantiates a new Important tweet when given a date.
     *
     * @param date    the date the tweet is created
     * @param message the message
     * @throws TweetToLongException the tweet  is to long exception
     */
    public ImportantTweet(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public boolean isImportant() {

        return Boolean.TRUE;
    }

    @Override //@Override is used as protection to ensure you are properly overriding a inherited method

    /**
     * Overrides inherited getMessage() method
     * appends "!!!!!" onto the message of the tweet to indicate its important status
     */
    public String getMessage() {

        return super.getMessage() + "!!!!!";

    }
}
