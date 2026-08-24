/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package managestudent;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManageStudent manage = new ManageStudent();
        Validation valid = new Validation();
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                    + "1. Create\n"
                    + "2. Find and Sort\n"
                    + "3. Update/Delete\n"
                    + "4. Report\n"
                    + "5. Exit");
            int choice = valid.checkInputLimit("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    manage.createStudent();
                    break;
                case 2:
                    manage.findAndSortStudent();
                    break;
                case 3:
                    manage.updateOrDeleteStudent();
                    break;
                case 4:
                    manage.report();
                    break;
                case 5:
                    System.out.println("Exiting program");
                    return; 

            }
        }
    }

}
