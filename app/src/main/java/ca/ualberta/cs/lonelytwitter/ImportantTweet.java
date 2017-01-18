package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) throws TweetToLongException {
        super(message);
    }

    public ImportantTweet(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public boolean isImportant() {

        return Boolean.TRUE;
    }

    @Override //@Override is used as protection to ensure you are properly overriding a inherited method
    public String getMessage() {

        return super.getMessage() + "!!!!!";

    }
}
