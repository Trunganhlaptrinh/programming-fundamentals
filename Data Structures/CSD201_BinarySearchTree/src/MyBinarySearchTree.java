/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
public class MyBinarySearchTree {

    Node root;

    // khởi tạo cây rỗng
    public MyBinarySearchTree() {
        root = null;
    }

    // xóa toàn bộ cây (gán root = null)
    void clear() {
        root = null;
    }

    // kiểm tra cây rỗng không
    boolean isEmpty() {
        return root == null;
    }

    // thêm 1 giá trị mới vào cây
    public void insert(int newValue) {
        Node newNode = new Node(newValue);

        // nếu cây đang rỗng → node mới là root luôn
        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node checkNode = root;     // node dùng để kiểm tra từng vị trí trong cây
        Node moveNode = null;      // node cha đi theo sau checkNode

        // tìm vị trí thích hợp để chèn
        while (checkNode != null) {
            if (checkNode.value == newValue) {
                // nếu giá trị đã tồn tại → không chèn nữa
                return;
            }
            moveNode = checkNode;

            if (newValue < checkNode.value) {
                checkNode = checkNode.left;
            } else {
                checkNode = checkNode.right;
            }
        }

        // double check --> moveNode
        if (moveNode == null) {
            root = newNode;
            return;
        }

        // sau vòng lặp, parent là node cha để gắn newNode vào
        if (newValue < moveNode.value) {
            moveNode.left = newNode;
        } else {
            moveNode.right = newNode;
        }

    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
        System.out.print(" ");
    }

    public void breathFirst() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enQueue(root);
        Node p;

        while (!q.isEmpty()) {
            p = q.deQueue();
            if (p.left != null) {
                q.enQueue(p.left);
            } else {
                q.enQueue(p.right);
            }
            System.out.println(p.value + " ");
        }

    }

    void delete(Node x) {
        if (isEmpty()) {
            return;
        }

        Node p = root, f = null;
        while (p != null) {
            if (p.value == x.value) {
                break;
            }
            f = p;
            if (p.value > x.value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        //No child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
                return;
            }

            if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        // một child
        //1 child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
                return;
            }

            if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }

        } else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
                return;
            }

            if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }

    }

    public static void main(String[] args) {
        MyBinarySearchTree mytree = new MyBinarySearchTree();

        mytree.insert(10);
        mytree.insert(9);
        mytree.insert(7);
        mytree.insert(15);
        mytree.insert(18);
        mytree.insert(2);
        mytree.preOrder();

    }
}
