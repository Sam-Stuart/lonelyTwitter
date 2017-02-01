package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Created by sstuart on 1/17/17.
 * Mood is the superclass
 */

public abstract class Mood {

    private Date date;

    /**
     * Instantiates a new Mood when given a date.
     *
     * @param date the date
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Instantiates a new Mood.
     */
    public Mood() {
        this.date = new Date();
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Format string.
     *
     * @return the string
     */
    public abstract String Format();

}
