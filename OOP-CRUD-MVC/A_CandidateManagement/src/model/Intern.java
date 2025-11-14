/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Trung Anh
 */
package model;

/**
 * Intern candidate
 */
public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
        super();
    }

    public Intern(String firstName, String lastName, int birthDate, String address, String phone, String email, String majors, String semester, String universityName) {
        super(firstName, lastName, birthDate, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }
}
