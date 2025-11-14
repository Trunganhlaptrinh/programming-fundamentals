/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Trung Anh
 */


import controller.FruitManagement;
import util.Validation;

public class Main {
    public static void main(String[] args) {
        
        // tạo đối tượng
        FruitManagement shop = new FruitManagement();
        Validation validation = new Validation();

        while (true) {
            System.out.println("========= FRUIT SHOP SYSTEM =========");
            System.out.println("1. Create Fruit");
            System.out.println("2. View Orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");

            int choice = validation.checkLimit(1, 4, "Your choice: ");

            switch (choice) {
        
                case 1:
                    shop.createFruit();
                    break;
                case 2:
                    shop.viewOrders();
                    break;
                case 3:
                    shop.shopping();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}

