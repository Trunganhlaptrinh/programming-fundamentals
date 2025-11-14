package pkg0002_selectionsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

    private int[] array;

// Ham nhap vao so nguyen duong tu nguoi dung va kiem tra tinh hop le
    int enterAndCheckValidInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter number of array:");
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) { // Neu chuoi rong thi bao loi
                    System.out.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input); // Chuyen chuoi sang so nguyen
                if (number > 0) {  // Neu hop le thi tra ve gia tri
                    return number;
                } else {  // Neu khong thi bao loi
                    System.out.println("Error: Please enter a positive integer");
                }
            } catch (NumberFormatException e) { // Bat loi khi nhap khong phai so nguyen
                System.out.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
    // Tao mang moi voi kich thuoc n
    void createArray(int n) {
        array = new int[n];
    }

    // Hien thi mang ra man hinh voi thong bao kem theo
    void displayArray(String message) {
        System.out.println(message + ": " + Arrays.toString(array));
    }

    // Tao gia tri ngau nhien cho cac phan tu trong mang
    void generateRandomInteger() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length); // Gia tri nam trong khoang [0, arr.length)
        }
    }

    // Sap xep mang bang thuat toan Selection Sort
    void sortBySelectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;  // Khai bao mien minPos la vi tri cua i
            for (int j = i + 1; j < array.length; j++) {
                if (array[minPos] > array[j]) {
                    minPos = j; // Neu phan tu tai vi tri i lon hon phan tu tai vi tri j, cap nhat minPos
                }
            }
            //Hoan doi vi tri cua 2 phan tu tai vi tri i va minPos
            int tmp = array[i];
            array[i] = array[minPos];
            array[minPos] = tmp;
        }
    }
}
