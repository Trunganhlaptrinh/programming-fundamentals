
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Trung Anh
 */
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> product = new ArrayList<>();
        Validation validation = new Validation();
        while (true) {

            System.out.print("Enter min price: ");
            int minPrice = validation.checkNumber();

            System.out.println("Products above $" + minPrice + ": ");

            System.out.println("");

            // data cho price
            int priceIphone17 = validation.checkPriceAboveMin(minPrice, "Nhập giá IPHONE 17: ");
            int priceMacbook = validation.checkPriceAboveMin(minPrice, "Nhập giá MACBOOK: ");
            int priceSamsung = validation.checkPriceAboveMin(minPrice, "PRICE of SAMSUNG: ");
            int priceLAPTOP = validation.checkPriceAboveMin(minPrice, "PRICE of LAPTOP: ");

            System.out.print("Quantity of IPHONE: ");
            int quantity1 = validation.checkNumber();
            System.out.print("Quantity of MACBOOK: ");
            int quantity2 = validation.checkNumber();
            System.out.print("Quantity of SAMSUNG: ");
            int quantity3 = validation.checkNumber();
            System.out.print("Quantity of LAPTOP: ");
            int quantity4 = validation.checkNumber();
//            Product data = new Product(iphone17, macbook, samsung, coca);
//            product.add(data);
//            
            // Nếu muốn thêm vào list để sort:
            product.clear();
            product.add(new Product(1, "IPhone 17 Pro Max", priceIphone17, quantity1));
            product.add(new Product(2, "Macbook M4", priceMacbook, quantity2));
            product.add(new Product(3, "Samsung", priceSamsung, quantity3));
            product.add(new Product(4, "LAPTOP", priceLAPTOP, quantity4));

            validation.sortByPriceBubble(product);

            int total = 0;
            for (Product p : product) {
                total += p.getPrice() * p.getQuantity();

            // in ra tên và giá
            }
            System.out.println("$" + priceIphone17 + " - " + "IPhone 17 Pro Max");
            System.out.println("$" + priceMacbook + " - " + "Macbook M4");
            System.out.println("$" + priceSamsung + " - " + "SAMSUNG");
            System.out.println("$" + priceLAPTOP + " - " + "LAPTOP");
            System.out.println("Total: $" + total);
            break;
        }
    }

}
