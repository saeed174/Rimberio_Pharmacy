package org.example.Classes;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Table(name = "Medicine")
public class Medicine extends Product {
    private String Medicine_type;
    private String Medicine_company;
    private String Medicine_dose;

    public Medicine() {
        super();
    }

    public Medicine(String name, double cost, int quantity, String expireDate, String Medicine_type,
            String Medicine_company, String Medicine_dose) {
        super(name, cost, quantity, expireDate , "Medicine");
        this.Medicine_type = Medicine_type;
        this.Medicine_company = Medicine_company;
        this.Medicine_dose = Medicine_dose;
    }

    public void Display() {
        super.Display();
        System.out.println("Medicine type: " + Medicine_type);
        System.out.println("Medicine company: " + Medicine_company);
        System.out.println("Medicine dose: " + Medicine_dose);
    }

    public String getMedicineType() {
        return Medicine_type;
    }

    String getCompany() {
        return Medicine_company;
    }

    String getDose() {
        return Medicine_dose;
    }

}
