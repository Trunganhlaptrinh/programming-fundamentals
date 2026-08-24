package view;

import controller.ControllerShopping;
import util.Validation;

public class Main {

    public static void main(String[] args) {
        Validation v = new Validation();
        ControllerShopping cs = new ControllerShopping();

        // nhập số lượng hóa đơn
        int goods = v.checkMoney("Input number of bills: ");

        // nhập từng giá trị bill
        int[] bills = new int[goods];
        for (int i = 0; i < goods; i++) {
            bills[i] = v.checkMoney("Input value of bill " + (i + 1) + ": ");
        }

        // nhập số tiền trong ví
        int walletAmount = v.checkMoney("Input value of wallet: ");

        // hiển thị kết quả
        int total = 0;
        for (int i = 0; i < bills.length; i++) { 
            int b = bills[i]; 
            total = total + b; 
        }
        
        
        System.out.println("This is total of bill: " + total);

        // gọi controller để xử lý
        cs.displayTotalOfBill("", bills, walletAmount);
    }
}
