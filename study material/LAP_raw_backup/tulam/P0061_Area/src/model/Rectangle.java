package model;

import util.CheckValue;
import model.Shape;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author laptop368
 */
public class Rectangle extends Shape {

    private double lenghth, width;

    public Rectangle() {
    }

    public Rectangle(double lenghth, double width) {
        this.lenghth = lenghth;
        this.width = width;
    }

    public double getLenghth() {
        return lenghth;
    }

    public void setLenghth(double lenghth) {
        if (lenghth > 0) {
            this.lenghth = lenghth;
        } else {
            throw new IllegalArgumentException("lớn hơn 0");
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("lớn hơn 0");
        }
    }

    @Override
    public void prinResult() {

    }

    @Override
    public double getPerimeter() {
        return width + lenghth;
    }

    @Override
    public double getArea() {
        return width * lenghth;
    }

    public boolean check() {
        if (lenghth > width) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void inputNumber() {
        while (true) {
            try {
                double l = CheckValue.getFloat("nhập dài: ");
                setLenghth(l);
                double r = CheckValue.getFloat("nhập rộng: ");
                setWidth(r);
                if (!check()) {
                    System.err.println("dài phải lớn hơn rộng");
                } else {
                    break;
                }
            } catch (NumberFormatException e) { // Bat loi khi nhap khong phai so nguyen
                System.out.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
}
