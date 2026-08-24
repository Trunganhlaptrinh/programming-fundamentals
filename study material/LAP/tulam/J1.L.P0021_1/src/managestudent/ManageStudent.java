/*
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managestudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class ManageStudent {

    Validation valid = new Validation();
    ArrayList<Student> studentList = new ArrayList<>();

    public String findStudentNameById(ArrayList<Student> studentList, String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student.getStudentName();
            }
        }
        return null;
    }

    public void createStudent() {
        while (true) {
            String studentID = valid.checkInputString("Enter student ID: ",
                    "The ID must contain only letters and digits", "[a-zA-Z0-9]+").toUpperCase();
            String existingName = findStudentNameById(studentList, studentID);
            String studentName;
            if (existingName != null) {
                studentName = existingName;
                System.out.println("Student name: " + studentName);
            } else {
                studentName = valid.checkInputString("Enter student name: ",
                        "The ID must contain only letters", "[a-zA-Z\\s]+");
            }
            String semester = valid.checkInputString("Enter semester: ",
                    "Semester must be from 0 to 9", "[0-9]");
            String studentCourse = valid.checkInputCourse("Enter course: ",
                    "Course must be Java or .Net or C/C++");

            if (valid.checkDuplicate(studentList, studentID, studentName, semester, studentCourse) == true) {
                System.out.println("Student information has already exist");
            } else {
                Student myStudent = new Student(studentID, studentName, semester, studentCourse);
                studentList.add(myStudent);
                System.out.println("Student information has added successfully");
            }
            if (studentList.size() >= 1) {
                boolean yesOrNo = valid.checkTwoChoice("Do you want to continue(Y/N): ",
                        "Must enter 'Y' or 'N'", "Y", "N");
                if (yesOrNo == false) {
                    break;
                }
            }
        }
    }

    public void findAndSortStudent() {
        
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty. Nothing to find.");
            return;
        }
        
        String searchName = valid.checkInputString("Enter student name to search: ",
                "Invalid name.", "[a-zA-Z\\s]+");
        ArrayList<Student> foundList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                foundList.add(student);
            }
        }
        if (foundList.isEmpty()) {
            System.out.println("No student found with the name: " + searchName);
        } else {
            Collections.sort(foundList, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getStudentName().compareTo(s2.getStudentName());
                }
            });
            System.out.println("----------- Search Results -----------");
            System.out.printf("%-20s | %-10s | %-10s\n", "Student Name", "Semester", "Course Name");
            for (Student student : foundList) {
                System.out.printf("%-20s | %-10s | %-10s\n",
                        student.getStudentName(),
                        student.getSemester(),
                        student.getStudentCourse());
            }
        }
    }

    public void updateOrDeleteStudent() {
// Kiểm tra xem danh sách có rỗng không
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty. Nothing to do.");
            return;
        }
        String idToFind = valid.checkInputString("Enter student ID to find: ",
                "Invalid ID format.", "[a-zA-Z0-9]+");

        // 2. Tìm tất cả các bản ghi của sinh viên với ID đó
        ArrayList<Student> foundList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(idToFind)) {
                foundList.add(student);
            }
        }

        // 3. Xử lý trường hợp không tìm thấy
        if (foundList.isEmpty()) {
            System.out.println("NOT FOUND student with ID: " + idToFind);
            return;
        }

        // 4. Hiển thị sinh viên tìm thấy
        System.out.println("----------- Student Found -----------");
        for (int i = 0; i < foundList.size(); i++) {
            Student student = foundList.get(i);
            System.out.printf("Record %d: %s | %s | %s | %s\n",
                    (i + 1),
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getSemester(),
                    student.getStudentCourse());
        }

        // 5. Hỏi người dùng muốn Update hay Delete
        boolean isUpdate = valid.checkTwoChoice("Do you want to update (U) or delete (D)"
                + " this student: ", "Must enter 'U' or 'D' ", Validation.UPDATE, Validation.DELETE);
        int choice = 1;
        if (foundList.size() > 1) {
            String action = isUpdate ? "update" : "delete";
            choice = valid.checkInputLimit("You want to " + action + " record: ", 1, foundList.size());
        }
        // --- Logic cho DELETE ---
        if (isUpdate == false) { // Nếu người dùng chọn 'D'
            delete(foundList, choice - 1);
        } else {
            update(foundList, choice - 1);
        }
    }

    public void update(ArrayList<Student> foundedList, int index) {
        Student student = foundedList.get(index);
        String ID = student.getStudentId();
        String studentName = student.getStudentName();
        System.out.println("Student ID: " + ID);
        System.out.println("Student name: " + studentName);

        String newSemester = valid.checkInputString("Enter new semester: ", "error", "[0-9]");
        String newCourseName = valid.checkInputCourse("Enter new course name: ", "error");

        if (valid.checkDuplicate(studentList, ID, studentName, newSemester, newCourseName)) {
            System.out.println("Student Information has already exists! Update failed");
        } else {
            student.setSemester(newSemester);
            student.setStudentCourse(newCourseName);
            System.out.println("Update Successfully");
        }

    }

    public void delete(ArrayList<Student> foundedList, int index) {
        Student student = foundedList.get(index);
        studentList.remove(student);
        System.out.println("Delete successfully");
    }

    public void report() {
// Kiểm tra xem danh sách có rỗng không
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty. Nothing to report.");
            return;
        }
        
        Map<String, Integer> studentCourseCount = new HashMap<>();
        for (Student student : studentList) {
            String studentId = student.getStudentId();
            int numberCourse = studentCourseCount.getOrDefault(studentId, 0);
            studentCourseCount.put(studentId, numberCourse+1);
        }

        // 3. Hiển thị báo cáo
        System.out.println("-------------------- REPORT --------------------");
        System.out.printf("%-20s | %-10s | %-5s\n", "Student Name", "Course", "Total");

        // Duyệt lại danh sách sinh viên để in ra từng dòng theo định dạng
        for (Student student : studentList) {
            String studentId = student.getStudentId();
            String studentName = student.getStudentName();
            String courseName = student.getStudentCourse();
            int totalCourses = studentCourseCount.get(studentId);
            System.out.printf("%-20s | %-10s | %-5d\n", studentName, courseName, totalCourses);
        }
        System.out.println("----------------------------------------------");
    }
}
