/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.StudentManagement;
import util.Validation;

/**
 *
 * @author Trung Anh
 */
public class Main {

    public static void main(String[] args) {

        Validation validation = new Validation();
        StudentManagement studentManagement = new StudentManagement();

        while (true) {

            System.out.println("===== Student Management =====");
            System.out.println("1. Create");
            System.out.println("2. Update or Delete");
            System.out.println("3. Find and Sort");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("6. Display");

            int choice = validation.checkLimit("Enter your choice 1-6: ", 1, 6, "Only choose 1-6");
            switch (choice) {
                case 1:
                    studentManagement.createStudent();
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
                    studentManagement.display();
                    break;
            }
        }
    }
}
