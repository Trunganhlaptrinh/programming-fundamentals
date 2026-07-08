/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
public class Mylist {

    Node head;
    Node tail;

    // list chưa có gì
    public Mylist() {
        head = tail = null;
    }

    // check list có rỗng không (không có gì cả)
    public boolean isEmpty() {
        return head == null;
    }

    // thêm node đầu
    void addFirst(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;   // dịch: node trỏ đến head, next là trỏ
            head = node;    // gán lại head vào node mới thêm, đúng thực sự là head

        }

    }

    // thêm node cuối
    void addLast(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = head;
            tail = node;

        }

    }

    // thêm node vào ví trị cụ thể nào đó 
    void addIndex(int value, int index) {
        if (index < 0) {     // rỗng, index âm --> thoát luôn
            return;
        }
        if (index == 0) {   // index = 0 --> addFirst luôn
            addFirst(value);
        } else {
            Node present = head;
            int pos = 0;

            // duyệt tìm index mà mình muốn thêm
            while (present != null) {    // duyệt tất cả phần tử trong list vì = null thì tự động thoát ra vòng lặp rồi
                if (index - 1 == pos) {      //kiểm tra nếu tìm đúng vị trí thì break
                    break;
                }
                // nếu chưa tìm được đúng vị trí thì chuyển sang node tiếp theo và tăng pos để tìm  
                present = present.next;
                pos++;
            }

            // bước nối node lại 
            if (present == null) {   // xử lí ngoại lệ, = null thoát luôn
                return;
            } else {        // nối nó lại thui
                Node node = new Node(value);
                node.next = present.next;
                present.next = node;
            }
        }
    }

    void deleteLast() {

        if (isEmpty()) {    // xử lí ngoại lệ, = null thoát luôn
            return;
        }
        // tạo đối tượng để duyệt
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    int printDeleteLast() {

        if (isEmpty()) {    // xử lí ngoại lệ, = null thoát luôn
            return -333;
        }
        // tạo đối tượng để duyệt
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        int printValue = current.next.value; 
        current.next = null;
        tail = current;
        
        return printValue;
    }

    void deleteFirst() {
        
        if(isEmpty()) {     // xử lí ngoại lệ, = null thoát luôn
            return;
        } 
        
        else {        // gán thành thằng bên cạnh nó
          head = head.next;  
        }
    }
    
    int printDeleteFirst() {
        
        int printFirst = head.value;
        
        if(isEmpty()) {     
            return -999;
        } 
        
        else {                    
            head = head.next;  
        }
        
        return printFirst;
    }
    
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Mylist ml = new Mylist();
        ml.addFirst(5);
        ml.addFirst(1);
        ml.addFirst(2);
        ml.addFirst(3);
        ml.addFirst(100);
        ml.addLast(30);
        ml.addIndex(99, 3);
        ml.deleteLast();
        
        ml.display();
        
        int x = ml.printDeleteLast();
        if(x == -333) {
            System.out.println("List is empty");
        } else {
            System.out.println("Deleted: " + x);
        }
        
        ml.display();
        
        
    }
}
