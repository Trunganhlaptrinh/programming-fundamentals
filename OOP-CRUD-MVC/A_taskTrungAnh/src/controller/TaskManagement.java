package controller;

import java.util.ArrayList;
import model.Task;
import util.Validation;

public class TaskManagement {

    Validation validation = new Validation();
    ArrayList<Task> taskList = new ArrayList<>();

    public void addTask() {

        String requirementName = validation.checkString("Nhập Requirement Name: ");

        String taskTypeId = validation.checkTaskType("Nhập task type: ", 1, 4, "Chỉ nhập từ 1-4");

        String date = validation.checkDate("Date: ");

        double fromPlan = validation.checkFromToPlan("From: ", 8, 17, "nhập lại");
        double toPlan = validation.checkFromToPlan("To: ", fromPlan + 0.5, 17.5, "nhập lại");

        String assignee = validation.checkString("Assignee: ");

        String reviewer;

        while (true) {
            reviewer = validation.checkString("Reviewer: ");
            if (reviewer.equalsIgnoreCase(assignee)) {
                System.out.println("Reviewer khác Assignee");
                continue;
            }

            break; // không phải return
        }

        Task data = new Task(taskTypeId, requirementName, date, fromPlan, toPlan, reviewer, assignee);
        taskList.add(data);

    }

    public void deleteTask() {

        //%s string
        // %d int
        // %f float
//        System.out.printf("%-5s %-20s %-5s %-10s %-5s -5s %-7s %-7s",
//                "ID", "Name", "Task Type", "Date", "From", "To", "Assignee", "Reviewer");
//
//        System.out.println("");
//
//        for (Task t : taskList) {
//            System.out.printf("%-5d %-20s %-5s %-15s %-5.1f% -5.1f %-7s %-7s",
//                    t.getId(),
//                    t.getRequirementName(),
//                    t.getTaskTypeId(),
//                    t.getDate(),
//                    t.getFromPlan(),
//                    t.getToPlan(),
//                    t.getAssignee(),
//                    t.getReviewer());
//        }
        displayTask();
        
        
        int number = validation.deleteId("Nhập ID muốn xóa: ");

        int canNotFoundId = 0; 
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == number) {
                taskList.remove(i);
                System.out.println("Deleted thành công");
                canNotFoundId = 999; 
                break;
            }

        }
        if(canNotFoundId == 0) {
           System.err.println("Can not found ID"); 
        }
    }

    public void displayTask() {
        System.out.printf("%-5s %-20s %-5s %-10s %-5s -5s %-7s %-7s",
                "ID", "Name", "Task Type", "Date", "From", "To", "Assignee", "Reviewer");

        System.out.println("");

        for (Task t : taskList) {
            System.out.printf("%-5d %-20s %-5s %-15s %-5.1f% -5.1f %-7s %-7s",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskTypeId(),
                    t.getDate(),
                    t.getFromPlan(),
                    t.getToPlan(),
                    t.getAssignee(),
                    t.getReviewer());
        }
    }

}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import model.Task;
//import util.Validation;
//
///**
// *
// * @author Trung Anh
// */
//public class TaskManagement {
//
//    Scanner sc = new Scanner(System.in);
//    Validation validation = new Validation();
//
//    ArrayList<Task> taskList = new ArrayList<>();
//
//    // ADD
//    public void addTask() {
//        String requirementName = validation.checkInputString("Requirement Name: ");
//
//        String taskTypeID = validation.checkTaskType();
//
//        String date = validation.checkDate();
//
//        double fromPlan = validation.checkFromToPlan("From: ", 8, 17);
//        double toPlan = validation.checkFromToPlan("To: ", fromPlan + 0.5, 17.5); // 17.5 --> chuyen thanh double
//
//        String assignee = validation.checkInputString("Assignee: ");
//        String reviewer;
//        // sử lí dieu kien: reviewer != assignee
//        while (true) {
//            reviewer = validation.checkInputString("Reviewer: ");
//            if (reviewer.equalsIgnoreCase(assignee)) { // kiem tra string
//                System.err.println("Reviewer khong duoc là Assignee");
//                continue;
//            }
//            break;
//        }
//
//        //thêm vào list
//        Task data = new Task(requirementName, taskTypeID, date, fromPlan, toPlan, assignee, reviewer);
//        taskList.add(data);
//    }
//
//    // DELETE
//    public void deleteTask() {
//        if (taskList.isEmpty()) {
//            System.out.println("Task List can not EMPTY!");
//            return;
//        }
//
//        // % bắt đầu định dạng
//        // - là cách trái, không có thì mặc định là cách phải
//        // độ rộng (khoảng cách) của cột là 5 kí tự 
//        // s là String
//        System.out.printf("%-5s %-20s %-10s %-12s %-5s %-5s %-10s %-10s\n", "ID",
//                "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");
//
//        for (Task t : taskList) {
//            System.out.printf("%-5d %-20s %-10s %-12s %-5.1f %-5.1f %-10s %-10s\n",
//                    t.getId(),
//                    t.getRequireName(),
//                    t.getTaskTypeID(),
//                    t.getDate(),
//                    t.getFromPlan(),
//                    t.getToPlan(),
//                    t.getAssignee(),
//                    t.getReview());
//        }
//
//        //chuc nang DELETE --> ID
//        int choice = validation.checkChoice(taskList);
//        taskList.remove(choice);
//        System.out.println("Remove thanh cong");
//    }
//
//    // DISPLAY
//    public void displayTask() {
//        System.out.printf("%-5s %-20s %-10s %-12s %-5s %-5s %-10s %-10s\n", "ID",
//                "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");
//
//        for (Task t : taskList) {
//            System.out.printf("%-5d %-20s %-10s %-12s %-5.1f %-5.1f %-10s %-10s\n",
//                    t.getId(),
//                    t.getRequireName(),
//                    t.getTaskTypeID(),
//                    t.getDate(),
//                    t.getFromPlan(),
//                    t.getToPlan(),
//                    t.getAssignee(),
//                    t.getReview());
//        }
//    }
//
//}
