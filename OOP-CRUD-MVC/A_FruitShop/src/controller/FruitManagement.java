/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Trung Anh
 */
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Scanner;
import model.Fruit;
import util.Validation;

public class FruitManagement {

    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();
    ArrayList<Fruit> fruitList = new ArrayList<>();
    // Code chatGPT
    //Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    // Code Trung Anh
    HashMap<String, ArrayList<Fruit>> orders = new HashMap<>();

    // 1. Create Fruit
    public void createFruit() {
        while (true) { // while true để hỏi có tạo tiếp không 

            // tạo biến, yêu cầu nhập
            String fruit = valid.checkInputString("Enter fruit name: ");
            double price = valid.checkPrice("Enter price: "); // souble
            int quantity = valid.checkQuantity("Enter quantity: ");
            String origin = valid.checkInputString("Enter origin: "); // nguon goc --> source

            // kiểm tra trung lap - same
            if (valid.checkDuplicate(fruitList, fruit, origin)) {
                System.err.println("This fruit already exists (same name and origin).");
                continue;
            }

            // luu lai vao List
            Fruit data = new Fruit(fruit, price, quantity, origin);
            fruitList.add(data);
            System.out.println("Add successfully!");

            // xac nhan tiep tuc Y/N
            System.out.print("Do you want to continue (Y/N)? ");
            String cont = sc.nextLine().trim();
            if (cont.equalsIgnoreCase("N")) {
                displayFruit();
                return; // NO --> Exit
            }
        }
    }

    // 3. Shopping
    public void shopping() {

        if (fruitList.isEmpty()) {
            System.out.println("Fruit list is empty.");
            return;
        }

        ArrayList<Fruit> box = new ArrayList<>();

        // buying
        while (true) {

            displayFruit();

            // Code chatGPT
//            System.out.print("Select item number: ");
//            int choice;
//            try {
//                choice = Integer.parseInt(sc.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.err.println("Enter valid number.");
//                continue;
//            }
//
//            if (choice < 1 || choice > fruitList.size()) {
//                System.err.println("Invalid choice.");
//                continue;
//            }
            // Code Trung Anh dep trai hehehe
            int choice = valid.checkNumber("Select ID: ", fruitList, "Nhập lại!!!");

            // lấy đối tượng theo choice đã chọn
            Fruit fruitInShop = fruitList.get(choice - 1); // truyền vào index và nó bắt đầu là 0 nên phải - 1
            //Người dùng chọn số 1 → fruitList.get(0) → lấy trái cây đầu tiên
            //Người dùng chọn số 2 → fruitList.get(1) → lấy trái cây thứ hai

            //System.out.println("You selected: " + fruitInShop.getName());

            int quantityOfCustomerChoose = valid.checkQuantity("số lượng khách muốn mua: ");

            // so sánh số lượng của khách và shop
            if (quantityOfCustomerChoose > fruitInShop.getQuantity()) {
                System.err.println("Trong shop không đủ số lượng");
                continue; // nhập lại số lượng khách
            }

            Fruit boxData = new Fruit(fruitInShop.getName(), fruitInShop.getPrice(), quantityOfCustomerChoose, fruitInShop.getOrigin());
            box.add(boxData);

            // cập nhập lại số lượng // tương tự update và trừ đi
            fruitInShop.setQuantity(fruitInShop.getQuantity() - quantityOfCustomerChoose);

            // YES --> tính tiền luôn
            System.out.print("Do you want to order now (Y/N)? ");
            String orderNow = sc.nextLine().trim();

            if (orderNow.equalsIgnoreCase("Y")) {

                System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Quantity", "Price", "Amount");
                double totalMoney = 0; // tạo total ở ngoài
                for (Fruit f : box) {
                    double moneyPayForOneItem = f.getPrice() * f.getQuantity(); // tính tiền 1 fruit
                    totalMoney += moneyPayForOneItem; // tong tien
                    System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",
                            f.getName(), f.getQuantity(), f.getPrice(), moneyPayForOneItem);
                }
                System.out.println("Total: " + totalMoney + "$");

                // Code chatGPT
//                System.out.print("Input your name: ");
//                String customer = sc.nextLine().trim();

                // Code Trung Anh
                String customer = valid.checkInputString("Nhap ten khach hang: ");

                orders.put(customer, box);

                // Nếu bạn muốn cộng dồn các lần mua cùng một khách và bỏ orders.put(customer, cart);
//                if (orders.containsKey(customer)) {
//                    ArrayList<Fruit> existing = orders.get(customer);
//                    existing.addAll(cart);
//                } else {
//                    orders.put(customer, cart);
//                }
                System.out.println("Order completed.");
                return;
            }
        } // } của while true
    }

    // 2. View Orders
    public void viewOrders() {

        //kiểm tra rỗng
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        for (String customer : orders.keySet()) {
            System.out.println("\nCustomer: " + customer);
            System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "No", "Product", "Quantity", "Price", "Amount");

            ArrayList<Fruit> orderList = orders.get(customer); // biến tham chiếu tro tới box(giỏ hàng)
            
            
            System.out.println("\nCustomer: " + customer);
            caculateMoney(orderList);
//            ArrayList<Fruit> orderList = orders.get(customer); // biến tham chiếu tro tới box(giỏ hàng)
//            double totalMoney = 0;
//            int id = 1;
//
//            // hien thi
//            System.out.println("\nCustomer: " + customer);
//            System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "No", "Product", "Quantity", "Price", "Amount");
//
//            for (Fruit f : orderList) {
//                double countMoney = f.getPrice() * f.getQuantity();
//                totalMoney += countMoney;
//                System.out.printf("%-5d %-15s %-10d %-10.2f %-10.2f\n",
//                        id++,
//                        f.getName(),
//                        f.getQuantity(),
//                        f.getPrice(),
//                        countMoney);
//            }
//            System.out.println("Total: " + totalMoney + "$");

        }
    }

    // 4. Display all fruits
    public void displayFruit() {

        if (fruitList.isEmpty()) {
            System.out.println("No fruit in shop.");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-10s %-10s\n",
                "NO", "Fruit Name", "Origin", "Price", "Quantity");

        int id = 1;
        for (Fruit f : fruitList) {
            System.out.printf("%-5d %-15s %-15s %-10.2f %-10d\n",
                    //id++,
                    f.getId(),
                    f.getName(),
                    f.getOrigin(),
                    f.getPrice(),
                    f.getQuantity());
        }
    }

    public void caculateMoney(ArrayList<Fruit> list) {
        double totalMoney = 0;
        int id = 1;

        // hien thi
        System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "ID", "Product", "Quantity", "Price", "Amount");

        for (Fruit f : list) {
            double countMoney = f.getPrice() * f.getQuantity();
            totalMoney += countMoney;
            System.out.printf("%-5d %-15s %-10d %-10.2f %-10.2f\n",
                    id++,
                    f.getName(),
                    f.getQuantity(),
                    f.getPrice(),
                    countMoney);
        }
        System.out.println("Total: " + totalMoney + "$");
    }

}
