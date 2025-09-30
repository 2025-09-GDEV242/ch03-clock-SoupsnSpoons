
/**
 * The ClockDisplay class implements a digital clock display for a
 * Amrican-style 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock internally is 00:00 to 11:59 This clock NEEDS to keep track of
 * whether it is AM or PM.
 * 
 * The constructor needs to record this information.
 * 
 * the zero parameter constructor should set the meridian to AM.
 * 
 * The code needs to track when hours rolls over to change from AM to PM
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
    private String displayString;// simulates the actual display
    private String Meridian;// we are introducing a new concept to the computer, hence why this has been added to the class list
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00. 
     * This is the zero parameter constructor. 
     * Tell the computer that this starting point = AM
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        Meridian = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String Meridian)//now that Meridian has been added to the parameters and then the constructor itself, it will appear on the display when setting the time. Next step... getting the display in the void timeTick() to show that this is here...
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.Meridian = Meridian; //reference notes from week 3 to get a clearer explination on why we have to do this
        setTime(hour, minute, Meridian);
    }
    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     * 
     * The meridian change goes here in this statement
     * 
     * This is supposed to be an if/else statement inside of an if statement to tell the computer when to change from AM to PM and vice versa. The issue is... I don't know how to do that...
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if(hours.getValue()==0) { //it just rolled over!
                if(Meridian.equals("AM")){ //reference notes from week 3 for a clearer explination as to why we have to do this
                    Meridian = "PM";
                }
                else{
                Meridian = "AM";
            }
            }
        }

        /*if(hours.getValue() >11) { //it's rolled over
            System.out.println(hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "PM");       
        }*/
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String Meridian)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        this.Meridian = Meridian;
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
                        minutes.getDisplayValue() + Meridian;
    }
}
