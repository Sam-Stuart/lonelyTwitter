package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 * The Anger class is a subclass of the Mood class
 */

public class Anger extends Mood {


    /**
     * Instantiates a new Anger.
     */
    public Anger() {
        super();

    }

    /**
     * Instantiates a new Anger when given a date.
     *
     * @param date the date it is created
     */
    public Anger(Date date) {
        super(date);
    }

    /**
     * Sets how this class is fromated into a string
     * @return String "Angry"
     */
    public String Format()
    {
        return "Angry";
    }


}
