/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Task;
import util.Validation;

/**
 *
 * @author laptop368
 */
public class TaskManagement {

    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();
    ArrayList<Task> taskList = new ArrayList<>(); // list chứa đối tượng

    public void addTask() {
        //1. thêm tên ngànhhh
        String requirementName = valid.checkInputString("Enter Requirement Name: ");

        //2. nhập loại nhiệm vụ
        String taskTypeId = valid.checkInputTaskTypeId();

        //3. nhập ngày
        String date = valid.checkDate();

        //5. nhập thời gian làm từ mấy h đến mấy h
        double planFrom;
        double planTo;
        // nhập thời gian bắt đầu
        planFrom = valid.checkFromTo("Plan from: ", 8, 17);
        planTo = valid.checkFromTo("Plan to: ", planFrom+0.5, 17.5);

        //4. nhập người thực hiện nhiệm vụ
        String assignee;
        while (true) {
            assignee = valid.checkInputString("Enter assignee: ");
            //kiem tra 1 ngày 1 lúc có làm 2 công việc không
            if (valid.checkDuplicate(taskList, date, assignee, planFrom, planTo)) {
                //nếu có thì báo lỗi và nhập lại cả 2
                System.err.println("Time is overlapping with another task!");
                continue;
            }
            break;
        }

        //6. Nhập người kiểm tra
        String reviewer;
        while (true) {

            //kiểm tra xem người check có khác người làm không
            reviewer = valid.checkInputString("Enter reviewer");
            if (reviewer.equalsIgnoreCase(assignee)) {
                System.err.println("Assigne # Expret");
                continue;
            } else {
                break;
            }
        }

        //thêm vào list
        Task myTask = new Task(requirementName, taskTypeId, date, planFrom, planTo, assignee, reviewer);
        taskList.add(myTask);

    }

    //Hàm xóa nhiệm vụ
    public void deleteTask() {

        //Kiểm tra rỗng
        if (taskList.isEmpty()) {
            System.out.println("taskList is empty");
            return;
        }

        //in ra màn hình danh sách
        System.out.printf("%-5s %-20s %-10s %-12s %-5s %-5s %-10s %-10s\n",
                "ID", "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");
        for (Task t : taskList) {
            System.out.printf("%-5d %-20s %-10s %-12s %-5.1f %-5.1f %-10s %-10s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskTypeId(),
                    t.getDate(),
                    t.getPlanFrom(),
                    t.getPlanTo(),
                    t.getAssignee(),
                    t.getReviewer());
        }

        //chọn vị trí muốn xóa
        System.out.println("Choice task you want remove: ");
        int choice = valid.checkChoice(taskList);
        taskList.remove(choice);
        System.out.println("Remove successfully.");
    }

    //hàm hiển thị
    public void getDataTasks() {

        //Kiểm tra rỗng
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }

        //hiển thị danh sách
        System.out.printf("%-5s %-20s %-10s %-12s %-5s %-5s %-10s %-10s\n",
                "ID", "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");

        for (Task t : taskList) {
            System.out.printf("%-5d %-20s %-10s %-12s %-5.1f %-5.1f %-10s %-10s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskTypeId(),
                    t.getDate(),
                    t.getPlanFrom(),
                    t.getPlanTo(),
                    t.getAssignee(),
                    t.getReviewer());
        }
    }

}
