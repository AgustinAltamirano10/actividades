 /**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is {@code 00:00 (midnight) to  23:59} (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * @post Constructor for ClockDisplay objects that 
     * creates a new clock set at {@code 00:00}.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * @pre {@code 0 <= 'hour' < 24 and 0 <= 'minute' < 60}.
     * @post Constructor for ClockDisplay objects that
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * @post Makes the clock display go one minute forward 
     * (should get called once every minute).
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * @pre {@code 0 <= 'hour' < 24 and 0 <= 'minute' < 60}.
     * @post Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /** 
     * @post Returns the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        if (hours.getValue() < 12) {
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " AM";
        } else {
            hours.setValue(hours.getValue() - 12);
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " PM";
        }
        return displayString;
    }
    
    /**
     * @post Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
