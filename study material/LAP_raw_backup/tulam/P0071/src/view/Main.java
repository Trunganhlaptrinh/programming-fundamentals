/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskManagement;
import util.Validation;

/**
 *
 * @author laptop368
 */
public class Main {

    public static void main(String[] args) {
        //gọi đối tượng
        TaskManagement manage = new TaskManagement();
        Validation valid = new Validation();

        while (true) {
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task\n"
                    + "2. Delete task\n"
                    + "3. Display Task\n"
                    + "4. Exit");
            int choice = valid.checkLimit(1, 4, "Your choice (1-4): ", "Must enter 1-4:");
            //Chọn chức năng
            switch (choice) {
                case 1:
                    manage.addTask();
                    break;
                case 2:
                    manage.deleteTask();
                    break;
                case 3:
                    manage.getDataTasks();
                    break;
                case 4:
                    System.out.println("Goodbye:3");
                    return;
            }
        }
    }
}
