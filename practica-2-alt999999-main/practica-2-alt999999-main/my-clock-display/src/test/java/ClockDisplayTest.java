

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClockDisplayTest
{
    @Test
    public void test1()
    {
        ClockDisplay clock = new ClockDisplay();
        clock.setTime(22,30, 00);
        assertEquals("22:30:00", clock.getTime());
    }

    @Test void testClockDisplay12A()
    {
        ClockDisplay12 reloj = new ClockDisplay12(00,12);
        assertEquals("00:12 AM", reloj.getTime());
    }

    @Test 
    public void testClockDisplay12B()
    {
        ClockDisplay12 reloj1 = new ClockDisplay12(12,00);
        assertEquals("00:00 PM", reloj1.getTime()); 
    }

    @Test 
    public void testClockDisplay12C()
    {
        ClockDisplay12 reloj2 = new ClockDisplay12(12,30);
        assertEquals("00:30 PM", reloj2.getTime()); 
    }

    @Test 
    public void testClockDisplay12D()
    {
        ClockDisplay12 reloj3 = new ClockDisplay12(24,00);
        assertEquals("00:00 AM", reloj3.getTime());
    }

    @Test 
    public void testClockDisplay12E()
    {
        ClockDisplay12 reloj4 = new ClockDisplay12(24,38);
        assertEquals("00:38 AM", reloj4.getTime());
    }

    @Test
    public void testGetTime1()
    {
        ClockDisplay reloj1 = new ClockDisplay(13, 40,56);
        reloj1.timeTick();
        assertEquals("13:40:57", reloj1.getTime());
    }

    @Test
    public void testGetTime2()
    {
        ClockDisplay reloj2 = new ClockDisplay();
        reloj2.setTime(12, 36, 59);
        reloj2.timeTick();
        assertEquals("12:37:00", reloj2.getTime());
    }

    @Test
    public void testGetTime3()
    {
        ClockDisplay reloj3 = new ClockDisplay(23, 59, 59);
        reloj3.timeTick();
        assertEquals("00:00:00", reloj3.getTime());
    }
    
    
}


