package org.example;

public class Convert {
    public static int toInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static int toInt(String value, int min, int max, int defaultValue) {
        int i = Convert.toInt(value, defaultValue);
        if (i > min && i < max) {
            return i;
        } else {
            return defaultValue;
        }
    }

    public static double toDouble(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static double toDouble(String value, double min, double max, double defaultValue) {
        double d = Convert.toDouble(value, defaultValue);
        if (d > min && d < max) {
            return d;
        } else {
            return defaultValue;
        }
    }
    public static String toAllowedString(String value, String[] allowedValues,
                                         String defaultValue) {

        for (String s : allowedValues) {
            if (value.equalsIgnoreCase(s)) {
                return value;
            }
        }
        // if get all the way thru loop, value isn't in allowed values array
        return defaultValue;
    }
}
