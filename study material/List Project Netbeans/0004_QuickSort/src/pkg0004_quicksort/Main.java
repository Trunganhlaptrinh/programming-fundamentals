package pkg0004_quicksort;

public class Main {

    public static void main(String[] args) {
        //Khai bao doi tuong bubbleSort
        QuickSort quickSort = new QuickSort();

        // Yeu cau user nhap vao so nguyen duong n
        int sizeArray = quickSort.enterAndCheckValidInput();

        // Khoi tao mang arr co n phan tu
        int[] arr = new int[sizeArray];

        // Tao ngau nhien cac phan tu trong mang co gia tri tu [0,sizeArray)
        quickSort.generateRandomInteger(arr);

        // In ra man hinh mang chua duoc sap xep
        quickSort.displayArray("Unsorted array", arr);

        // Su dung thuat toan BubbleSort de sap xep mang
        quickSort.sortArray(arr);

        // In ra man hinh mang da duoc sap xep
        quickSort.displayArray("Sorted array", arr);

//        // find max
//        quickSort.findMax("Max of Array: ", arr);
//        
//        // find min
//        quickSort.findMin("Min of Array: ", arr);;
        System.out.println("Max of Array: " + arr[arr.length - 1]);
        System.out.println("Min of Array: " + arr[0]);
    }

}
