package org.example.Classes;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Cacheable
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private double cost;
    private String expireDate;
    private int quantity;
    private static int NumberOfproducts;
    private String type;

    Product() {
        NumberOfproducts++;
        this.name = "Unknown";
        this.cost = 0.0;
        this.expireDate = "Unknown";
    }

    Product(String name, double cost, int quantity, String expireDate , String type) {
        this.name = name;
        this.cost = cost;
        this.expireDate = expireDate;
        this.quantity = quantity;
        NumberOfproducts += quantity;
        this.type = type;
    }

    public void Display() {
        System.out.println("Product name: " + name);
        System.out.print("\tProduct cost: " + cost);
        System.out.println("\tProduct Expiry Date: " + expireDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public static int getNumberOfproducts() {
        return NumberOfproducts;
    }

    public static void setNumberOfproducts(int numberOfproducts) {
        NumberOfproducts = numberOfproducts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int Id) {
        this.productId = Id;

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setexpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getName() {
        return name;

    }

    public int  getId() {
        return productId;

    }

    public static int getNumberOfProducts() {
        return NumberOfproducts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
