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
 * Super class for candidates
 */


public class Candidate {
    
    private static int idCounter = 1;
    private int candidateId;
    private String firstName;
    private String lastName;
    private int birthDate; // year YYYY
    private String address;
    private String phone;
    private String email;
     int candidateType; // 0 - Experience, 1 - Fresher, 2 - Intern
    //candidateType để là String hay hơn vì lúc hiển thì nó ra exp, fresher, intern thay vì in ra 1, 2, 3
    
    //private String candidateId, firstName, lastName, address, phone, email;
    //private int birthDate, candidateType;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
