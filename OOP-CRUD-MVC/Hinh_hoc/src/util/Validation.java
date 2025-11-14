package util;

import java.util.Scanner;

public class Validation {

    public static double checkDouble(String mess) {

        //String input;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(mess);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) { // Neu chuoi rong thi bao loi
                    System.err.println("ERROR !!! DON'T EMPTY");
                    continue;
                }
                double number = Double.parseDouble(input);
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Must > 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("ERROR !!! format is false");
            }
        }
    }

    public int checkLimit(String mess, String err) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(mess);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) { // Neu chuoi rong thi bao loi
                    System.err.println("ERROR !!! DON'T EMPTY");
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                } else {
                    System.err.println(err);
                }
            } catch (NumberFormatException e) {
                System.err.println("ERROR !!! format is false");
            }
        }
    }

}
