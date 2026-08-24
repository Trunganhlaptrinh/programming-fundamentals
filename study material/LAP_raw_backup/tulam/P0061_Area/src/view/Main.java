package view;


import model.Circle;
import model.Rectangle;
import model.Triagle;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author laptop368
 */
public class Main {

    public static void main(String[] args) {
        Triagle tri = new Triagle();
        Circle ci = new Circle();
        Rectangle m = new Rectangle();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Calculator Shape Program =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("0. Exit");
            System.out.print("Choose shape: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    ci.inputNumber();
                    ci.prinResult();
                    break;
                case "2":
                    m.inputNumber();
                    m.prinResult();
                    break;
                case "3":
                    tri.inputNumber();
                    tri.prinResult();
                    break;
                case "0":
                System.out.println("Goodbye!");
                return;
                default:
                System.err.println("Nhập 0-3: ");
            }
        }

    }
}
