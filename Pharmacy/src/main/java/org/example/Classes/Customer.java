package org.example.Classes;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Table(name = "Customer")
public class Customer extends Person {
    private String address;
    private int point;

    public Customer() {
        super();
        this.address = "Unknown";
        this.point = 0;
    }

    public Customer(String name, int age, String gender, String email, String telephoneNumber, String address , String insuranceCompany ,
    String insuranceNumber) {
        super(name, age , gender, email, telephoneNumber , insuranceCompany , insuranceNumber , "customer");
        this.address = address;
        this.point = 0;
    }

    public Customer(String name, int age, String gender, String email, String telephoneNumber, String address , String insuranceCompany ,
    String insuranceNumber , int point) {
        super(name, age , gender, email, telephoneNumber , insuranceCompany , insuranceNumber , "customer");
        this.address = address;
        this.point = point;
    }

    public void addPoints(int point) {
        this.point += point;
    }
    
    int getPoints() {
        return point;
    }

    public String getName()
    {
        return super.name;
    }
    public int getAge()
    {
        return super.age;
    }
    public String getGender()
    {
        return super.gender;
    }
    public String getEmail()
    {
        return super.email;
    }
    public String getPhoneNumber()
    {
        return super.telephoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public String getInsuranceCompany() {
        return super.insuranceCompany;
    }
    public String getInsuranceNumber() {
        return super.insuranceNumber;
    }
}