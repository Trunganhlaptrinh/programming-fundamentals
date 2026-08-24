/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import util.Validation;
import controller.ControllerShopping;
public class Main {

    public static void main(String[] args) {
        
        Validation valid = new Validation();
        
        ControllerShopping managa = new ControllerShopping();
        
        System.out.println("======= Shopping program ==========");
        
        int numberOfBill = valid.checkMoney("input number of bill: ");
        
        int[] bill = new int[numberOfBill];
        
        for (int i = 0; i < numberOfBill; i++) {
            int valueOfBill = valid.checkMoney("input value of bill " + (i + 1) + ": ");
            bill[i] = valueOfBill;
        }
        
        int walletAmount =valid.checkMoney("Input value of wallet: ");
        
        managa.displayTotalOfBill("This is total of bill: ", bill, walletAmount);
        
    }
}
