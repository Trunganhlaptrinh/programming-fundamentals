package pkg0003_insertionsort;

public class Main {

    public static void main(String[] args) {
        //Khai bao doi tuong bubbleSort
        InsertionSort insertionSort = new InsertionSort();

        // Yeu cau user nhap vao so nguyen duong n
        int sizeArray = insertionSort.enterAndCheckValidInput();
        if(sizeArray>0){
        // Khoi tao mang arr co n phan tu
        insertionSort.createArray(sizeArray);

        // Tao ngau nhien cac phan tu trong mang co gia tri tu [0,sizeArray)
        insertionSort.generateRandomInteger();

        // In ra man hinh mang chua duoc sap xep
        insertionSort.displayArray("Unsorted array");

        // Su dung thuat toan Insertion Sort de sap xep mang
        insertionSort.sortByInsertionSort();

        // In ra man hinh mang da duoc sap xep
        insertionSort.displayArray("Sorted array");
        }else{
            System.out.println("Program Stopped");
        }
    }

}
