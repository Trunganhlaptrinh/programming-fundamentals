/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
package view;

import controller.CandidateManagement;
import util.Validation;

/*
 * Main: menu và gọi controller
 */
public class Main {
    public static void main(String[] args) {
        CandidateManagement manage = new CandidateManagement();
        Validation valid = new Validation();

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
                    manage.searchCandidate();
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    return;
            }
        }
    }
}

