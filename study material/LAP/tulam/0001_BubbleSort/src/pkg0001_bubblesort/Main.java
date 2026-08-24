
package pkg0001_bubblesort;
public class Main {
    public static void main(String[] args) {
        //Khai bao doi tuong bubbleSort
        BubbleSort bubbleSort = new BubbleSort();
        
        // Yeu cau user nhap vao so nguyen duong n
        int sizeArray = bubbleSort.enterAndCheckValidInput();
        
        // Khoi tao mang arr co n phan tu
        bubbleSort.createArray(sizeArray);
        
        // Tao ngau nhien cac phan tu trong mang co gia tri tu [0,sizeArray)
        bubbleSort.generateRandomInteger();
        
        // In ra man hinh mang chua duoc sap xep
        bubbleSort.displayArray("Unsorted array");
        
        // Su dung thuat toan BubbleSort de sap xep mang
        bubbleSort.sortByBubbleSort();
        
        // In ra man hinh mang da duoc sap xep
        bubbleSort.displayArray("Sorted array");
        
    }
    
}
