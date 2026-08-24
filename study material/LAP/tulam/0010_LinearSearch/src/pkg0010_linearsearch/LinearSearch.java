package pkg0010_linearsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LinearSearch {

    private int[] array; // mang chua cac phan tu can tim kiem
    private List<Integer> lst;

    // Ham tao mang voi kich thuoc sizeArray
    void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    // Ham hien thi mang
    void displayArray(String message) {
        System.out.println(message + Arrays.toString(array));
    }

    // Ham sinh ngau nhien cac phan tu trong mang
    void generateRandomElements() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length); // gia tri tu 0 den array.length - 1
        }
    }

    // Ham tim kiem tuyen tinh
    void searchValue(int key) {
        lst = new ArrayList<>(); // luu chi so tim thay
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) { // neu phan tu bang key thi luu chi so
                lst.add(i);
            }
        }
    }

    // In ra chi so tim duoc
    void displayFoundedIndex() {
        if (!lst.isEmpty()) { // neu tim thay
            System.out.print("Found at index: ");
            for (int i = 0; i < lst.size(); i++) {
                System.out.print(lst.get(i));
                if (i != lst.size() - 1) {
                    System.out.print(", ");
                }
            }
        } else { // neu khong tim thay
            System.out.print("NOT FOUND");;
        }
    }

    public static void main(String[] args) {
        Validation valid = new Validation();
        LinearSearch linearSearch = new LinearSearch();

        int sizeArray = valid.enterAndCheckValidInput("Enter number of array");

        int searchValue = valid.enterAndCheckValidInput("Enter search value");

        linearSearch.createArray(sizeArray);

        linearSearch.generateRandomElements();

        linearSearch.displayArray("The array: ");

        linearSearch.searchValue(searchValue);
        
        linearSearch.displayFoundedIndex();
        
        System.out.println("");
    }

}
