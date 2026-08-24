
package pkg0002_selectionsort;
public class Main {
    public static void main(String[] args) {
        //Khai bao doi tuong selectionSort
        SelectionSort selectionSort = new SelectionSort();
         
        // Yeu cau user nhap vao so nguyen duong n
        int sizeArray = selectionSort .enterAndCheckValidInput();
        
        // Khoi tao mang arr co n phan tu
        selectionSort .createArray(sizeArray);
        
        // Tao ngau nhien cac phan tu trong mang co gia tri tu [0,sizeArray)
        selectionSort .generateRandomInteger();
        
        // In ra man hinh mang chua duoc sap xep
        selectionSort .displayArray("Unsorted array");
        
        // Su dung thuat toan Selection Sort de sap xep mang
        selectionSort.sortBySelectionSort();
        
        // In ra man hinh mang da duoc sap xep
        selectionSort .displayArray("Sorted array");
        
    }
    
}
