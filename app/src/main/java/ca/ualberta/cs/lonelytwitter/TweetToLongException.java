package ca.ualberta.cs.lonelytwitter;

/**
 * Created by sstuart on 1/17/17.
 */

public class TweetToLongException extends Exception {

    public TweetToLongException() {
    }

    public TweetToLongException(String detailMessage) {
        super(detailMessage);
    }
}
