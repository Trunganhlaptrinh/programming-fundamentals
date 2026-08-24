/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managestudent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String UPDATE = "U";
    public static final String DELETE = "D";

    public int checkInputLimit(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Must enter in range from " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Must enter in range from " + min + " to " + max);
            }
        }
    }

    public String checkInputString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Cannot be empty !!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    public String checkInputCourse(String message, String error) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Cannot be empty !!");
            } else {
                if (input.equalsIgnoreCase("java")) {
                    return "Java";
                } else if(input.equalsIgnoreCase(".net")){
                    return ".Net";
                }else if(input.equalsIgnoreCase("c/c++")){
                    return "C/C++";
                }else{
                    System.out.println(error);
                }
            }
        }
    }

    public boolean checkDuplicate(ArrayList<Student> studentList, String id, String name, String semester, String courseName) {
        for (Student student : studentList) {
            if (id.equalsIgnoreCase(student.getStudentId())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && name.equalsIgnoreCase(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getStudentCourse())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTwoChoice(String message, String error, String choice1, String choice2) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim().toUpperCase();
            if (input.equalsIgnoreCase(choice1)) {
                return true;
            } else if (input.equalsIgnoreCase(choice2)) {
                return false;
            } else {
                System.out.println(error);
            }
        }
    }

}
