package de.felixschulze.teamcity;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamCityStatusMessageHelperTest {

    @Test
    public void testShouldEscapeString() {
        String exampleString = "Test|Test'Test\"Test\\nTest\\rTest[Test]";
        String escapedString = TeamCityStatusMessageHelper.escapeString(exampleString);
        assertEquals("Test||Test|'Test|'Test\\nTest\\rTest|[Test|]", escapedString);
    }

    @Test
    public void testShouldCreateVersionLog() {
        String versionLog = TeamCityStatusMessageHelper.buildNumberString("3.7");
        assertEquals("##teamcity[buildNumber '3.7']", versionLog);
    }

    @Test
    public void testShouldCreateBuildStatusFailureLog() {
        String buildStatusFailureLog = TeamCityStatusMessageHelper.buildStatusFailureString(TeamCityStatusType.FAILURE, "Tests failed - The app may be crashed");
        assertEquals("##teamcity[buildStatus status='FAILURE' text='Tests failed - The app may be crashed']", buildStatusFailureLog);
    }

    @Test
    public void testShouldCreateImportDataLog() {
        String importDataLog = TeamCityStatusMessageHelper.importDataString(TeamCityImportDataType.JUNIT, "/example/junit.xml");
        assertEquals("##teamcity[importData type='junit' path='/example/junit.xml']", importDataLog);
    }

}
