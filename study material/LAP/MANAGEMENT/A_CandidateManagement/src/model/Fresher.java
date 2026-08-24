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
 * Fresher candidate
 */
public class Fresher extends Candidate {

    private int graduationDate; // year
    private String graduationRank; // Excellence, Good, Fair, Poor
    private String education; // university name

    public Fresher() {
        super();
    }

    public Fresher(String firstName, String lastName, int birthDate, String address, String phone, String email, int graduationDate, String graduationRank, String education) {
        super(firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getEducation() {
        return education;
    }
}
