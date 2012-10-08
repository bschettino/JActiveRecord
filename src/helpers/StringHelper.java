/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author Schettino
 */
public class StringHelper {

    public static String underscore(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"),
                "_").toLowerCase();
    }

    public static String capitalize(String s, boolean preserveCase) {
        if (s.length() == 0) {
            return s;
        }
        if (preserveCase) {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        } else {
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        }

    }

    public static String camelize(String s, String separator) {
        String[] parts = s.split(separator);
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + capitalize(part, false);
        }
        return camelCaseString;
    }
}
