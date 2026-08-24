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
                System.out.print(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);

                // hoặc không phải và
                if (number >= min && number <= max) {

                    return number;
                }
                System.err.println(err);
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public int checkID(String mes, String err) {
        while (true) {
            try {
                System.out.print(mes);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);

                // hoặc không phải và
                if (number > 0) {

                    return number;
                }
                System.err.println(err);
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkInputString(String mes, String err) {
        while (true) {

            System.out.print(mes);
            String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
            if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                System.err.println("Error: Input cannot be empty");
                continue;
            }
            // thiếu []
            // thiếu +
            if (input.matches("^[A-Za-z\\s]+$")) {
                return input;
            }
            System.err.println(err);

        }
    }

    public String checkSemester(String mes, String err) {
        while (true) {

            System.out.print(mes);
            String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
            if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                System.err.println("Error: Input cannot be empty");
                continue;
            }
            // thiếu []
            // thiếu +
            if (input.matches("^[A-Za-z0-9\\s]+$")) {
                return input;
            }
            System.err.println(err);

        }
    }

    public String checkCourse(String mes, String err) {
        while (true) {

            System.out.print(mes);
            String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
            if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                System.err.println("Error: Input cannot be empty");
                continue;
            }

            if (input.equalsIgnoreCase("Java")
                    || input.equalsIgnoreCase("Python")
                    || input.equalsIgnoreCase("C")) {
                return input;
            }

            System.err.println(err);

        }
    }

    public int checkChoiceId(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);

                // hoặc không phải và
                if (number > 0) {

                    return number;
                }
                System.err.println("ID do not exist !");
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public boolean checkRepeatId(int id, ArrayList<Student> studentList) {

        for (Student s : studentList) {
            if (id == s.getId()) {
                System.err.println("ID was exist ! enter another ID");
                return true;
            }
        }
        return false;

    }

    public String checkIdAndNextForName(int id, ArrayList<Student> studentList) {

        for (Student s : studentList) {
            if (s.getId() == id) {
                return studentList.get(id - 1).getName();
            }
        }
        return null;

    }
}
