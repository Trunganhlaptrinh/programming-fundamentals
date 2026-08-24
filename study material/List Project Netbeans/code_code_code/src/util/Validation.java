/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author Trung Anh
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkLimit(String mes, int min, int max, String err) {

        while (true) {
            try {
                System.out.println(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number <= 0 && number > 6) {
                    System.err.println("Error: Please enter a positive integer");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkInputString(String mes) {
        while (true) {
            try {
                System.out.println(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                if (input.matches("^[A-Za-z\\s]+$")) {
                    return input;
                }
                System.err.println("ERROR!!! Enter again!");

            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkSemester(String mes) {
        while (true) {
            try {
                System.out.println(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                if (input.matches("^[A-Za-z0-9\\s]+$")) {
                    return input;
                }
                System.err.println("ERROR!!! Enter again!");

            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkCourse(String mes) {
        while (true) {
            try {
                System.out.println(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                if (input.equalsIgnoreCase("Python")
                        || input.equalsIgnoreCase("C")
                        || input.equalsIgnoreCase("Assembly")) {
                    return input;
                }
                System.err.println("must choose Python / C / Assembly!!!");
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public boolean checkRepeat(ArrayList<Student> studentList, String name, String semester, String course) {
        for (Student s : studentList) {
            if (s.getCourse().equalsIgnoreCase(course)
                    && s.getName().equalsIgnoreCase(name)
                    && s.getSemester().equalsIgnoreCase(semester)) {
                return true;
            }
        }
        return false;
    }

    public int checkID(String mes) {
        while (true) {
            try {
                System.out.println(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                
                if (number > 0) {
                    return number;
                }
                
                System.err.println("Enter again!!!");
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
}
