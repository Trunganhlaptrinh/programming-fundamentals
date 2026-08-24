/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
public class Main {

    public static void main(String[] args) {

        // tao doi tuong
        LinearSearch linearSearch = new LinearSearch();

        // Yeu cau user nhap vao so nguyen duong cho kich thuoc mang
        int sizeArray = linearSearch.enterAndCheckValidInput("Enter number of array: ");

        // Yeu cau user nhap vao so can tim kiem
        int searchNumber = linearSearch.enterAndCheckValidInput("Enter search value: ");

        // Khoi tao mang co n phan tu
        linearSearch.createArray(sizeArray);

        // Tao ngau nhien cac phan tu trong mang co gia tri tu [0, sizeArray)
        linearSearch.generateRandomInteger();

        // In ra man hinh mang
        linearSearch.displayArray("The array: ");

        // Su dung thuat toan Linear Search de tim kiem
        int foundIndex = linearSearch.searchByLinearSearch(searchNumber);

        // Hien thi ket qua tim kiem
        linearSearch.displayIndex(foundIndex, searchNumber);
        
        

    }
}
