package util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public int checkLimit() {

        while (true) {
            try {
                System.out.println("Enter 1-4: Midnight 9/10/25");
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen

                // hoặc không phải và
                if (number <= 0 || number > 4) {  // Neu so <= 0 thi khong hop le
                    System.err.println("Error: phải nhập từ 1-4");
                } else {
                    return number;   // Neu hop le thi tra ve gia tri
                }
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkString(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                // thiếu []
                // thiếu +
                if (input.matches("^[A-Za-z\\s]+$")) {
                    return input;
                } else {
                    System.err.println("chỉ nhập chữ và cho phép khoảng cách");

                }
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public String checkTaskType(String mess, int i, int i0, String error) {
        while (true) {
            System.out.println("===== Task Type =====");
            System.out.println("1. Code");
            System.out.println("2. Test");
            System.out.println("3. Design");
            System.out.println("4. Review");
            System.out.println(mess);

            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Error: Input cannot be empty");
                continue;
            }
            switch (input) {
                case "1":
                    return "Code";
                case "2":
                    return "Test";
                case "3":
                    return "Design";
                case "4":
                    return "Review";    //code của trung anh

            }
            System.err.println(error);
        }
    }

    public String checkDate(String mess) {
        

            while (true) {
                sdf.setLenient(false);
                try {
                    System.out.println(mess);
                    String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                    if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                        System.err.println("Error: Input cannot be empty");
                        continue;
                    }

                    if (input.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                        return input;
                    } else {
                        System.err.println("nhap lại");
                    }

                } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                    System.err.println("Error: Invalid number format. Please enter a positive integer");
                }
            }
    }

    public double checkFromToPlan(String mess, double min, double max, String err) {
        while (true) {
            try {
                System.out.println(mess);
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                double number = Double.parseDouble(input);  // Chuyen chuoi sang so nguyen

                if (number >= min && number <= max && number % 0.5 == 0) {  // Neu so <= 0 thi khong hop le
                    return number;   // Neu hop le thi tra ve gia tri
                } else {
                    System.err.println(err);
                }
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

    public int deleteId(String mess) {
        while (true) {
            try {
                System.out.println(mess);
                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
                    System.err.println("Error: Input cannot be empty");
                    continue;
                }
                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen

                return number;
            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
                System.err.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }

}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package util;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;
//import model.Task;
//
///**
// *
// * @author Trung Anh
// */
//public class Validation {
//    
//    // Enter on computer
//    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  // format đề bài là dd-MM-yyyy
//    Scanner sc = new Scanner(System.in);
//    
//    
//    // kiểm tra giới hạn nhập vào
//    public int checkLimit(String message) {
//        
//        while (true) {
//            try {
//                System.out.print(message);
//                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
//                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
//                    System.out.println("EMPTY! Enter again");
//                    continue;
//                }
//                int number = Integer.parseInt(input);  // Chuyen chuoi sang so nguyen
//                if (number <= 0 && number > 4) {  // Neu so <= 0 thi khong hop le
//                    System.out.println("Phải nhập từ 1-4");
//                } else {
//                    return number;   // Neu hop le thi tra ve gia tri
//                }
//            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
//                System.out.println("Error: Invalid number format. Please enter a positive integer");
//            }
//        }
//    }
//
//    // Add
//    // step 1 require name 
//    public String checkInputString(String mess) {
//        
//        while (true) {
//            try {
//                System.out.println(mess);
//                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
//                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
//                    System.out.println("EMPTY! Enter again");
//                    continue;
//                }
//                // xử lí điều kiện string
//
//                // ^ và $ ==> đầu và cuối
//                // [] kí tự
//                // + một hoặc nhiều hơn, nhưng đa số là lấy nhiều hơn => []+ la 1 hoac nhieu hon 1 ki tu
//                // A-Za-z from a to z ca hoa va thuong
//                // \\s khoang trang
//                // lí thuyết thì là \s nhưng thì thực tế thì khác phải \\s thì java nó mới hiểu
//                if (!input.matches("^[A-Za-z\\s]+$")) {
//                    System.err.println("Can not digits");
//                    continue;
//                }
//                return input;
//            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
//                System.out.println("Error: Invalid number format. Please enter a positive integer");
//            }
//        }
//    }
//
//    public String checkTaskType() {
//        
//        while (true) {
//            try {
//                System.out.println("-----Task type id-----");
//                System.out.println("1. Code");
//                System.out.println("2. Test");
//                System.out.println("3. Design");
//                System.out.println("4. Review");
//                System.out.print("Task Type: ");
//                String input = sc.nextLine().trim(); // Doc chuoi nguoi dung nhap va loai bo khoang trang dau cuoi
//                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
//                    System.out.println("EMPTY! Enter again");
//                    continue;
//                }
//                switch (input) {
//                    case "1":
//                        return "Code";
//                    case "2":
//                        return "Test";
//                    case "3":
//                        return "Design";
//                    case "4":
//                        return "Review ";
//
//                }
//            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
//                System.out.println("Error: Invalid number format. Please enter a positive integer");
//            }
//        }
//
//    }
//
//    public String checkDate() {
//        
//        while (true) {
//            
//            // 32 --> 1
//            // 33 --> 2
//            // .. --> ...
//            // mac dinh la true --> false => tranh gap error
//            sdf.setLenient(false); //
//            
//            try {
//                System.out.print("Date: ");
//                String input = sc.nextLine().trim();
//                if (input.isEmpty()) {   // Neu chuoi rong thi bao loi
//                    System.out.println("EMPTY! Enter again");
//                    continue;
//                }
//                // \\d --> so hoac tring nhung la dạng số (trong chuỗi là số) vd: "7"
//                // {x} --> co x lan xuat hien
//                // - theo form thôi, dùng để ngăn cách ngày tháng
//                if (input.matches("^\\d{2}-\\d{2}-\\d{4}$") == false) {
//                    System.err.println("Invalid date! Format must be dd-MM-yyyy");
//                    continue;
//                }
//                // 
////                Date date = sdf.parse(input); // chuyển từ string -> date
////                return sdf.format(date);
//                return input;
//            } catch (Exception e) {  // Bat loi khi nhap khong phai so nguyen
//                System.out.println("Error: Invalid number format. Please enter a positive integer");
//            }
//        }
//    }
//
//    public double checkFromToPlan(String mess, double min, double max) {
//        while (true) {
//            try {
//                System.out.print(mess);
//                String input = sc.nextLine().trim(); 
//                if (input.isEmpty()) {   
//                    System.err.println("EMPTY! Enter again");
//                    continue;
//                }
//                double number = Double.parseDouble(input);  // 
//                if (number < min || number > max || number % 0.5 != 0) {  // 1 task / 30 min --> from to 30min
//                    System.err.println(" Time must in " + min + " to " + max);
//                } else {
//                    return number;   // Neu hop le thi tra ve gia tri
//                }
//            } catch (NumberFormatException e) {  // Bat loi khi nhap khong phai so nguyen
//                System.err.println("Error: Invalid number format. Please enter a positive integer");
//            }
//        }
//    }
//
//    public int checkChoice(ArrayList<Task> taskList) {
//        while (true) {
//            try {
//                
//                String input = sc.nextLine().trim();
//                if (input.isEmpty()) {
//                    System.err.println("Can not empty");
//                    continue;
//                }
//                int number = Integer.parseInt(input);
//                for(int i = 0; i < taskList.size(); i++) {
//                    
//                    
//                    // .get lấy ở vị trí
//                    // nhưng chưa biết lấy phần tư nào của đối tượng nên
//                    // getID là chỉ lấy ID từ đối tượng 
//                    // --> .get(i),getID() là lấy giá trị ID của tối tượng i
//                    if(taskList.get(i).getId() == number) {
//                        return i;
//                    }
//                    System.out.println("can not found ID");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("need number");
//            }
//        }
//    }
//}
