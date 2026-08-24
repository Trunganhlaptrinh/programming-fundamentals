package pkg0004_quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

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
    // Hien thi mang ra man hinh voi thong bao kem theo
    void displayArray(String message,int[] arr) {
        System.out.println(message + ": " + Arrays.toString(arr));
    }

    // Tao gia tri ngau nhien cho cac phan tu trong mang
    void generateRandomInteger(int[] arr) {
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(arr.length);  // Gia tri nam trong khoang [0, arr.length)
        }
    }

    // Sap xep mang bang thuat toan Quick Sort
    void sortArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        int midIndex = (arr.length-1) / 2;
        int midValue = arr[midIndex];
        if (arr.length<=1) {
            return;
        }
        while (l <= r) {
            while (arr[l] < midValue) {
                l++;
            }
            while (arr[r] > midValue) {
                r--;
            }
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        if (0 < r) {
            int[] arrLeft=new int[r+1];
            for(int i=0;i<=r;i++){
                arrLeft[i]=arr[i];
            }
            sortArray(arrLeft);
            for(int i=0;i<=r;i++) arr[i]=arrLeft[i];

            
        }
        if (l < arr.length-1) {
            int[] arrRight=new int[arr.length-l];
            for(int i=l;i<arr.length;i++){
                arrRight[i-l]=arr[i];
            }
            sortArray(arrRight);
            for(int i=l;i<arr.length;i++) arr[i]=arrRight[i-l];

        }

    }
}
