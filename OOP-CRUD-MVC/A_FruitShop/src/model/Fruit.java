/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Trung Anh
 */
public class Fruit {

    private static int idCounter = 1; // auto count id
    private int id;
    
    private String name;
    private double price;
    private int quantity;
    private String origin; // source - nguồn gốc

    // Contructor
    public Fruit() {
    }

    public Fruit(String name, double price, int quantity, String origin) {
        this.id = idCounter++; // tang id khi them fruit
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    // Setter --> chỉ set số lượng
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
