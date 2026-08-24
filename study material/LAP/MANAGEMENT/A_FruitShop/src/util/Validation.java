/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Trung Anh
 */
import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkLimit(int min, int max, String message) {
        while (true) {
            try {
                System.out.print(message);
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    System.err.println("Choice must be between " + min + " and " + max);
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Enter number only!");
            }
        }
    }

    public String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!input.matches("^[A-Za-z\\s]+$")) {
                System.err.println("Invalid input (letters only)");
                continue;
            }
            return input;
        }
    }

    public double checkPrice(String message) {
        while (true) {
            try {
                System.out.print(message);
                double price = Double.parseDouble(sc.nextLine().trim());
                // kiem tra 
                if (price <= 0) {
                    System.err.println("Price must be > 0");
                    continue;
                }
                return price;
            } catch (NumberFormatException e) {
                System.err.println("Enter number only!");
            }
        }
    }

    // giống hệt checkPrice --> nêu dùng 1 hàm duy nhất --? checkPositiveNumber
    public int checkQuantity(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int q = Integer.parseInt(sc.nextLine().trim());
                // kiem tra
                if (q <= 0) {
                    System.err.println("Quantity must be > 0");
                    continue;
                }
                return q;
            } catch (NumberFormatException e) {
                System.err.println("Enter integer only!");
            }
        }
    }

    public boolean checkDuplicate(ArrayList<Fruit> list, String name, String origin) {
        for (Fruit f : list) {
            // name
            // origin
            // so sánh equa
            if (f.getName().equalsIgnoreCase(name)
                    && f.getOrigin().equalsIgnoreCase(origin)) {
                return true;
            }
        }
        return false;
    }

    // sửa lại gpt viết 

    public int checkNumber(String mess, ArrayList<Fruit> fruitList, String err) {
        
        while (true) {
            try {
                System.out.println(mess);
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.out.println("Error: Input cannot be empty");
                    continue;
                }
                
                
                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen
                if (number <= 0 || number > fruitList.size()) {  // Neu so <= 0 thi khong hop le
                    System.err.println("Error: Please enter a positive integer");
                } else {
                    return number;   // Neu hop le thi tra ve gia tri
                }
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. ");
            }
        }
    }
    
}
