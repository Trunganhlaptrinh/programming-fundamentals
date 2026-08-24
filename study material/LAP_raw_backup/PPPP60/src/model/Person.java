/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop368
 */
public class Person {

    private Wallet wallet;

    public Person() {
    }

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int calcTotal(int[] bill) {
        int total = 0;
        for (int b : bill) {
            total += b;
        }
        return total;
    }

    public Person(int walletAmount) {
        this.wallet = new Wallet(walletAmount);
    }
}
