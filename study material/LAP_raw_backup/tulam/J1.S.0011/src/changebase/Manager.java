/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package changebase;

/**
 *
 * @author ADMIN
 */
public class Manager {
    //ham hien thij chuyen doi co 
    public int displayConvert(String source, String toCase1, String toCase2) {
        Validation valid = new Validation();
        System.out.println("1. Convert from " + source + " to " + toCase1);
        System.out.println("2. Convert from " + source + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = valid.checkInputIntLimit(1, 2);
        return result;
    }
    public void convertFromBinary(String binary) {
     // Vòng lặp vô hạn cho đến khi người dùng chọn thoát
        int choice = displayConvert("binary", "decimal", "hexadecimal"); // Gọi lại để lấy lựa chọn mới mỗi lần lặp
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + binaryToDecimal(binary)
                );
                // Không cần 'continue' ở đây, vòng lặp tự động lặp lại
                break; // Thoát khỏi switch, sau đó vòng lặp while sẽ tiếp tục
                
            case 2:
                System.out.println("Hexadecimal: "
                        + binaryToHexa(binary));
                // Không cần 'continue' ở đây
                break; // Thoát khỏi switch, sau đó vòng lặp while sẽ tiếp tục           
        }
        // Nếu không phải case 3, vòng lặp while sẽ tự động lặp lại để hiển thị menu mới
    }

    //allow user convert from decimal
    public void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + decimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + decimalToHexa(decimal));
                break;
        }
    }

    //allow user convert from binary
    public void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + hexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + hexaToDecimal(hexa));
                break;
        }
    }
    
    
    
    public String decimalToBinary(String decimal){
        int deci = Integer.parseInt(decimal);
        return Integer.toBinaryString(deci);
    }
    public String decimalToHexa(String decimal){
        int deci = Integer.parseInt(decimal);
        return Integer.toHexString(deci);
    }
    public String binaryToDecimal(String binary){
        int deci = Integer.parseInt(binary, 2);
        return Integer.toString(deci);
    }
    public String hexaToDecimal(String hexa){
        int deci = Integer.parseInt(hexa, 16);
        return Integer.toString(deci);
    }
    public String binaryToHexa(String binary){
        String deci = binaryToDecimal(binary);
        String hexa = decimalToHexa(deci);
        return hexa;
    }
    public String hexaToBinary(String hexa){
        String deci = hexaToDecimal(hexa);
        String bin = decimalToBinary(deci);
        return bin;
    }
    
    
    
    
}
