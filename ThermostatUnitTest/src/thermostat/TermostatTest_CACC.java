package thermostat;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

//Muhammad Fahim 
//SE 4367.001 
//April 30, 2024

public class TermostatTest_CACC {
	 private Thermostat thermostat;
	    private ProgrammedSettings programmedSettings;
	    
	    @Before
	    public void setUp() {
	        thermostat = new Thermostat();
	        programmedSettings = new ProgrammedSettings();
	        programmedSettings.setSetting(Period.MORNING, DayType.WEEKDAY, 50);
	    }
	    /**
	     * This test case checks whether the heater turns on based on certain conditions:
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to true as well.
	     */
	    @Test
	    public void activeClauseAtrue() {
	    	//curTemp < dTemp – thresholdDiff ==> true
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
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to false as well.
	     */
	    @Test
	    public void activeClauseAFalse() {
	    	//curTemp < dTemp – thresholdDiff ==> false
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(70);	
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(true);
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(3);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be false based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertFalse(result);  
	    }
	    
	    /**
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to true as well.
	     */
	    @Test
	    public void activeClauseBTrue() {
	    	//Override ==> true
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
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to false as well.
	     */
	    @Test
	    public void activeClauseBFalse() {
	    	//Override ==> false
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(70);
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(false);  
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(10);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be false based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertFalse(result);  
	    }
	    
	    
	    
	    /**
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to true as well.
	     */
	    @Test
	    public void activeClauseCTrue() {
	    	//curTemp < overTemp – thresholdDiff ==> true
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
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> false
		 * clause “d”, which is: timeSinceLastRun > minLag ==> false
		 * As a result p1 will evaluate to false as well.
	     */
	    @Test
	    public void activeClauseCFalse() {
	    	//curTemp < overTemp – thresholdDiff ==> false
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(30);
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(true);  
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(3);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be false based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertFalse(result);  
	    }
	    
	    /**
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> false
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> true
		 * As a result p1 will evaluate to true as well.
	     */
	    @Test
	    public void activeClauseDTrue() {
	    	//timeSinceLastRun > minLag ==> true
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
	     * clause “a”, which is: curTemp < dTemp – thresholdDiff ==> true
		 * clause “b”, which is: override ==> true
		 * clause “c”, which is: curTemp < overTemp – thresholdDiff ==> true
		 * clause “d”, which is: timeSinceLastRun > minLag ==> false
		 * As a result p1 will evaluate to false as well.
	     */
	    @Test
	    public void activeClauseDFalse() {
	    	//timeSinceLastRun > minLag ==> false
	    	thermostat.setPeriod(Period.MORNING);
	    	thermostat.setDay(DayType.WEEKDAY);
	        thermostat.setCurrentTemp(70);
	        thermostat.setThresholdDiff(5);
	        thermostat.setOverride(true);  
	        thermostat.setOverTemp(55);
	        thermostat.setTimeSinceLastRun(3);
	        thermostat.setMinLag(5);
	        
	        // p1 should should be false based given values
	        boolean result = thermostat.turnHeaterOn(programmedSettings);
	        assertFalse(result);  
	    }
}
