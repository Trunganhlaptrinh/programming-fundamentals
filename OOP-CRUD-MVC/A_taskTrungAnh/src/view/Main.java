package view;

import util.Validation;
import controller.TaskManagement;

public class Main {

    public static void main(String[] args) {

        Validation validation = new Validation();
        TaskManagement taskManagement = new TaskManagement();

        while (true) {
            System.out.println("===== Task program =====");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display task");
            System.out.println("4. Exit");

            int choice = validation.checkLimit();
            switch (choice) {
                case 1:
                    taskManagement.addTask();
                    break;
                case 2:
                    taskManagement.deleteTask();
                    break;
                case 3:
                    taskManagement.displayTask();
                    break;
                case 4:
                    System.out.println("Goodbye !");
                    return; // tại sao return không phải break;

            }
        }
    }
}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package view;
//
///**
// *
// * @author Trung Anh
// */
//
//import controller.TaskManagement;
//import util.Validation;
//
//
//public class Main {
//    public static void main(String[] args) {
//        
//        // tạo đối tượng để lấy chức năng
//        Validation validation = new Validation();
//        TaskManagement taskManagement = new TaskManagement();
//        
//        
//        
//        while (true) {
//            System.out.println("========= Task program =========");
//            System.out.println("1. Add task");
//            System.out.println("2. Delete task");
//            System.out.println("3. Display task");
//            System.out.println("4. exit");
//            
//            int choice = validation.checkLimit("Nhập 1-4: MidNight 7/25     ");
//            switch (choice) {
//                case 1:
//                    taskManagement.addTask();
//                    break;
//                case 2:
//                    taskManagement.deleteTask();
//                    break;
//                case 3:
//                    taskManagement.displayTask();
//                    break;
//                case 4:
//                    System.out.println("Goodbye!!!");    
//                    return;
//            }
//        }
//    }
//}
