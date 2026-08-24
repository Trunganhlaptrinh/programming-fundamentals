/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package counter;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    public String enterAndCheckValidInput(){
        while(true){
            System.out.println("Enter your content:");
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Input cannot be empty!");
                continue;
            }
            return input;
        }
    }
}
