/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    private int[] array;

    // Ham nhap vao so nguyen duong tu nguoi dung va kiem tra tinh hop le
    int enterAndCheckValidInput(String message) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.err.println("ERROR!!! Input cannot be empty");
                    continue;
                }
                // try catch sẽ lí dòng code này
                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen

                if (number <= 0) {  // Neu so <= 0 thi khong hop le
                    System.out.println("Error: Please enter a positive integer");

                } else if (number > 0) {
                    return number;   // Neu hop le thi tra ve gia tri
                }
                //System.err.println("Error: Invalid number format. Please enter a positive integer");
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    // Tao mang moi voi kich thuoc sizeArray
    void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    // Hien thi mang ra man hinh voi thong bao kem theo
    void displayArray(String message) {
        
        
        // mặc định in mảng ra chỉ cho địa chỉ bộ nhớ, không thấy dữ liệu.
        // toString() giúp chuyển mảng thành chuỗi xem được, có định dạng đầy đủ.

        //System.out.println(message + array);
        System.out.println(message + Arrays.toString(array));
    }

    // Tao gia tri ngau nhien cho cac phan tu trong mang
    void generateRandomInteger() {
        // Random là một class có sẵn của Java
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {

            // array[i] = rd.nextInt(10);
            // array[i] = rd.nextInt(); nếu không có tham số thì nó sẽ random ngẫu nhiên trong khoảng range mà int có thể nhận được
            array[i] = rd.nextInt(array.length);  // Gia tri nam trong khoang [0, arr.length)
        }
    }

    // Tim kiem tuyen tinh trong mang
    // duyệt từng phần tử trong danh sách từ đầu tới cuối, so sánh từng thằng với giá trị cần tìm.
    // Nếu trùng → trả về vị trí.
    // Nếu duyệt hết vẫn không thấy → trả về “không tìm thấy”.
    int searchByLinearSearch(int searchValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return i;   // Tra ve vi tri neu tim thay
            }
        }

        return -1;  // Tra ve -1 neu khong tim thay
    }

    void displayIndex(int foundIndex, int searchNumber) {
        if (foundIndex != -1) {
            System.out.println("Found " + searchNumber + " at index: " + foundIndex);
        } else {
            System.out.println("Not found " + searchNumber + " in array");
        }
    }
}
