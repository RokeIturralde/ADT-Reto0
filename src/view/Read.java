package view;

import java.time.LocalDate;
import java.util.Scanner;

public class Read {

    private static Scanner in = new Scanner(System.in);

    public static String string() {
        String userInput = null;
        try {
            userInput = in.next();
        } catch (Exception e) {
            System.out.println("Please, try again.");
            return string();
        }
        return userInput;
    }   

    public static int integer() {
        int num = 0;
        try {
            num = Integer.parseInt(string());
        } catch (Exception e) {
            System.out.println("Please, input a numerical value: ");
            return integer();
        }
        return num;
    }

    public static double aDouble() {
        double num = 0;
        try {
            num = Double.parseDouble(string());
        } catch (Exception e) {
            System.out.println("Please, input a numerical value: ");
            return aDouble();
        }
        return num;
    }

    public static LocalDate date() {
        // TODO: implement method to read date through console.
        return null;
    }
}