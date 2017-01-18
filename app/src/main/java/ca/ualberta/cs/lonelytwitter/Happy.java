package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 */

public class Happy extends Mood {


    public Happy(Date date) {
        super(date);
    }

    public Happy() {
        super();
    }

    public String Format()
    {
        return "Happy";
    }

}
