
package org.example;
import java.util.Random;
// Special thanks to casino.org for roll nicknames.

public class Main {

    public static void main(String[] args) {

        System.out.print("\n\nWelcome to the Dice Roller.\n\n");

        String selectionVariable = Console.getString("Would you like to roll the dice? (y/n): "); //initializing loop

        //Setting first dice to an array of 6 values

        var firstDice = new int [6];
        int i = 0;
        while (i < firstDice.length){
            firstDice[i] = i + 1;
            i++;
        }

        //doing the same for the second dice

        var secondDice = new int [6];
        i = 0;
        while (i < secondDice.length){
            secondDice[i] = i + 1;
            i++;
        }

        //declaring variables for rolling the dice

        int firstRoll;
        int secondRoll;
        int rollerRandom;
        int rollSum;
        String nickname = "";
        //here is the loop that was initialized earlier

        while (selectionVariable.equalsIgnoreCase("y")) {


            //randomly picking from first dice array

            Random rand = new Random();
            rollerRandom = rand.nextInt(6);
            firstRoll = firstDice[rollerRandom];

            //Repeat for the second

            rollerRandom = rand.nextInt(6);
            secondRoll = secondDice[rollerRandom];

            rollSum = firstRoll + secondRoll;




            //if statements for nicknames from casino.org



            if (firstRoll == 1){
                if (secondRoll == 1){
                    nickname = "Snake Eyes";
                } else if (secondRoll == 2) {
                    nickname = "Ace caught a deuce";
                }else if (secondRoll == 3) {
                    nickname = "Easy four";
                }else if (secondRoll == 4) {
                    nickname = "Little Phoebe";
                }else if (secondRoll == 5) {
                    nickname = "Sixie from Dixie";
                }else if (secondRoll == 6) {
                    nickname = "The Devil";
                }else System.out.print("Error");

            }
            if (firstRoll == 2){
                if (secondRoll == 1){
                    nickname = "Australian yo";
                } else if (secondRoll == 2) {
                    nickname = "Ballerina";
                }else if (secondRoll == 3) {
                    nickname = "MJ";
                }else if (secondRoll == 4) {
                    nickname = "Easy six";
                }else if (secondRoll == 5) {
                    nickname = "Skinny Dugan";
                }else if (secondRoll == 6) {
                    nickname = "Easy eight";
                }else System.out.print("Error");

            }
            if (firstRoll == 3){
                if (secondRoll == 1){
                    nickname = "Little Joe from Kokomo";
                } else if (secondRoll == 2) {
                    nickname = "The fever";
                }else if (secondRoll == 3) {
                    nickname = "Brooklyn Forest";
                }else if (secondRoll == 4) {
                    nickname = "Skinny McKinney";
                }else if (secondRoll == 5) {
                    nickname = "Easy eight";
                }else if (secondRoll == 6) {
                    nickname = "Lou Brown";
                }else System.out.print("Error");

            }
            if (firstRoll == 4){
                if (secondRoll == 1){
                    nickname = "No field five";
                } else if (secondRoll == 2) {
                    nickname = "Jimmie Hicks";
                }else if (secondRoll == 3) {
                    nickname = "Big Red";
                }else if (secondRoll == 4) {
                    nickname = "Square Pair";
                }else if (secondRoll == 5) {
                    nickname = "Jesse James";
                }else if (secondRoll == 6) {
                    nickname = "Tennessee";
                }else System.out.print("Error");

            }
            if (firstRoll == 5){
                if (secondRoll == 1){
                    nickname = "Easy six";
                } else if (secondRoll == 2) {
                    nickname = "Benny Blue";
                }else if (secondRoll == 3) {
                    nickname = "Eighter from Decatur";
                }else if (secondRoll == 4) {
                    nickname = "Railroad nine";
                }else if (secondRoll == 5) {
                    nickname = "Puppy Paws";
                }else if (secondRoll == 6) {
                    nickname = "Six five no jive";
                }else System.out.print("Error");

            }
            if (firstRoll == 6){
                if (secondRoll == 1){
                    nickname = "Six one you're done";
                } else if (secondRoll == 2) {
                    nickname = "Easy eight";
                }else if (secondRoll == 3) {
                    nickname = "Nina from Pasadena";
                }else if (secondRoll == 4) {
                    nickname = "Big one on the end";
                }else if (secondRoll == 5) {
                    nickname = "Yo";
                }else if (secondRoll == 6) {
                    nickname = "Boxcars";
                }else System.out.print("Error");

            }

           //printing results
            System.out.print("\nFirst: " + firstRoll + "\nSecond: " + secondRoll + "\n\nTotal: " + rollSum + "\nNickname: " + nickname);
            selectionVariable = Console.getString("\n\nWould you like to roll again? (y/n): ");
        }

    }
}
