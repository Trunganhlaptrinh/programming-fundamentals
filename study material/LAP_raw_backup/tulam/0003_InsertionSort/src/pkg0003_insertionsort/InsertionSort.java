
package pkg0003_insertionsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    private int[] array;
    
    // Ham nhap vao so nguyen duong tu nguoi dung va kiem tra tinh hop le
    int enterAndCheckValidInput() {
        Scanner sc = new Scanner(System.in);
        
            try {
                System.out.println("Enter number of array: ");
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.out.println("Error: Input cannot be empty");
                    return -1;
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
            return -1;
        }
    

    // Tao mang moi voi kich thuoc sizeArray
    void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    // Hien thi mang ra man hinh voi thong bao kem theo
    void displayArray(String message) {
        System.out.println(message + ": " + Arrays.toString(array));
    }

     // Tao gia tri ngau nhien cho cac phan tu trong mang
    void generateRandomInteger() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length);  // Gia tri nam trong khoang [0, arr.length)
        }
    }

    // Sap xep mang bang thuat toan Insertion Sort
    void sortByInsertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key=array[i], pos=i-1;
            while(pos>=0 && key<array[pos]){
                array[pos+1]=array[pos]; // Dich chuyen phan tu sang ben phai 1 don vi
                pos--;
            }
            array[pos+1]=key; //Chen phan tu key vao noi thich hop
        }
    }
}
