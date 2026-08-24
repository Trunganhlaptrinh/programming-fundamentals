/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package changebase;

/**
 *
 * @author ADMIN
 */
public class ChangeBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validation valid = new Validation();
        Manager manager = new Manager();
        while (true) {
            System.out.println("1. Convert From Binary.");
            System.out.println("2. Convert From Decimal.");
            System.out.println("3. Convert From Hexa.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = valid.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    String binary = valid.checkInputBinary();
                    manager.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = valid.checkInputDecimal();
                    manager.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = valid.checkInputHexaDecimal();
                    manager.convertFromHexa(hexa);
                    break;
                case 4:
                    return;
            }
        }

    }

}
