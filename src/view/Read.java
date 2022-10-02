package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Read {

    private static Scanner in = 
        new Scanner(System.in);

    public static String string() {
        String s;
        try {
            s = in.nextLine();
        } catch (Exception e) {
            print("Please, try again.");
            return string();
        }
        return s;
    }   

    public static int integer() {
        int i = 0;
        try {
            i = Integer.parseInt(string());
        } catch (NumberFormatException  nfe) {
            print("Please, input an integer:");
            return integer();
        }
        return i;
    }
    /**@param a range down, included
     * @param b range up, included.
     */
    public static int integer(int a, int b) {
        int ans = integer();
        if (!(a <= ans && ans <= b)) 
            return integer(a, b);
        return ans;
            
    }

    public static double real() {
        double d = 0;
        try {
            d = Double.parseDouble(string());
        } catch (Exception e) {
            print("Please, input a rational:");
            return real();
        }
        return d;
    }

    public static LocalDate date() {
        String s = null,
        format = "d/MM/yyyy";
        LocalDate d = null;
    
        print("(Use format " + format + ")");
            s = string();
        try {
            d = LocalDate
                .parse(
                s,
                DateTimeFormatter
                    .ofPattern(format));
        } catch (DateTimeParseException dtpe) {
            print("Please, try again.");
            return date();
        }  
        return null;
    }

    private static void print(String s) {
        System.out.println(s);
    }
}