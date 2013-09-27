package de.felixschulze.teamcity;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamCityStatusTypeTest {

    @Test
    public void testToStringWithCase() {
        assertEquals("ERROR", TeamCityStatusType.ERROR.toString());
        assertEquals("FAILURE", TeamCityStatusType.FAILURE.toString());
        assertEquals("WARNING", TeamCityStatusType.WARNING.toString());
        assertEquals("NORMAL", TeamCityStatusType.NORMAL.toString());
    }
}
