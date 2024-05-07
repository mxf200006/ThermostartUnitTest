package thermostat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

//Muhammad Fahim 
//SE 4367.001 
//April 30, 2024

public class TermostatTest_CC {
	 private Thermostat thermostat;
	    private ProgrammedSettings programmedSettings;
	    
	    @Before
	    public void setUp() {
	        thermostat = new Thermostat();
	        programmedSettings = new ProgrammedSettings();
	        programmedSettings.setSetting(Period.MORNING, DayType.WEEKDAY, 50);
	    }
	    /**
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to true as well.
	     */
	    @Test
	    public void testRowOne() { ////curTemp < dTemp – thresholdDiff ==> true
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(30);
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(true);
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(10);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be true based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertTrue(result);  
	    }
	    
	    /**
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> false
		 * clause “b”, which is: override ==> false
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> false
		 * clause “d”, which is: timeSinceLastRun > minLag ==> false
		 * As a result p1 will evaluate to false as well.
	     */
	    
	    @Test
	    public void testRowTwo() {
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(70);
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(false);
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(3);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be false based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertFalse(result); 
	    }
}
