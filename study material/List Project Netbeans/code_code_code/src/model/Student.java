/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Trung Anh
 */
public class Student {

    private static int idCount = 1;
    private int id;
    private String name;
    private String semester;
    private String course;

    public Student() {
    }

    public Student(String name, String semester, String course) {
        this.id = idCount++;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    // Getter
    public String getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
