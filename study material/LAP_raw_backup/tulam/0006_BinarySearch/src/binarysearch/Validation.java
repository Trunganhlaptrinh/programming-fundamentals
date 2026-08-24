/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    public int enterAndCheckValidInput(String message){
        System.out.println(message);
        while(true){
            try{
                String input = sc.nextLine();
                if(input.isEmpty()){
                    System.out.println("Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                if(number > 0) return number;
                else{
                    System.out.println("Input cannot be non-positive number");
                }
                
            }catch(NumberFormatException e){
                System.out.println("Number format is invalid");
            }
        }
    }
}
