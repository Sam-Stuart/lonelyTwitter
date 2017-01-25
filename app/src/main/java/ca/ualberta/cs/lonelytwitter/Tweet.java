package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sstuart on 1/17/17.
 */

// all java classes inherite from the object class and inherit some of its methods
public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private ArrayList<String> Moods = new ArrayList<String>();


    public Tweet (Date date, String message) throws TweetToLongException {
        this.setMessage(message);
        this.date = date;
        this.Moods.add("Anger");
        this.Moods.add("Happy");
    }

    public Tweet(String message) throws TweetToLongException {
        this.setMessage(message);
        this.date = new Date(); //current time and date
    }



    public abstract boolean isImportant();


    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetToLongException {
        if(message.length() >140)
        {
            // todo throw an error here
            throw new TweetToLongException();
        }
        else
        {
            this.message = message;
        }
    }


    @Override
    public String toString()
    {
        return date.toString() + " | " + message;
    }
}
