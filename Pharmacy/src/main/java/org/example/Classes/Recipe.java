package org.example.Classes;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Table(name = "Recipe")
public class Recipe extends Product {
    @ManyToOne
    private PharmacyEmployee Pharmacist;
    private String recipeType;

    public Recipe() {
        super();
        this.Pharmacist = new PharmacyEmployee();
        this.recipeType = "Unknown";
    }

    public Recipe(String name, double cost, int quantity, String expireDate, String recipeType,
            PharmacyEmployee Pharmacist) {
        super(name, cost, quantity, expireDate , "Recipe");
        this.recipeType = recipeType;
        this.Pharmacist = Pharmacist;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public PharmacyEmployee getPharmacist() {
        return Pharmacist;
    }

    @Override
    public void Display() {
        System.out.println("The Pharmacist's Name is : " + Pharmacist.getName());
        System.out.println("Recipe Type is : " + getPharmacist());
        System.out.println("Expire Date is: " + getExpireDate());
        System.out.println("The Product Cost is : " + getCost());

    }

}