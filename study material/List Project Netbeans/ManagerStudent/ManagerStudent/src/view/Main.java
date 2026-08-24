package view;

import controller.StudentManagement;
import java.util.ArrayList;
import model.Student;
import util.Validation;

/**
 *
 * @author WithTrung
 */

// view: hiển thị menu chính và gọi các chức năng từ controller

public class Main {

    public static void main(String[] args) {
        StudentManagement manage = new StudentManagement();
        Validation valid = new Validation();

        while (true) {
            System.out.println("========= Student Management =========");
            System.out.println("1. Create Student");
            System.out.println("2. Find and Sort Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Report");
            System.out.println("6. Exit");

            int choice = valid.checkLimit(1, 6, "Your choice (1-6): ", "Must enter 1-6:");

            // chọn chức năng
            switch (choice) {
                case 1:
                    manage.addStudent();
                    break;
                case 2:
                    manage.findAndSort();
                    break;
                case 3:
                    //ArrayList<Student> result = new ArrayList<>();
                    manage.updateStudent();
                    break;
                case 4:
                    manage.deleteStudent();
                    break;
                case 5:
                    manage.report();
                    break;
                case 6:
                    System.out.println("Goodbye :3");
                    return;
            }
        }
    }
}
