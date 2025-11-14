/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Wallet {

    private int amount;

    public Wallet() {
    }

    public Wallet(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean payMoney(int total) {
        if (total <= amount) {
            return true;
        } else {
            return false;
        }
    }
}
