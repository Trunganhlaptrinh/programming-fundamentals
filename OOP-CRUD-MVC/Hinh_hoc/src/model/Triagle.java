package model;

import util.Validation;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author laptop368
 */
public class Triagle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triagle() {
    }

    public Triagle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Getter
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    // Setter
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    // check 3 canh
    public boolean checkTriagle(double a, double b, double c) {
        if (a + b > c && b + c > a && c + a > b) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void inputNumber() {
        while (true) {
            double a = Validation.checkDouble("Enter sideA: ");
            setSideA(a);
            double b = Validation.checkDouble("Enter sideB: ");
            setSideB(b);
            double c = Validation.checkDouble("Enter sideC: ");
            setSideC(c);
            if (!checkTriagle(a, b, c)) {
                System.err.println("Triangle dont exist");
            } else {
                break;
            }
        }

    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)); // he-rong
    }

    @Override
    public void prinResult() {
        System.out.println("---- Triagle ----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
