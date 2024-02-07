package org.example;



public class Main {

    public static void main(String[] args) {
        System.out.print("\n\nWelcome to the Rectangle Dimensions Calculator.\n\n");

        String selectionVariable = "y";
        while (selectionVariable.equalsIgnoreCase("y")) {

            double area;
            double perimeter;
            double lengthVar = Console.getDouble("Enter the length: ", 0, 1000000);
            double widthVar = Console.getDouble("Enter the width: ", 0, 1000000);

            area = (lengthVar * widthVar);
            perimeter = ((2 * lengthVar + 2 * widthVar));
            System.out.print("\nArea: " + String.format("%.2f", area));
            System.out.printf("\nPerimeter:" + String.format("%.2f", perimeter));
            selectionVariable = Console.getString("\n\nWould you like to calculate dimensions for another rectangle? (y/n): ");

            while (!(selectionVariable.equalsIgnoreCase("y"))) {
                if (selectionVariable.equalsIgnoreCase("n")) {
                    System.out.print("\nThank you for using the rectangle dimension calculator.");
                    break;
                } else if (selectionVariable.isEmpty()) {
                    System.out.print("Invalid entry. This field is required.");
                    selectionVariable = Console.getString("\n\nWould you like to calculate dimensions for another rectangle? (y/n): ");
                }else {
                    System.out.print("Invalid entry, please try again.");
                    selectionVariable = Console.getString("\n\nWould you like to calculate dimensions for another rectangle? (y/n): ");

                }

            }


        }

    }
}
