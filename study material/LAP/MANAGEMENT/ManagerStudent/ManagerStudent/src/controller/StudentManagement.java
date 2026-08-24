package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import model.Student;
import util.Validation;

/**
 *
 * @author WithTrung
 */
// controller: xử lý logic chính
// view: hiển thị menu, gọi hàm
// util: kiểm tra dữ liệu đầu vào
// model: lưu trữ thông tin sinh viên
public class StudentManagement {

    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();
    ArrayList<Student> studentList = new ArrayList<>();

    // 1. thêm sinh viên
    public void addStudent() {
        // nhập thông tin sinh viên
        String name = valid.checkInputString("Enter student name: ");
        String semester = valid.checkSemester("Enter semester: ");
        String course = valid.checkCourseName("Enter course name (Java/.Net/C/C++): ");

        // kiểm tra trùng
        if (valid.checkDuplicate(studentList, name, semester, course)) {
            System.err.println("Duplicate student (same name + semester + course). Add failed.");
            return;
        }

        // tạo và thêm sinh viên mới
        Student data = new Student(name, semester, course);
        studentList.add(data);
        System.out.println("Add student successfully. ID = " + data.getId());
    }

    // Tìm kiếm sinh viên theo tên hoặc một phần tên do người dùng nhập.
    //Sắp xếp kết quả tìm được theo thứ tự bảng chữ cái (A → Z) của tên.
    // 2. tìm và sắp xếp sinh viên
    public void findAndSort() { //--> tìm và lưu vào danh sánh
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        // nhập tên cần tìm
        System.out.print("Enter name (or part of name) to search: ");
        String findName = sc.nextLine().trim().toLowerCase(); // chuyển về chữ thường

        // lọc sinh viên có tên chứa từ khóa
        //tạo ra một list mới chứa các kết quả tìm được 
        ArrayList<Student> result = new ArrayList<>();

        //duyệt toàn bộ trong stdentList vừa tạo
        for (Student stu : studentList) {

            //contains --> hàm kiểm tra, chuỗi con trong chuỗi mẹ
            // ví dụ Anh có trong Trung Anh không 
            //đưa về lowercase để tiện kiểm tra substring
            if (stu.getName().toLowerCase().contains(findName)) {
                result.add(stu); //add vào list mới
            }
        }

        // trên lop thieu kiểm tra empty
        // kiểm tra ngoại lệ: list mới có rỗng không ?
        if (result.isEmpty()) {
            System.out.println("No student matched.");
            return;
        }

        // sắp xếp theo tên (yêu cầu trong đề)
        // triển khai comparator để định nghĩa cách so sánh giữa 2 sinh viên
        // Dùng lamda
        //Comparator<Student> comparator = (Student student1, Student student2) -> student1.getName().compareToIgnoreCase(student2.getName()) // temp, ano class
        Comparator<Student> comparator = new Comparator<Student>() {  // temp, ano class

            // ghi đè (override) phương thức compare để so sánh theo tên sinh viên
            @Override
            public int compare(Student student1, Student student2) {
                // dùng compareToIgnoreCase để so sánh tên, bỏ qua phân biệt hoa/thường
                return student1.getName().compareToIgnoreCase(student2.getName());
            }
        };

        // dùng Collections.sort() để sắp xếp danh sách 'result' theo comparator vừa định nghĩa
        Collections.sort(result, comparator);

        // TRÊN LOP THIẾU HIỂN THỊ
        // in kết quả
        System.out.printf("%-5s %-20s %-12s %-15s\n", "ID", "Name", "Semester", "Course");
        for (Student s : result) {
            System.out.printf("%-5d %-20s %-12s %-15s\n",
                    s.getId(),
                    s.getName(),
                    s.getSemester(),
                    s.getCourseName());
        }
    }

    // 3. cập nhật sinh viên
    public void updateStudent() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        // in danh sách
        displayStudents();

        // chọn sinh viên cần cập nhật
        System.out.println("Choose student ID to update: ");
        int idx = valid.checkChoiceById(studentList);

        // Student updateStudent = Gán đối tượng lấy được vào biến updateStudent để tiện sửa
        //Nó không tạo mới Student, mà trỏ tới sinh viên đã có trong danh sách.
        //THAM CHIẾU với tối tượng có id trong student list
        Student updateStudent = studentList.get(idx);

        // nhập dữ liệu mới
        String newName = valid.checkInputString("Enter new name: ");
        String newSemester = valid.checkSemester("Enter new semester: ");
        String newCourse = valid.checkCourseName("Enter new course name (Java/.Net/C/C++): ");

        updateStudent.setName(newName);
        updateStudent.setSemester(newSemester);
        updateStudent.setCourseName(newCourse);

        System.out.println("Update successfully.");
    }

    
    
    // 4. xóa sinh viên
    public void deleteStudent() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        // hiển thị danh sách
        displayStudents();

        // chọn id để xóa
        System.out.println("Choose student ID to remove: ");
        int idx = valid.checkChoiceById(studentList);
        studentList.remove(idx);

        System.out.println("Remove successfully.");
    }

    // 5. báo cáo (report)
    public void report() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        // đếm tổng số khóa học của từng sinh viên
        HashMap<String, Integer> reportHashMap = new HashMap<>();
        for (Student s : studentList) {
            String newKey = s.getName() + " | " + s.getCourseName(); //format

            // put --> add
            // get --> lấy ra value
            // get
            // getOrDefault cài giá trị mặc định --> mục tiêu là để tránh null
            // keySet lấy toàn bộ giá trị của key, nếu muốn lấy value nữa thì cần get từng value tương ứng
            // split tách chuỗi theo kí tự trong bài này dùng regex, trim để xóa khoảng trắng
            reportHashMap.put(newKey, reportHashMap.getOrDefault(newKey, 0) + 1);
        }

        // in kết quả
        System.out.printf("%-20s %-15s %-10s\n", "Student Name", "Course", "Total");
        for (String key : reportHashMap.keySet()) {
            String[] parts = key.split("\\|");
            String name = parts[0].trim();
            String course = parts[1].trim();
            System.out.printf("%-20s %-15s %-10d\n", name, course, reportHashMap.get(key));
        }
    }

    // 6. hiển thị toàn bộ danh sách sinh viên
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        System.out.printf("%-5s %-20s %-12s %-15s\n", "ID", "Name", "Semester", "Course");
        for (Student s : studentList) {
            System.out.printf("%-5d %-20s %-12s %-15s\n",
                    s.getId(), s.getName(), s.getSemester(), s.getCourseName());
        }
    }
}
