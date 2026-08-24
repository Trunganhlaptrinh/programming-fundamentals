package pkg0010_linearsearch;

import java.util.Scanner;

public class Validation {
    int enterAndCheckValidInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message + ":");
        while (true) {
            try {
                String input = sc.nextLine(); // nhap chuoi tu ban phim
                if (input.isEmpty()) { // kiem tra rong
                    System.out.println("Input cannot be empty!");
                    continue;
                }
                int number = Integer.parseInt(input); // chuyen chuoi sang so nguyen
                if (number > 0) { // kiem tra so duong
                    return number;
                } else {
                    System.out.println("Error: Please enter a positive integer");
                }
            } catch (NumberFormatException e) {
                // xu ly truong hop nhap sai dinh dang so
                System.out.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
}
