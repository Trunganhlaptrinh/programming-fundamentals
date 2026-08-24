/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CandidateManagement;
import java.util.ArrayList;
import model.Candidate;
import util.Validation;

/**
 *
 * @author Trung Anh
 */
public class Main {

    public static void main(String[] args) {

        Validation valid = new Validation();
        CandidateManagement manage = new CandidateManagement();

        while (true) {
            System.out.println("========= CANDIDATE MANAGEMENT SYSTEM =========");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");

            int choice = valid.checkLimit(1, 5, "Your choice (1-5): ", "Must enter 1-5:");

            switch (choice) {
                case 1:
                    manage.addExperience();
                    break;
                case 2:
                    manage.addFresher();
                    break;
                case 3:
                    manage.addIntern();
                    break;
                case 4:
                    // enter
                    String nameKey = valid.checkInputString("Input Candidate name (First name or Last name): ").toLowerCase();
                    int type = valid.checkLimit(0, 2, "Input type of candidate (0-Experience,1-Fresher,2-Intern): ","Type must be 0, 1 or 2");
                    
                    // seach
                    ArrayList<Candidate> seachList = manage.searchCandidate(nameKey, type);
                    
                    // display
                    manage.displaySeachList(seachList);
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    return;
                    
            }
        }
    }
}