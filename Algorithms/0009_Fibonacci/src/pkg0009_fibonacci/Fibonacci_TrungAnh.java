package pkg0009_fibonacci;



//public class Fibonacci_TrungAnh {
//
//    // In ra dãy fibonacci bằng mảng
//    void displayResult(int k) {
//        System.out.printf("The first %d Fibonacci numbers:\n", k);
//
//        long[] fib = new long[k]; // tạo mảng để lưu dãy
//
//        // gán 2 số đầu tiên
//        fib[0] = 0;
//        fib[1] = 1;
//
//        // dùng vòng lặp để tính tiếp các số
//        for (int i = 2; i < k; i++) {
//            fib[i] = fib[i - 1] + fib[i - 2];
//        }
//
//        // in ra kết quả
//        for (int i = 0; i < k; i++) {
//            System.out.print(fib[i] + " ");
//        }
//    }
//}

public class Fibonacci_TrungAnh {

    // In ra dãy fibonacci bằng mảng
    static void displayResult(int k) {
        System.out.printf("The first %d Fibonacci numbers:\n", k);

        long[] fib = new long[k]; // tạo mảng để lưu dãy

        // gán 2 số đầu tiên
        fib[0] = 0;
        fib[1] = 1;

        // dùng vòng lặp để tính tiếp các số
        for (int i = 2; i < k; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // in ra kết quả
        for (int i = 0; i < k; i++) {
            System.out.print(fib[i] + " ");
        }
    }
}

