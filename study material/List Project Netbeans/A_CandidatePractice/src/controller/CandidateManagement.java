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
 * @author Trung Anh
 */
public class CandidateManagement {

    private Scanner sc;// = new Scanner(System.in);
    private Validation valid; // = new Validation();

    public CandidateManagement() {
        this.sc = new Scanner(System.in);
        this.valid = new Validation();
    }

    ArrayList<Candidate> candidateList = new ArrayList<>();
    ArrayList<Experience> expList = new ArrayList<>();

    // 1. Add Experience candidates
    public void addExperience() {
        while (true) {
            System.out.println("---- Create Experience Candidate ----");
            int id = valid.checkId("Enter ID: ");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");
            int candidateType = 2;

            // Experience
            int expInYear = valid.checkExpInYear("Enter years of experience (0-100): ");
            String proSkill = valid.checkInputString("Enter professional skill: ");

            // ở lớp viết là ... ở cả 3 hàm
            //Candidate a = new Experience(firstName, lastName, birth, address, phone, email, expInYear, proSkill);
            Experience expData = new Experience(expInYear, proSkill, id, firstName, lastName, birth, address, phone, email, candidateType);
            candidateList.add(expData);

            while (true) {

                System.out.println("Do you wanna continue ? (Y/N)");
                String cont = sc.nextLine().trim();
                if (cont.equalsIgnoreCase("N")) {
                    displayAllCreated();
                    return;
                } else if (cont.equalsIgnoreCase("Y")) {
                    break;
                } else {
                    System.err.println("Only Choose Y or N");
                }
            }

        }
    }

    // 2. Add Fresher candidates
    public void addFresher() {
        while (true) {
            
            
            System.out.println("---- Create Fresher Candidate ----");
            int id = valid.checkId("Enter ID: ");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");
            int candidateType = 1;

            // Fresher
            int graduationDate = valid.checkGraduationRank("Enter graduation year (YYYY): ", birth);
            String graduationRank = valid.checkDegree("Enter graduation rank (Excellence/Good/Fair/Poor): ");
            String education = valid.checkInputString("Enter university: ");

            Fresher fresherData = new Fresher(graduationDate, graduationRank, education,
                    id, firstName, lastName, birth, address, phone, email, candidateType);
            candidateList.add(fresherData);

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
            System.out.println("---- Create Intern Candidate ----");
            int id = valid.checkId("Enter ID: ");
            String firstName = valid.checkName("Enter first name: ");
            String lastName = valid.checkName("Enter last name: ");
            int birth = valid.checkYear("Enter birth year (YYYY): ");
            String address = valid.checkInputString("Enter address: ");
            String phone = valid.checkPhone("Enter phone: ");
            String email = valid.checkEmail("Enter email: ");
            int candidateType = 0;

            // Intern
            String majors = valid.checkInputString("Enter majors: ");
            String semester = valid.checkInputString("Enter semester: ");
            String university = valid.checkInputString("Enter university name: ");

            Intern it = new Intern(majors, semester, university,
                    id, firstName, lastName, birth, address, phone, email, candidateType);
            candidateList.add(it);

            String cont = valid.checkYN("Do you want to continue (Y/N)? ");
            if (cont.equals("N")) {
                displayAllCreated();
                break;
            }
        }
    }

    // 4. Search function
    public ArrayList<Candidate> searchCandidate(String nameKey, int type) {
        if (candidateList.isEmpty()) {
            System.out.println("No candidates in the system.");
            return null;
        }

        //String nameKey = valid.checkInputString("Input Candidate name (First name or Last name): ").toLowerCase();
        //int type = valid.checkLimit(0, 2, "Input type of candidate (0-Experience,1-Fresher,2-Intern): ",
        //        "Type must be 0, 1 or 2");
        ArrayList<Candidate> seachList = new ArrayList<>();

        boolean found = false;
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type) {

                if (c.getFirstName().toLowerCase().contains(nameKey)
                        || c.getLastName().toLowerCase().contains(nameKey)) {
                    seachList.add(c);
//                    System.out.printf("%s %s | %d | %s | %s | %s | %d\n",
//                            c.getFirstName(), c.getLastName(),
//                            c.getBirthDate(),
//                            c.getAddress(),
//                            c.getPhone(),
//                            c.getEmail(),
//                            c.getCandidateType());
                    found = true;
                }
            }
        }
        if (found == false) {
            System.err.println("Candidate not exist.");
        }
        return seachList;
    }

    // Helper: display all candidates created (after finishing creating)
    public void displayAllCreated() {
        if (candidateList.isEmpty()) {
            System.out.println("No candidates created yet.");
            return;
        }
        System.out.println("All candidates in system:");
        System.out.printf("%-5s %-20s %-6s %-15s %-12s %-25s %-5s\n",
                "ID", "Name", "Birth", "Address", "Phone", "Email", "Type");
        for (Candidate c : candidateList) {
            System.out.printf("%-5d %-20s %-6d %-15s %-12s %-25s %-5d\n",
                    c.getCandidateId(),
                    c.getFirstName() + " " + c.getLastName(),
                    c.getBirthDate(),
                    c.getAddress(),
                    c.getPhone(),
                    c.getEmail(),
                    c.getCandidateType());
        }
    }

    private Candidate inputBasicCandidateInfo(int type) {
        int id = valid.checkId("Enter ID: ");
        String firstName = valid.checkName("Enter first name: ");
        String lastName = valid.checkName("Enter last name: ");
        int birth = valid.checkYear("Enter birth year (YYYY): ");
        String address = valid.checkInputString("Enter address: ");
        String phone = valid.checkPhone("Enter phone: ");
        String email = valid.checkEmail("Enter email: ");

        Candidate can = new Candidate(id, firstName, lastName, birth, address, phone, email, type);
        return can;
    }

    private void checkYesNo() {
        while (true) {

            System.out.println("Do you wanna continue ? (Y/N)");
            String cont = sc.nextLine().trim();
            if (cont.equalsIgnoreCase("N")) {
                displayAllCreated();
                return;
            } else if (cont.equalsIgnoreCase("Y")) {
                break;
            } else {
                System.err.println("Only Choose Y or N");
            }
        }
    }

    public void displayCadidate() {
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
    }

    public void displaySeachList(ArrayList<Candidate> seachList) {
        if (seachList == null || seachList.isEmpty()) {
            System.out.println("No results to display.");
            return;
        }
        for (Candidate c : seachList) {
            System.out.printf("%s %s | %d | %s | %s | %s | %d\n",
                            c.getFirstName(), c.getLastName(),
                            c.getBirthDate(),
                            c.getAddress(),
                            c.getPhone(),
                            c.getEmail(),
                            c.getCandidateType());
        }
    }
}