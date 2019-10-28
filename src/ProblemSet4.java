/**
 * Problem Set 4.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class ProblemSet4 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        
        // comment out or uncomment as needed
        
        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();
                
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     * 
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */
    
    public void sum() {
        int lowerBound;
        int upperBound;
        int sum = 0;
        System.out.println();
        do {
            System.out.print("Enter lower bound: ");
            lowerBound = in.nextInt();
            in.nextLine();
            System.out.print("Enter upper bound: ");
            upperBound = in.nextInt();
            in.nextLine();
        } while (upperBound < lowerBound);
        for (int i = lowerBound; i <= upperBound; i = i + 2) {
            if (i % 2 == 0) {
                sum += i;
            } else if (i + 1 <= upperBound) {
                i = i + 1;
                sum += i;
            }
        }
        System.out.printf("\n%,d.\n", sum);
    }
    
    /*
     * Exercise 2.
     * 
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */
    
    public void reverse() {
        int posInt;
        System.out.println();
        do {
            System.out.print("Positive Integer: ");
            posInt = in.nextInt();
            in.nextLine();
        } while (posInt <= 0);
        String intStr = Integer.toString(posInt);
        String reversed = "";
        for (int i = intStr.length() - 1; i >= 0; i--) {
            if (i == 0) {
                reversed = reversed + intStr.charAt(i) + ".";
            } else {
                reversed = reversed + intStr.charAt(i) + ", ";
            }
        }
        System.out.printf("\n%s\n", reversed);

    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */
    
    public void digits() {
        int posInt;
        int sum = 0;
        System.out.println();
        do {
            System.out.print("Positive integer: ");
            posInt = in.nextInt();
            in.nextLine();
        } while (posInt <= 0);
        String intStr = Integer.toString(posInt);
        for (int i = intStr.length() - 1; i >= 0; i--) {
            sum += (Character.getNumericValue(intStr.charAt(i)) % 2 == 1) ? Character.getNumericValue(intStr.charAt(i)) : 0;
        }
        System.out.printf("\n%,d.\n", sum);

    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */
    
    public void average() {
        int sum = 0;
        int userInt;
        int count = 0;
        System.out.println();
        do {
            System.out.print("Non-negative integer: ");
            userInt = in.nextInt();
            in.nextLine();
            if (userInt >= 0) {
                sum += userInt;
                count++;
            }
        } while (userInt >= 0);
        double average = (double) sum / count;
        System.out.printf("\n%,.2f.\n", average);
    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */
    
    public void prime() {
        System.out.println();
        int userInt;
        do {
            System.out.print("Non-negative integer: "); 
            userInt = in.nextInt();
            in.nextLine();
        } while (userInt <= 0);
        boolean isPrime = false;
        String output = "";
        if (userInt == 0 || userInt == 1) {
            output = "Not prime.";
        } else {
            for (int i = 2; i <= userInt; i++) {
                if (userInt % i == 0 && i != userInt) {
                    output = "Not prime.";
                    break;
                } else {
                    output = "Prime.";
                }
            }
        }
        System.out.printf("\n%s\n", output);
        
    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */
    
    public void fibonacci() {
        int userInput;
        System.out.println();
        do {
            System.out.print("Positive integer: ");
            userInput = in.nextInt();
            in.nextLine();
        } while (userInput < 1 || userInput > 92);
        long firstNum = 0;
        long secondNum = 1;
        long fibNum = 0;
        for (int i = 1; i <= userInput; i++) {
            if (i == 1) {
                fibNum = secondNum;
            } else {
                fibNum = firstNum + secondNum;
                firstNum = secondNum;
                secondNum = fibNum;
            }
        }
        System.out.printf("\n%,d.\n", fibNum);
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a positive integer. What are its factors?
     */
    
    public void factors() {
        int userInput;
        System.out.println();
        do {
            System.out.print("Positive integer: ");
            userInput = in.nextInt();
            in.nextLine();
        } while (userInput < 1);

        String output = "";
        for (int i = 1; i <= userInput; i++) {
            if (userInput % i == 0) {
                if (i == 1) {
                    output = "1, " + String.valueOf(userInput);
                } else {
                    output += ", " + String.valueOf(i) + ", " + String.valueOf(userInput / i);
                }
            }
        }
        output = output.substring(0, ((output.length() / 2) - 1));
        System.out.printf("\n%s.\n", output);

    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */
    
    public void mario() {        
        int height = 0;
        System.out.println();
        do {
            System.out.print("Height: ");
            height = in.nextInt();
            in.nextLine();
        } while (height < 1 || height > 24);
        System.out.println();
        int length = height + 1;
        for (int i = 2; i <= length; i++) {
            System.out.print(new String(new char[length - i]).replace("\0", " "));
            System.out.println(new String(new char[i]).replace("\0", "#"));
        }
    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */
    
    public void luigi() {
        int height = 0;
        System.out.println();
        do {
            System.out.print("Height: ");
            height = in.nextInt();
            in.nextLine();
        } while (height < 1 || height > 24);
        System.out.println();
        int length = height + 1;
        for (int i = 2; i <= length; i++) {
            System.out.print(new String(new char[length - i]).replace("\0", " "));
            System.out.print(new String(new char[i]).replace("\0", "#"));
            System.out.print("  ");
            System.out.println(new String(new char[i]).replace("\0", "#"));
        }
    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */
    
    public void credit() {
        System.out.println();
        System.out.print("Number: ");
        String creditCard = in.next();
        in.nextLine();
        int cardLength = creditCard.length();
        int sum = 0;
        String[] digits = creditCard.split("");
        for (int i = cardLength - 2; i >= 0; i = i - 2) {
            int tempInt = Integer.parseInt(digits[i]) * 2;
            String tempStr = String.valueOf(tempInt);
            for (int j = 0; j < tempStr.length(); j++) {
                sum += Integer.parseInt(String.valueOf(tempStr.charAt(j)));
            }
        }

        for (int i = cardLength - 1; i >= 0; i = i - 2) {
            sum += Integer.parseInt(digits[i]);
        }

        String output = "";
        String firstTwo = digits[0] + digits[1];
        if (sum % 10 == 0) {
            switch (cardLength) {
        
                case 15:
                    if (firstTwo.equals("34") || firstTwo.equals("37")) {
                        output = "Amex.";
                    } else {
                        output = "Invalid.";
                    }
                    break;
            
                case 16:
                    if (digits[0].equals("4")) {
                        output = "Visa.";
                    } else if (Integer.parseInt(firstTwo) >= 51 && Integer.parseInt(firstTwo) <= 55) {
                        output = "Mastercard.";
                    } else {
                        output = "Invalid.";
                    }
                    break;
            
                case 13:
                    if (digits[0].equals("4")) {
                        output = "Visa.";
                    } else {
                        output = "Invalid.";
                    }
                    break;
            
                default:
                    output = "Invalid.";
                    break;
            }
        } else {
            output = "Invalid.";
        }
        System.out.printf("\n%s\n\n", output);
        
    }
}