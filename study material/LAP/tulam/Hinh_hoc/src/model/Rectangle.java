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
public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean check() {
        if (length > width) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void inputNumber() {
        while (true) {
            double l = Validation.checkDouble("nhập dài: ");
            setLength(l);
            double w = Validation.checkDouble("nhập rộng: ");
            setWidth(w);
            if (!check()) {
                System.err.println("dài phải lớn hơn rộng");
            } else {
                break;
            }
        }

    }

    @Override
    public double getPerimeter() {
        return width + length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void prinResult() {
        System.out.println("-----Circle-----");
        System.out.println("Width: " + getWidth());
        System.out.println("Length: " + getLength());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
