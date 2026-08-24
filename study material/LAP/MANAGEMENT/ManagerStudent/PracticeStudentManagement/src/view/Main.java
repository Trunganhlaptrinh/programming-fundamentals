/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.StudentManagement;
import java.util.Scanner;
import util.Validation;

/**
 *
 * @author Trung Anh
 */
public class Main {

    public static void main(String[] args) {

        // tao doi tuong
        Validation validation = new Validation();
        StudentManagement studentManagement = new StudentManagement();

        while (true) {
            System.out.println("===== Student Management =====");
            System.out.println("1. Create");
            System.out.println("2. Update / Delete");
            System.out.println("3. Find and sort");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("6. Display");

            int choice = validation.checkLimit("Enter 1-5: ", 1, 6, "ERROR !!! must choose 1-5");
            switch (choice) {
                case 1:
                    studentManagement.create();
                    break;
                case 2:
                    studentManagement.updateOrDelete();
                    break;
                case 3:
                    studentManagement.findAndSort();
                    break;
                case 4:
                    studentManagement.report();
                    break;
                case 5:
                    System.out.println("Goodbye!!!");
                    return;
                case 6:
                    studentManagement.displayStudentList();
                    break;
            
            }
        }
    }
}
