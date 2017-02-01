package ca.ualberta.cs.lonelytwitter;

/**
 * Created by sstuart on 1/17/17.
 */
public class TweetToLongException extends Exception {

    /**
     * Instantiates a new Tweet to long exception.
     */
    public TweetToLongException() {
    }

    /**
     * Instantiates a new Tweet to long exception.
     *
     * @param detailMessage the detail message
     */
    public TweetToLongException(String detailMessage) {
        super(detailMessage);
    }
}
