
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
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;    // simulates the actual display
    
    /**
     * @post Constructor for ClockDisplay objects that 
     * creates a new clock set at {@code 00:00}.
     */
    public ClockDisplay()
    {
        
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * @pre {@code 0 <= 'hour' < 24 and 0 <= 'minute' < 60}.
     * @post Constructor for ClockDisplay objects that
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, int second)
    {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hora incorrecta");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minutos incorrectos");
        }

        if (second < 0 ||second >= 60) {
            throw new IllegalArgumentException("segundos incorrectos");
        }

        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute, second);
    }

    /**
     * @post Makes the clock display go one second forward 
     * (should get called once every second).
     */
    public void timeTick()
    {
        seconds.increment();
        if(seconds.getValue() == 0) {  // it just rolled over!
            minutes.increment();
            if (minutes.getValue() == 0) {
                hours.increment();
            }
        }
        updateDisplay();
    }

    /**
     * @pre {@code 0 <= 'hour' < 24 and 0 <= 'minute' < 60}.
     * @post Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, int second)
    {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hora incorrecta");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minutos incorrectos");
        }

        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }

    /**
     * @post Returns the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * @post Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + ":" + seconds.getDisplayValue();
    }
}
