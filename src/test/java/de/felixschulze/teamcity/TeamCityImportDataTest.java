package de.felixschulze.teamcity;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamCityImportDataTest {

    @Test
    public void testToStringWithCase() {
        assertEquals("junit", TeamCityImportDataType.JUNIT.toString());
        assertEquals("ReSharperDupFinder", TeamCityImportDataType.RESHARPERDUPFINDER.toString());
    }
}
