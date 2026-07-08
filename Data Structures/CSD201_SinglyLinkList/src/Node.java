/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
public class Node {
    
    int value;      // dữ liệu, đang học thì để là int, đi thì thì thường là object
    Node next;      // bản chất là con trỏ để tham chiếu
    
    // Contructor
    public Node() {  
        
    }

    // tạo Node và trỏ tiếp theo
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    // Node cuối
    public Node(int value) {
        this.value = value;
        next = null;    // lí thuyết thì không cần viết cái này, nhưng cần phải viết ra cho tường minh dễ hiểu bản chất
        
    }  
}
