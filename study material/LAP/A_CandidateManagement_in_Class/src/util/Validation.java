/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Trung Anh
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

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

    public String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            // cho phép chữ, số và khoảng trắng ở những chỗ như address; nhưng tên chỉ chữ
            return s;
        }
    }

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
                    System.err.println("Year must be 4 digits");
                    continue;
                }

                // chuyển thành số
                int number = Integer.parseInt(input);
                if (number > 1900 && number < 2025) {

                    return number;
                }
                System.err.println("Year must be between 1900 and " + "2025");

            } catch (NumberFormatException e) {
                System.err.println("Need number");
            }
        }
    }

    public String checkPhone(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Can not empty");
                continue;
            }
            // " string // ' char  // lỏ vl
//            if (input.charAt(0) == '0') {
//                System.out.println("");
//            }
            if (input.startsWith("0") && input.length() == 10) {
                int number = Integer.parseInt(input);

                return input;
            }
            System.out.println("ERROR!!!");
//            if (!p.matches("\\d{10,}")) {
//                System.err.println("Phone must be digits only and at least 10 characters");
//                continue;
//            }

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

            if (input.contains("@") && input.contains(".")) {
                return input;
            }

            System.out.println("ERROR!!!");
//            if (!pattern.matcher(e).matches()) {
//                System.err.println("Invalid email format");
//                continue;
//            }

        }
    }

    public int checkExpInYear(String message) {
        return 1;
    }
    
    // trên lớp chưa có hàm này --> dùng nhầm checkinputstring
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
            System.err.println("Enter Y or N");
        }
    }

    public int checkId(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    System.err.println("Can not empty");
                    continue;
                }
                int v = Integer.parseInt(line);
                
                return v;
            } catch (NumberFormatException ex) {
                System.err.println("Need number");
            }
        }
    }
}
