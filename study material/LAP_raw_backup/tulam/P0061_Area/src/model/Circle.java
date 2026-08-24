package model;

import model.Shape;
import util.CheckValue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author laptop368
 */
public class Circle extends Shape {

    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if (r > 0) {
            this.r = r;
        } else {
            throw new IllegalArgumentException("Greater than 0");
        }
    }

    @Override
    public void prinResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + r);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public double getPerimeter() {
        return r * 2 * Math.PI;
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;

    }

    @Override
    public void inputNumber() {
        while (true) {
            try {
                double ra = CheckValue.getFloat("Please input radius of Circle:");
                setR(ra);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a positive integer");
            }
        }
    }
}
