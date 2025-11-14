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
    void displayArray(String message, int[] arr) {
        System.out.println(message + ": " + Arrays.toString(arr));
    }

    // Tao gia tri ngau nhien cho cac phan tu trong mang
    void generateRandomInteger(int[] arr) {
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(arr.length);  // Gia tri nam trong khoang [0, arr.length)
        }
    }

    // Hàm sortArray: thực hiện QuickSort
    void sortArray(int[] arr) {
        // Khởi tạo 2 con trỏ: left từ đầu mảng, right từ cuối mảng
        int leftIndex = 0, rightIndex = arr.length - 1;

        // Chọn pivot là giá trị ở giữa mảng
        int midIndex = (arr.length - 1) / 2;
        int midValue = arr[midIndex];

        // Nếu mảng chỉ có 0 hoặc 1 phần tử thì không cần sắp xếp
        if (arr.length <= 1) {
            return;
        }

        // Bước phân hoạch (partition)
        while (leftIndex <= rightIndex) {
            // Tìm phần tử bên trái lớn hơn hoặc bằng pivot
            // tìm phân tử sai vị trí
            // tìm value phải --> sai thì dừng
            while (arr[leftIndex] < midValue) {
                leftIndex++;     // tăng left cho tới khi <= pivot / index
            }
            // tìm phần tử nhỏ hơn pivot nằm sai vị trí của mảng bên phải

            while (arr[rightIndex] > midValue) { // điều kiện index 
                rightIndex--;    // giảm right cho tới khi >= pivot/ index
            }

            // Nếu left <= right thì hoán đổi 2 phần tử
            // swap 2 cái phần tử sai vị trí trong while
            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
                // Di chuyển tiếp con trỏ sau khi swap
                // tăng và giảm để đưa lại về đúng vị trị swap không cần hiểu sâu trong lõi máy tính
                // nếu không có tiếp tục chỉ vào 2 phần tử hoán đổi => lặp vô tận
                
                // ép dần vào trung tâm để tìm đúng điểm partition
                leftIndex++;
                rightIndex--;
            }
        }

        // Đệ quy sắp xếp nửa bên trái (nếu còn nhiều hơn 1 phần tử)
        if (0 < rightIndex) {
            // tạo mảng 
            int[] arrLeft = new int[rightIndex + 1];

            // copy dữ liệu từ arr[0..right] vào mảng con arrLeft
            for (int i = 0; i <= rightIndex; i++) { // chỉ lấy tới rightIndex vì nó giới hạn ở đó rồi
                arrLeft[i] = arr[i];
            }
            // đệ quy sort mảng con bên trái
            sortArray(arrLeft);
            // chép kết quả đã sort ngược về arr
            for (int i = 0; i <= rightIndex; i++) {
                arr[i] = arrLeft[i];
            }
        }

        // Đệ quy sắp xếp nửa bên phải (nếu còn nhiều hơn 1 phần tử)
        if (leftIndex < arr.length - 1) {
            // tạo mảng
            int[] arrRight = new int[arr.length - leftIndex];

            // copy dữ liệu từ arr[left..arr.length-1] vào mảng con arrRight
            for (int i = leftIndex; i < arr.length; i++) {
                arrRight[i - leftIndex] = arr[i];
            }
            // đệ quy sort mảng con bên phải
            sortArray(arrRight);
            // chép kết quả đã sort ngược về arr
            for (int i = leftIndex; i < arr.length; i++) {
                arr[i] = arrRight[i - leftIndex];
            }
        }
    }

    void findMax(String message, int[] arr) {

        int temp = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (i > temp) {
                temp = i;
            }
        }
        System.out.println(message + temp);
    }

    void findMin(String mess, int[] arr) {
        int temp = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (i < temp) {
                temp = i;
            }
        }
        System.out.println(mess + temp);
    }

}
