
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Trung Anh
 */
public class Validation {

    // SORT theo giá bằng Bubble Sort
    public void sortByPriceBubble(ArrayList<Product> product) {
        for (int i = 0; i < product.size() - 1; i++) {
            for (int j = 0; j < product.size() - i - 1; j++) {
                if (product.get(j).getPrice() > product.get(j + 1).getPrice()) {
                    // Hoán đổi 2 sản phẩm
                    Product temp = product.get(j);
                    product.set(j, product.get(j + 1));
                    product.set(j + 1, temp);
                }
            }
        }
    }

    // check price
    int checkNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {

                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.out.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen
                if (number <= 0) {  // Neu so <= 0 thi khong hop le
                    System.out.println("Error: Please enter a positive integer");
                } else {
                    return number;   // Neu hop le thi tra ve gia tri
                }
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.out.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
    
    // check giá
    public int checkPriceAboveMin(int minPrice, String mess) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mess);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number <= minPrice) {
                    System.out.println("Error: Price must be greater than " + minPrice);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a number > " + minPrice);
            }
        }
    }
}
