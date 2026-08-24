package util;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author WithTrung
 */

// util: chứa các hàm kiểm tra và nhập dữ liệu hợp lệ từ người dùng

public class Validation {

    Scanner sc = new Scanner(System.in);

    // kiểm tra giới hạn nhập vào
    public int checkLimit(int min, int max, String message, String err) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.err.println(err);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Need number");
            }
        }
    }

    // kiểm tra chuỗi (chỉ chữ và khoảng trắng)
    public String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!input.matches("^[A-Za-z\\s]+$")) {
                System.err.println("Invalid input (letters only)");
                continue;
            }
            return input;
        }
    }

    // kiểm tra học kỳ
    public String checkSemester(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!input.matches("^[A-Za-z0-9\\s]+$")) {
                System.err.println("Invalid semester format");
                continue;
            }
            return input;
        }
    }

    // kiểm tra tên khóa học (Java, .Net, C/C++)
    public String checkCourseName(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!input.equalsIgnoreCase("Java")
                    && !input.equalsIgnoreCase(".Net")
                    && !input.equalsIgnoreCase("C/C++")) {
                System.err.println("Course must be one of: Java / .Net / C/C++");
                continue;
            }
            return input;
        }
    }

    // kiểm tra ID có tồn tại trong danh sách không (dùng cho update/delete)
    public int checkChoiceById(ArrayList<Student> list) {
        while (true) {
            try {
                System.out.print("Enter ID: ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int id = Integer.parseInt(input);
                
                // TRÊN LÀM DỞ TỪ ĐOẠN NÀY VÀ VIẾT NHẦM THÀNH
                //IF() {
                    // LÀM TIẾP 
                //}
                // XÓA CÁI TRÊN VÀ VIẾT FOR Ở DƯỚI
                
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId() == id) {
                        return i;
                        //return list.indexOf(i);// PHẢI NHỚ LÀ RETURN i vì mình cần lấy index
                    }
                }
                System.err.println("Can not found ID");
            } catch (NumberFormatException e) {
                System.err.println("Need number");
            }
        }
    }

    // kiểm tra sinh viên trùng (name + semester + course)
    public boolean checkDuplicate(ArrayList<Student> list, String name, String semester, String course) {
        for (Student s : list) {
            if (s.getName().equalsIgnoreCase(name)
                    && s.getSemester().equalsIgnoreCase(semester)
                    && s.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }
}
