/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managestudent;

/**
 *
 * @author ADMIN
 */
public class Student {

    private String studentId, studentName, semester, studentCourse;

    public Student() {
    }

    public Student(String studentId, String studentName, String semester, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.studentCourse = studentCourse;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
}
