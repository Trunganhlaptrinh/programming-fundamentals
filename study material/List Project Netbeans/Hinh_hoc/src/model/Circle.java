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
        this.r = r;
    }

    @Override
    public void inputNumber() {

        double radius = Validation.checkDouble("Enter radius of Circle:");
        setR(radius);

    }

    @Override
    public double getPerimeter() {
        return r * 2 * Math.PI; // 2.pi.r
    }

    @Override
    public double getArea() {
        return r * r * Math.PI; // pi.r^2

    }

    @Override
    public void prinResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + getR());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
