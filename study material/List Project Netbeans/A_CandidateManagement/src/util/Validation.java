/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Trung Anh
 */
package util;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Validation utilities (nhập & kiểm tra)
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    // ok
    public int checkLimit(int min, int max, String mess, String err) {
        while (true) {
            try {
                System.out.print(mess);
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int v = Integer.parseInt(line);
                if (v < min || v > max) {
                    System.err.println(err);
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.err.println("Need number");
            }
        }
    }

    // ok
    public String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (input.matches("^[A-Za-z\\s]+$")) {

                return input;
            }
            System.err.println("Invalid input (letters only)");

        }
    }

    // ok
    public String checkName(String message) {
        while (true) {
            System.out.print(message);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!name.matches("^[A-Za-z\\s]+$")) {
                System.err.println("Invalid input (letters only)");
                continue;
            }
            return name;
        }
    }

    // ok
    public int checkYear(String message) {

        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }

                // check phải 4 số --> length
                if (input.length() != 4) {
                    System.err.println("ERROR !!! Follow format YYYY");
                    continue;
                }

                // chuyển thành số
                int y = Integer.parseInt(input);
                if (y < 1900 || y > 2025) {
                    System.err.println("Year must be between 1900 and 2025");
                    continue;
                }
                return y;
            } catch (NumberFormatException e) {
                System.err.println("Need number");
            }
        }
    }

    // ok
    public String checkPhone(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (input.length() >= 10) {
                System.err.println("Phone must be digits only and at least 10 characters");
                continue;
            }
            if (!input.matches("\\d{10,}")) {
                System.err.println("Phone must be digits only and at least 10 characters");
                continue;
            }
            return input;
        }
    }

    public int checkExpInYear(String message) {
        while (true) {
            try {
                System.out.print(message);
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int v = Integer.parseInt(line);
                if (v < 0 || v > 100) {
                    System.err.println("Year of experience must be between 0 and 100");
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.err.println("Need number");
            }
        }
    }

    // xem lại student managemnt, code ơn hơn thì phải 
    public String checkGraduationRank(String message) {
        while (true) {
            System.out.print(message);
            String r = sc.nextLine().trim();
            if (r.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            if (!r.equalsIgnoreCase("Excellence")
                    && !r.equalsIgnoreCase("Good")
                    && !r.equalsIgnoreCase("Fair")
                    && !r.equalsIgnoreCase("Poor")) {
                System.err.println("Rank must be one of: Excellence / Good / Fair / Poor");
                continue;
            }
            // normalize capitalization
            String cap = r.substring(0, 1).toUpperCase() + r.substring(1).toLowerCase();
            return cap;
        }
    }

    public String checkYN(String message) {
        while (true) {
            System.out.print(message);
            String r = sc.nextLine().trim();
            if (r.equalsIgnoreCase("Y") || r.equalsIgnoreCase("N")) {
                return r.toUpperCase();
            }
            System.err.println("ERROR !!! Must enter Y or N");
        }
    }

    public String checkEmail(String message) {
        //Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }

            // regex được trung anh tối ưu lại: "^[A-Za-z0-9]+@[a-z.]{2,}\\.[a-z]{2,}$";
            
            
            // -----------------
            // Analize --> email 
            // -----------------
            
            // Email: <name> @ <domain>.<end>
            
            // <name> ==> chữ hoa + chu thuong + so
            // ex: trunganh, trung123, Anh456
            
            // <domain> ==> chu thuong
            // ex: <domain> ==> @gmail / @fpt
            
            // <end> ==> chu thuong va "."
            // ex: <end> ==> .com / .edu / .uk / .org
            
            // lam sao de co them 1 "." nua o giup domain ??? result ==> @fpt "." edu "." vn
            // luc xu li @gmail ==> cho phep them "." thi sao ??? --> @[a-z.]{2,}         
            // --> them sub --> them . --> abc.xyz.com
            // @gmail.com --> khong error
            // fpt.edu.vn --> khong err
            // --> mission finish :>
            
            if (input.matches("^[A-Za-z0-9]+@[a-z.]{2,}\\.[a-z]{2,}$")) {
                return input;
            }

//            if (!pattern.matcher(input).matches()) {
//                System.err.println("Invalid email format");
//                continue;
//            }
            return input;
        }
    }
}
