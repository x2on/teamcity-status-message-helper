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
    public void testShouldCreateMessageLogWithoutError() {
        String messageLog = TeamCityStatusMessageHelper.buildMessageString(TeamCityStatusType.FAILURE, "Tests failed - The app may be crashed", null);
        assertEquals("##teamcity[message status='FAILURE' text='Tests failed - The app may be crashed']", messageLog);
    }

    @Test
    public void testShouldCreateMessageLogWithError() {
        String messageLog = TeamCityStatusMessageHelper.buildMessageString(TeamCityStatusType.ERROR, "Tests failed - The app may be crashed", "Some Error detail message");
        assertEquals("##teamcity[message text='Tests failed - The app may be crashed' errorDetails='Some Error detail message' status='ERROR']", messageLog);
    }

    @Test
    public void testShouldCreateImportDataLog() {
        String importDataLog = TeamCityStatusMessageHelper.importDataString(TeamCityImportDataType.JUNIT, "/example/junit.xml");
        assertEquals("##teamcity[importData type='junit' path='/example/junit.xml']", importDataLog);
    }

}
