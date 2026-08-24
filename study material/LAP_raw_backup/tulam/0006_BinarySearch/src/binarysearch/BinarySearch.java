/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    private int[] array;
    private ArrayList<Integer> indexList;

    public void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    public void generateRandomElements() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length);
        }
    }

    public void displayArray() {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public void sortArray(int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        int pivot = array[(l + r) / 2];
        while (l <= r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                r--;
            }
            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        if (left < r) {
            sortArray(left, r);
        }
        if (right > l) {
            sortArray(l, right);
        }
    }

    public void searchValue(int key) {
        indexList = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        int foundIndex = -1;
        while (left <= right) {
            int mid =  (right + left) / 2;
            if (array[mid] == key) {
                foundIndex = mid;
                break;
            } else if (key > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (foundIndex == -1) {

        } else {
            int i = foundIndex;
            while (key == array[i + 1] && i < array.length) {
                i++;
            }
            int j = foundIndex;
            while (key == array[j - 1] && j >= 0) {
                j--;
            }
            for (int k = j; k <= i; k++) {
                indexList.add(k);
            }
        }

    }

    void displayFoundedIndex() {
        if (!indexList.isEmpty()) { // neu tim thay
            System.out.print("Found at index: ");
            for (int i = 0; i < indexList.size(); i++) {
                System.out.print(indexList.get(i));
                if (i != indexList.size() - 1) {
                    System.out.print(", ");
                }
            }
        } else { // neu khong tim thay
            System.out.print("NOT FOUND");;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Validation valid = new Validation();
        BinarySearch binarySearch = new BinarySearch();
        int sizeArray = valid.enterAndCheckValidInput("Enter number of array:");

        int searchValue = valid.enterAndCheckValidInput("Enter search value");

        binarySearch.createArray(sizeArray);

        binarySearch.generateRandomElements();

        binarySearch.sortArray(0, sizeArray - 1);

        binarySearch.displayArray();

        binarySearch.searchValue(searchValue);

        binarySearch.displayFoundedIndex();
    }

}
