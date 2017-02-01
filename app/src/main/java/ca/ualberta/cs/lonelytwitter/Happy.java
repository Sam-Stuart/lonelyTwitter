package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 * The Anger class is a subclass of the Mood class
 */
public class Happy extends Mood {


    /**
     * Instantiates a new Happy.
     *
     * @param date the date its created
     */
    public Happy(Date date) {
        super(date);
    }

    /**
     * Instantiates a new Happy when given a date
     */
    public Happy() {
        super();
    }

    /**
     * Sets how this class is fromated into a string
     * @return String "Happy"
     */
    public String Format()
    {
        return "Happy";
    }

}
