package pkg0001_bubblesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    private int[] array;
    
    // Ham nhap vao so nguyen duong tu nguoi dung va kiem tra tinh hop le
    int enterAndCheckValidInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter number of array: ");
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

    // Sap xep mang bang thuat toan Bubble Sort
    void sortByBubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //Hoan doi 2 phan tu 
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
