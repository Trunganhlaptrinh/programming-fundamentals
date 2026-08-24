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
    ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(String today) {
        while (true) {
            
            //1. thêm tên ngànhhh
            String requirementName = valid.checkInputString("Enter Requirement Name: ");
            
            //2. nhập loại nhiệm vụ
            String taskTypeId = valid.checkInputTaskTypeId();
            
            //3. nhập ngày trong tương lai
            String date = valid.checkFutureDate(today);
            
            //4. nhập người thực hiện nhiệm vụ
            String assignee = valid.checkInputString("Enter assignee: ");
            
            //5. nhập thời gian làm từ mấy h đến mấy h
            double planFrom;
            double planTo;
            while (true) {
                
                // nhập thời gian bắt đầu
                planFrom = valid.checkFromTo("Plan from: ");
                while (true) {
                    
                    //nhập thời gian kết thúc
                    planTo = valid.checkFromTo("Plan to: ");
                    
                    //kiểm tra thời gian kết thúc < thời gian bắt đầu
                    //nếu < thì nhập lại
                    if (planFrom >= planTo) {
                        System.err.println("planFrom<planTo");
                        continue;
                    } else {
                        break;
                    }
                }
                
                //kiem tra 1 ngày 1 lúc có làm 2 công việc không
                if (valid.checkDuplicate(taskList, date, assignee, planFrom, planTo) == false) {
                    
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
            Task myTask = new Task(requirementName, taskTypeId, date,
                    planFrom, planTo, assignee, reviewer);
            taskList.add(myTask);
            break;
        }
    }

    //Hàm xóa nhiệm vụ
    public void deleteTask() {
        
        //Kiểm tra rỗng
        if (taskList.isEmpty()) {
            System.out.println("taskList is empty");
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
