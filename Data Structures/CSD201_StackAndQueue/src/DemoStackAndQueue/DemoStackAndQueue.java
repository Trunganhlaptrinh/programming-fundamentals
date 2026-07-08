/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoStackAndQueue;

import java.util.Stack;

/**
 *
 * @author Trung Anh
 */
// 20. Valid Parentheses
public class DemoStackAndQueue {

    // true và false nên phải boolean
    // static ???
    public boolean isValid(String s) {
        // khởi tạo stack
        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray()) {  //chuyển chuỗi thành mảng các kí tự 
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);  // thêm ([{ vào stack
                
                
            }
            // i = )]} kiểm tra từ đây đi vào thì sẽ check ở đây
            else {
                // chuỗi rỗng --> false
                if (s.isEmpty()) {
                    return false;
                }

                // tạo
                char lay_ra = stack.pop(); // POP là hàm chính
                //POP vẫn đang mà dấu mở
                
                // kiểm tra 
                
                // top != ( mới đúng vì không phải lúc nòa cũng luôn luôn là ( phải kiểm tra đúng 
                if (i == ')' && lay_ra == '(') { // tìm đúng (
                    return true;
                } else if (i == ']' && lay_ra == '[') {
                    return true;
                } else if (i == '}' && lay_ra == '{') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

    }
}
