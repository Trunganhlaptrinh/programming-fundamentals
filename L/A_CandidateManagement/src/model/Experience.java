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
 * Experience candidate
 */
public class Experience extends Candidate {

    private int expInYear; // 0..100
    private String proSkill;

    public Experience() {
        super();
    }

    public Experience(String firstName, String lastName, int birthDate, String address, String phone, String email, int expInYear, String proSkill) {
        super(firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }
}
