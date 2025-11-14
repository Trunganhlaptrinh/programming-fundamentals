/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author laptop368
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkMoney(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                Integer number = Integer.parseInt(input);
                if (number < 1) {
                    System.err.println("the money >0");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Number");
            }
        }
    }
}
