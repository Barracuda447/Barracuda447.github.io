
package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class Console {
    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static String getString(String prompt, String[] allowedValues) {
        while (true) {
            // get value from user
            System.out.print(prompt);
            String s = sc.nextLine();

            // make sure value is in array of allowed values
            String result = Convert.toAllowedString(s, allowedValues, null);
            if (result == null) {  // not found
                System.out.println("Error! Value must be in this list: "
                        + Arrays.toString(allowedValues) + ".");
            } else {
                return s;
            }
        }
    }

    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Error! Invalid integer value.");
            }
        }
    }

    public static int getInt(String prompt, int min, int max) {
        while (true) {
            int value = getInt(prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than "
                        + min + " and less than " + max + ".");
            }
        }
    }

    public static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Error! Invalid numeric value.");
            }
        }
    }

    public static double getDouble(String prompt, double min) {
        while (true) {
            double value = getDouble(prompt);
            if (value > min) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than "
                        + min + ".");
            }
        }
    }

    public static double getDouble(String prompt, double min, double max) {
        while (true) {
            double value = getDouble(prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than "
                        + min + " and less than " + max + ".");
            }
        }
    }
}
