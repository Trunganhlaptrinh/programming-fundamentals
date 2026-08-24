/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Validation;



/**
 *
 * @author Trung Anh
 */
public class CandidateManagement {

    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();
    
    
    ArrayList<Candidate> candidateList = new ArrayList<>();

    // 1. Add Experience candidates
    public void addExperience() {
        while (true) {
            //System.out.println("---- Create Experience Candidate ----");
            int id = valid.checkId("Enter ID");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");

            // Experience
            int expInYear = valid.checkExpInYear("Enter years of experience (0-100): ");
            String proSkill = valid.checkInputString("Enter professional skill: ");

            // ở lớp viết là ... ở cả 3 hàm
            //Candidate a = new Experience(expInYear, proSkill, expInYear, firstName, lastName, birth, address, phone, email, expInYear);
            Experience e = new Experience(expInYear, proSkill, expInYear, firstName, lastName, birth, address, phone, email, expInYear);
            candidateList.add(e);
            //System.out.println("Add experience candidate successfully. ID = " + e.getCandidateId());

            String cont = valid.checkYN("Do you want to continue (Y/N)? ");
            if (cont.equals("N")) {
                displayAllCreated();
                break;
            }
        }
    }

    // 2. Add Fresher candidates
    public void addFresher() {
        while (true) {
            //System.out.println("---- Create Fresher Candidate ----");
            int id = valid.checkId("Enter ID");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");

            // Fresher
            int graduationDate = valid.checkYear("Enter graduation year (YYYY): ");
            String degree = valid.checkGraduationRank("Enter graduation rank (Excellence/Good/Fair/Poor): ");
            String universityName = valid.checkInputString("Enter university: ");

            Fresher f = new Fresher(graduationDate, degree, universityName, id, firstName, lastName, birth, address, phone, email);
            candidateList.add(f);
            System.out.println("Add fresher candidate successfully. ID = " + f.getCandidateId());

            String cont = valid.checkYN("Do you want to continue (Y/N)? ");
            if (cont.equals("N")) {
                displayAllCreated();
                break;
            }
        }
    }

    // 3. Add Intern candidates
    public void addIntern() {
        while (true) {
            //System.out.println("---- Create Intern Candidate ----");
            int id = valid.checkId("Enter ID");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");

            // Intern
            String majors = valid.checkInputString("Enter majors: ");
            String semester = valid.checkInputString("Enter semester: ");
            String university = valid.checkInputString("Enter university name: ");

            Candidate it = new Intern(majors, semester, university, birth, firstName, lastName, birth, address, phone, email, birth);
            candidateList.add(it);
            //System.out.println("Add intern candidate successfully. ID = " + it.getCandidateId());

//            String cont = valid.checkYN("Do you want to continue (Y/N)? ");
//            if (cont.equals("N")) {
//                displayAllCreated();
//                break;
//            }
            checkYNN();
        }
    }

    // 4. Search function
    public void searchCandidate() {
        if (candidateList.isEmpty()) {
            System.out.println("No candidates in the system.");
            return;
        }
        // viết nhầm đoạn này thành display ở lớp
        // 3 cái for dưới

        // Print categorized list (names only)
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 0) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 1) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 2) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }

        String nameKey = valid.checkInputString("Input Candidate name (First name or Last name): ").toLowerCase();
        int type = valid.checkLimit(0, 2, "Input type of candidate (0-Experience,1-Fresher,2-Intern): ",
                "Type must be 0, 1 or 2");

        boolean found = false;
        System.out.println("\nThe candidates found:");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type) {
                // check first or last name contains key (case-insensitive)
                if (c.getFirstName().toLowerCase().contains(nameKey)
                        || c.getLastName().toLowerCase().contains(nameKey)) {

                    System.out.printf("%s %s | %d | %s | %s | %s | %d\n",
                            c.getFirstName(), c.getLastName(),
                            c.getBirthDate(),
                            c.getAddress(),
                            c.getPhone(),
                            c.getEmail(),
                            c.getCandidateType());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Candidate not exist.");
        }
    }

    // Helper: display all candidates created (after finishing creating)
    //
    // ở lớp viết nhầm như này
    public void displayAllCreated() {
        
    }
//    public void displayAllCreated() {
//        if (candidateList.isEmpty()) {
//            System.out.println("No candidates created yet.");
//            return;
//        }
//        System.out.println("All candidates in system:");
//        System.out.printf("%-5s %-25s %-10s %-25s %-12s %-25s %-5s\n",
//                "ID", "Name", "Birth", "Address", "Phone", "Email", "Type");
//        for (Candidate c : candidateList) {
//            System.out.printf("%-5d %-25s %-10d %-25s %-12s %-25s %-5d\n",
//                    c.getCandidateId(),
//                    c.getFirstName() + " " + c.getLastName(),
//                    c.getBirthDate(),
//                    c.getAddress(),
//                    c.getPhone(),
//                    c.getEmail(),
//                    c.getCandidateType());
//        }
//    }

    public void checkYNN() {
        System.out.println("Do you want to continue (Y/N)? ");

        String cont = sc.nextLine().trim().toLowerCase();
        if (cont.equalsIgnoreCase("N")) {
            displayAllCreated();
            return;
        }

    }
}
