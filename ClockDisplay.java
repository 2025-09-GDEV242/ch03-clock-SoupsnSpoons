
/**
 * The ClockDisplay class implements a digital clock display for a
 * Amrican-style 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock internally is 00:00 (midnight) to 23:59 (one minute before 
 * midnight). However, the clock should display 12:00 AM - 11:59 AM, and 
 * 12:00 PM - 11:59 PM
 * 
 * The code needs to translate the hours to the equivalent 12 hour time block and must
 * append the appropritate meridian designation (AM or PM)
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     * 
     * The problem we are running into currently is the fact that once 
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        if(hours.getValue() >11) { //it's rolled over
            System.out.println(hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "PM");
        }
        /*else if(hours.getValue() >23) {
            System.out.println(hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "AM");
        }*/
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
