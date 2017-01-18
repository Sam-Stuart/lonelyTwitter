package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 */

public class Anger extends Mood {


    public Anger() {
        super();

    }

    public Anger(Date date) {
        super(date);
    }

    public String Format()
    {
        return "Angry";
    }


}
