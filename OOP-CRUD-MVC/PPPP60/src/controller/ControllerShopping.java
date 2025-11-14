/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Person;
import model.Wallet;


public class ControllerShopping {

    public void displayTotalOfBill(String message, int[] bill, int walletAmount) {
        
        Person person = new Person(walletAmount);
        
        int total = person.calcTotal(bill);
        
        if (person.getWallet().payMoney(total) == true) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can’t buy it.");
        }
    }
}
