/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package changebase;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    Scanner sc = new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max) {
    while (true) {
        try {
            int result = Integer.parseInt(sc.nextLine().trim());

            if (result >= min && result <= max) {
                return result; 
            } else {
                System.out.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }

        } catch (NumberFormatException e) {
            System.err.println("Please input a valid integer number");
            System.out.print("Enter again: ");
        }
    }
}

    public String checkInputBinary() {
        String result;
        System.out.print("Enter number binary: ");
        while (true) {
            result = sc.nextLine().trim();
            if (result.matches("[0-1]+")) {
                return result;
            } else {
                System.out.println("Must enter only 0 or 1");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputDecimal() {
        String result;
        System.out.print("Enter number decimal: ");
        while (true) {
            result = sc.nextLine().trim();
            if (result.matches("[0-9]+")) {
                return result;
            } else {
                System.out.println("Must enter only digits 0-9");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputHexaDecimal() {
        String result;
        System.out.print("Enter number hexadecimal: ");
        while (true) {
            result = sc.nextLine().toUpperCase().trim();
            if (result.matches("[0-9A-F]+")) {
                return result;
            } else {
                System.err.println("Must enter only digits 0-9 or  letters A-F");
                System.out.print("Enter again: ");
            }
        }
    }
}
