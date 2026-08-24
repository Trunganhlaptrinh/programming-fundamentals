/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Trung Anh
 */
public class Fresher extends Candidate {

    private int graduationDate; // ra truong
    private String degree; // Excellence, Good, Fair, Poor ---> ở lớp đang là study rank gì phải hay study gì đó
    private String universityName; // education trong CV 

    public Fresher() {
        super();
    }

    public Fresher(int graduationDate, String degree, String universityName, int candidateId, 
            String firstName, String lastName, int birthDate, String address, String phone, String email) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.degree = degree;
        this.universityName = universityName;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public String getDegree() {
        return degree;
    }

    public String getUniversityRank() {
        return universityName;
    }
}
