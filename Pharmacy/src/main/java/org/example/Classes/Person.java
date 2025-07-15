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
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;
    public String name;
    public int age;
    public String gender;
    public String email;
    public String telephoneNumber;
    public String insuranceCompany ;
    public String insuranceNumber ;
    private String type;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.email = "Unknown";
        this.telephoneNumber = "Unknown";
        this.insuranceCompany = "Unknown";
        this.insuranceNumber = "Unknown";
    }

    public Person(String name, int age, String gender, String email, String telephoneNumber , String insuranceCompany , String insuranceNumber , String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.insuranceCompany = insuranceCompany;
        this.insuranceNumber = insuranceNumber;
        this.type = type;
    }
    public Person(String name, int age, String gender, String email, String telephoneNumber ,String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.type = type;
    }

    public abstract String getName();
    public abstract int getAge();
    public abstract String getGender();
    public abstract String getEmail();
    public abstract String getPhoneNumber();
    public abstract String getInsuranceCompany();
    public abstract String getInsuranceNumber();

    public int getId()
    {
        return personId;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId 
        + ", name=" + name 
        + ", age=" + age 
        + ", gender=" + gender 
        + ", email=" + email 
        + ", telephoneNumber=" + telephoneNumber 
        + ", insuranceCompany=" + insuranceCompany
        + ", insuranceNumber=" + insuranceNumber + "]";
    }

    
}