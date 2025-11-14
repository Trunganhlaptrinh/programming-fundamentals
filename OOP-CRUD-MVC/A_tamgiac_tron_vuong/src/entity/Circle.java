
package entity;

import operation.Validation;

/**
 *
 * @author Trung Anh
 */
public class Circle extends Shape {

    Validation validation = new Validation();
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
        double inputR = validation.checkInputDouble("Enter R: ", "ERROR !!! must > 0");
        setR(inputR);
    }

    @Override
    public double getPerimeter() {
        return r * 2 * Math.PI; // 2.pi.r
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;
    }

    @Override
    public void printResult() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
