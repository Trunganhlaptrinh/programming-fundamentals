package view;

import model.Circle;
import model.Rectangle;
import model.Triagle;

import util.Validation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trung anh
 */
public class Main {

    public static void main(String[] args) {

        Validation validation = new Validation();

        Triagle triagle = new Triagle();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        while (true) {
            System.out.println("===== Calculator Shape Program =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");

            int choice = validation.checkLimit("Enter 1-4: ", "ERROR !!! Must choose 1 to 4");
            switch (choice) {
                case 1:
                    circle.inputNumber();
                    circle.prinResult();
                    break;
                case 2:
                    rectangle.inputNumber();
                    rectangle.prinResult();
                    break;
                case 3:
                    triagle.inputNumber();
                    triagle.prinResult();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
            }
        }

    }
}
