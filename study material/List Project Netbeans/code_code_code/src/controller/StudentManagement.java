/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collection;
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
    
    Validation validation = new Validation();
    Scanner sc = new Scanner(System.in);
    
    ArrayList<Student> studentList = new ArrayList<>();
    
    public void createStudent() {
        
        String name = validation.checkInputString("Enter name: ");
        String semester = validation.checkSemester("Enter semester: ");
        String course = validation.checkCourse("Choosing: Python / C / Assembly");
        
        if (validation.checkRepeat(studentList, name, semester, course)) {
            System.err.println("This student had been exist! add failed");
            return;
        }
        
        Student data = new Student(name, semester, course);
        studentList.add(data);
        System.out.println("add successfully! with ID " + data.getId());
        display();
    }
    
    public void updateOrDelete() {
        //System.out.println("Choice Update/Delete ?");

        String choice = validation.checkInputString("Choice Update/Delete ?");
        display();
        
        int id = validation.checkID("Enter ID: ");
        Student student = studentList.get(id - 1);
        if (choice.equalsIgnoreCase("Delete")) {
            studentList.remove(student);
            
        } else if (choice.equalsIgnoreCase("Update")) {
            
            String newName = validation.checkInputString("Enter name: ");
            String newSemester = validation.checkSemester("Enter semester: ");
            String newCourse = validation.checkCourse("Choosing: Python / C / Assembly");
            
            student.setCourse(newCourse);
            student.setName(newName);
            student.setSemester(newSemester);
            
        } else {
            System.out.println("Only choosing Update/Delete");
        }
        
    }
    
    public void findAndSort() {
        
        ArrayList<Student> seachingResult = new ArrayList<>();

        // FIND
        String seachingName = validation.checkInputString("Enter name to seach: ");
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(seachingName.toLowerCase())) {
                seachingResult.add(s);
            }
        }

        // SORT
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                return stu1.getName().compareToIgnoreCase(stu2.getName());
            }
        };

        // sort
        Collections.sort(seachingResult, comparator);

        // hien thi
        System.out.printf("%-5s %-20s %-10s %-10s\n",
                "ID", "Name", "Semester", "Course");
        for (Student s : seachingResult) {
            System.out.printf("%-5s %-20s %-10s %-10s\n",
                    s.getId(),
                    s.getName(),
                    s.getSemester(),
                    s.getCourse());
        }
    }
    
    public void report() {
        
        HashMap<String, Integer> reportHashMap = new HashMap<>();
        
        for (Student s : studentList) {
            String output = s.getName() + " | " + s.getCourse();
            reportHashMap.put(output, reportHashMap.getOrDefault(output, 0) + 1);
        }
    
        //split và hiểu thị
        
        for (String key : reportHashMap.keySet()) {
            String[] part = key.split("\\|");
            String name = part[0];
            String course = part[1];
            
            System.out.printf("%-20s %-10s  %-10d \n", name, course, reportHashMap.get(key));
        }
    }
    
    
    
    public void display() {
        System.out.printf("%-5s %-20s %-10s %-10s\n",
                "ID", "Name", "Semester", "Course");
        for (Student s : studentList) {
            System.out.printf("%-5s %-20s %-10s %-10s\n",
                    s.getId(),
                    s.getName(),
                    s.getSemester(),
                    s.getCourse());
        }
    }
    
}
