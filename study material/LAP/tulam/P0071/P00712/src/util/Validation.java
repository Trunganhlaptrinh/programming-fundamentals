/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
import model.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author laptop368
 */
public class Validation {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Scanner sc = new Scanner(System.in);
    
    //hàm kiểm tra giưới hạn nhập vào
    public int checkLimit(int min, int max,String message,String err) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.err.println(err);
                    continue;
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("need number");
            }
        }
    }

    //kiểm tra nhập vào là chuỗi không có số
    public String checkInputString(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!input.matches("^[A-Za-z\\s]+$")) {
                System.err.println("Can not digits");
                continue;
            }
            return input;
        }
    }

    //hàm nhập vào mã gành = lựa chọn
    public String checkInputTaskTypeId() {
        while (true) {
            /*System.out.println("-----Task type id-----");
            System.out.println("1. Code\n"
                    + "2. Test\n"
                    + "3. Design\n"
                   + "4. Review\n"
                    + "Your choice: ");*/
            int choice = checkLimit(1, 4,"Task type: ","must enter: 1.code, 2.....");
            String taskTypeId = "";
            switch (choice) {
                case 1:
                    taskTypeId = "Code";
                    break;
                case 2:
                    taskTypeId = "Test";
                    break;
                case 3:
                    taskTypeId = "Design";
                    break;
                case 4:
                    taskTypeId = "Review";
                    break;
            }
            return taskTypeId;
        }
    }

    //hàm kiểm tra ngày
    public String checkDate() {
        while (true) {
            sdf.setLenient(false);
            try {

                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                if (input.matches("^\\d{2}-\\d{2}-\\d{4}$")==false) {
                    System.err.println("Invalid date! Format must be dd-MM-yyyy");
                    continue;
                }
                Date date = sdf.parse(input);
                return sdf.format(date);
            } catch (ParseException e) {
                System.err.println("Invalid date!");
            }
        }
    }

    //hàm kiểm tra ngày trong tương lai
    public String checkFutureDate(String todayString) {
        while (true) {
            try {
                System.out.println("Enter date(dd-MM-yyyy): ");
                String date = checkDate();
                Date inputDate = sdf.parse(date);
                Date today = sdf.parse(todayString);
                if (inputDate.before(today)) {
                    System.err.println("No past dates allowed");
                    continue;
                }
                return sdf.format(inputDate);
            } catch (ParseException ex) {
                System.err.println("Date not valid");
            }
        }
    }

    //hàm kiểm tra giá trị nhập thời gian làm
    public double checkFromTo(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                double number = Double.parseDouble(input);
                if (8 > number || number > 17.5 || (number * 10) % 5 != 0) {
                    System.err.println("❌ Time must be from 8.0 to 17.5 in steps of 0.5");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("need number");
            }
        }
    }
    
    //Hàm kiểm tra trùng giờ làm của 1 người trong 1 ngày
    public boolean checkDuplicate(ArrayList<Task> taskList, String date, String assignee, double newFrom, double newTo) {
        if (taskList.isEmpty()) {
            return true;
        }
        for (Task task : taskList) {
            if (task.getDate().endsWith(date)
                    && task.getAssignee().equalsIgnoreCase(assignee)
                    && (task.getPlanFrom() >= newTo || task.getPlanTo() <= newFrom)) {
                return true;
            }
        }
        return false;
    }

    //hàm kiểm tra lựa chọn để xóa
    public int checkChoice(ArrayList<Task> taskList) {
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).getId() == number) {
                        return i;
                    } else {
                        System.err.println("can not found id");
                        continue;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("need number");
            }
        }
    }

}
