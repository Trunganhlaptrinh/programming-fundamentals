/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author Trung Anh
 */
public class StudentManagement {

    private final Validation validation; // = new Validation();
    private final Scanner sc; // = new Scanner(System.in);

    ArrayList<Student> studentList = new ArrayList<>();

    public StudentManagement() {
        this.validation = new Validation();
        this.sc = new Scanner(System.in);
    }

    public void create() {
        while (true) {
            int id = validation.checkID("Enter ID: ", "ERROR !!! must > 0");

//            if (validation.checkRepeatId(id, studentList)) {
//                continue;
//            }
            String name = validation.checkIdAndNextForName(id, studentList);
            if (name == null) {
                name = validation.checkInputString("Enter Student Name: ", "ERROR !!! must enter letter");
            }

            String semester = validation.checkSemester("Enter Semester: ", "ERROR !!! must enter number and letter");
            String course = validation.checkCourse("Enter Course (Java / Python / C): ", "ERROR !!! must enter Java / Python / C");

            // save
            Student studentData = new Student(id, name, semester, course);
            studentList.add(studentData);

            displayStudentList();
            break;
        }

    }

    public void updateOrDelete() {

        while (true) {

            System.out.println("Do you wanna Update or Delete ?");
            String choice = sc.nextLine().trim();

            displayStudentList();

            int choiceId = validation.checkChoiceId("Enter ID: ");
            Student student = studentList.get(choiceId - 1);
            if (choice.equalsIgnoreCase("Delete")) {

                studentList.remove(student);
            } else if (choice.equalsIgnoreCase("Update")) {
                String newName = validation.checkInputString("Enter Student Name: ", "ERROR !!! must enter letter");
                String newSemester = validation.checkSemester("Enter Semester: ", "ERROR !!! must enter number and letter");
                String newCourse = validation.checkCourse("Enter Course (Java / Python / C): ", "ERROR !!! must enter Java / Python / C");

                student.setName(newName);
                student.setCourse(newCourse);
                student.setSemester(newSemester);
            } else {
                System.out.println("Only choose Update or Delete");
            }
        }

    }

    public void findAndSort() {
        ArrayList<Student> result = new ArrayList<>();

        //FIND 
        System.out.print("Enter name to find: ");
        String searchName = sc.nextLine().trim().toLowerCase();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(searchName)) {
                result.add(student);
            }
        }

        // SORT
        Comparator comparator = (Comparator<Student>) (Student stu1, Student stu2) -> stu1.getName().compareToIgnoreCase(stu2.getName());

        Collections.sort(result, comparator);
        for (Student rStudent : result) {
            System.out.printf("%s \n",rStudent.getName());
        }
    }

    public void report() {
        HashMap<String, Integer> reportHashMap = new HashMap<>();
        
        for (Student s : studentList) {
            String output = s.getName() + " | " + s.getCourse();
            reportHashMap.put(output, reportHashMap.getOrDefault(output, 0) + 1);
        }
        
        // split va hien thi
        for (String key : reportHashMap.keySet()) {
            String[] part = key.split("\\|");
            String name = part[0];
            String course = part[1];
            
            System.out.printf("%-20s %-15s %-10d\n", name, course, reportHashMap.get(key));
            
        }
        
    }

    public void displayStudentList() {
        System.out.printf("%-5s %-20s %-10s %-10s \n",
                "ID", "Name", "Semester", "Course");
        for (Student s : studentList) {
            System.out.printf("%-5s %-20s %-10s %-10s \n",
                    s.getId(), 
                    s.getName(), 
                    s.getSemester(), 
                    s.getCourse());
        }
    }

}
