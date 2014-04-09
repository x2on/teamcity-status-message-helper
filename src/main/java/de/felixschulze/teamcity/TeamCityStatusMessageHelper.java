/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Felix Schulze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package de.felixschulze.teamcity;

/**
 * Helper for TeamCity Service Messages
 *
 * @author <a href="mail@felixschulze.de">Felix Schulze</a>
 */
public class TeamCityStatusMessageHelper {

    public static String escapeString(String string) {
        String tmp = string.replace("|", "||");
        tmp = tmp.replace("'", "|'");
        tmp = tmp.replace("\"", "|'");
        tmp = tmp.replaceAll("\\n", "|n");
        tmp = tmp.replaceAll("\\r", "|r");
        tmp = tmp.replace("[", "|[");
        tmp = tmp.replace("]", "|]");
        return tmp;
    }

    public static String buildNumberString(String version) {
        return "##teamcity[buildNumber '" + TeamCityStatusMessageHelper.escapeString(version) + "']";
    }

    public static String buildStatusString(TeamCityStatusType type, String text) {
        return "##teamcity[buildStatus status='" + type.toString() + "' text='" + TeamCityStatusMessageHelper.escapeString(text) + "']";
    }

    public static String buildMessageString(TeamCityStatusType type, String text, String errorDetails) {
        if (type == TeamCityStatusType.ERROR) {
            return "##teamcity[message text='" + TeamCityStatusMessageHelper.escapeString(text) + "' errorDetails='" + TeamCityStatusMessageHelper.escapeString(errorDetails) + "' status='" + type.toString() + "']";
        }
        return "##teamcity[message status='" + type.toString() + "' text='" + TeamCityStatusMessageHelper.escapeString(text) + "']";
    }

    public static String buildProgressString(TeamCityProgressType type, String text) {
        if (type == TeamCityProgressType.START) {
            return "##teamcity[progressStart '" + TeamCityStatusMessageHelper.escapeString(text) + "']";
        } else if (type == TeamCityProgressType.FINISH) {
            return "##teamcity[progressFinish '" + TeamCityStatusMessageHelper.escapeString(text) + "']";
        } else if (type == TeamCityProgressType.MESSAGE) {
            return "##teamcity[progressMessage '" + TeamCityStatusMessageHelper.escapeString(text) + "']";
        }
        return "";
    }

    public static String importDataString(TeamCityImportDataType type, String path) {
        return "##teamcity[importData type='" + type.toString() + "' path='" + path + "']";
    }

}
