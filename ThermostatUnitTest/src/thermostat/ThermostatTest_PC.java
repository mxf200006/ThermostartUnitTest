package thermostat;

import static org.junit.Assert.*;
import org.junit.*;

//Muhammad Fahim 
//SE 4367.001 
//April 30, 2024

public class ThermostatTest_PC {
    
    private Thermostat thermostat;
    private ProgrammedSettings programmedSettings;
    
    @Before
    public void setUp() {
        thermostat = new Thermostat();
        programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.MORNING, DayType.WEEKDAY, 50);
    }
    
    @Test
    public void pOneTestTurnHeaterOn() {
    	thermostat.setPeriod(Period.MORNING);
    	thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(30);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(55);
        thermostat.setTimeSinceLastRun(10);
        thermostat.setMinLag(5);
        
        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertTrue(result);  // p1 should should be true based given values
    }
    
    @Test
    public void pOneTestTurnHeaterOff() {
    	thermostat.setPeriod(Period.MORNING);
    	thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(30);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(55);
        thermostat.setTimeSinceLastRun(3);
        thermostat.setMinLag(5);
        
        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result); // p1 should should be false based given values
    }
    
    @Test
    public void pTwoTestOverrideTrue() {
    	thermostat.setPeriod(Period.MORNING);
    	thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(30);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true); //Predicate p2 = true
        thermostat.setOverTemp(55);
        thermostat.setTimeSinceLastRun(3);
        thermostat.setMinLag(5);
        
        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result); // The heater should be turned on based on the provided input values
    }
    
    @Test
    public void pTwoTestOverrideFalse() {
    	thermostat.setPeriod(Period.MORNING);
    	thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(30);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false); //Predicate p2 = false
        thermostat.setOverTemp(55);
        thermostat.setTimeSinceLastRun(3);
        thermostat.setMinLag(5);
        
        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result); // The heater should be turned on based on the provided input values
    }
    
}
