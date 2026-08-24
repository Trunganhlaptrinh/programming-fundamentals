package util;

import java.util.Scanner;

public class CheckValue {

    Scanner sc = new Scanner(System.in);

    public static double getFloat(String message) {

        String input;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(message);
                input = sc.nextLine().trim();
                if (input.isEmpty()) { // Neu chuoi rong thi bao loi
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                double number = Double.parseDouble(input);
                if (number>0) {
                    return number;
                } else {
                    System.err.println("Phải là số dương");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng rồi");
                continue;
            }
        }
    }
}
