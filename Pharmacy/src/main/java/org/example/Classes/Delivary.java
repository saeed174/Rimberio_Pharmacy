package org.example.Classes;

import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Table(name = "Delivary")
public class Delivary extends PharmacyEmployee {
    @OneToMany
    private List<Order> currentOrder;
    private String custumerAddress;
    private String deliveryDate ;
    

    public Delivary() {
        super();
        currentOrder = null;
        custumerAddress= "UNKOWN";
        deliveryDate = "UNKOWN";
    }
    

    public Delivary(String name, int age, String gender, String email, String telephoneNumber, String insuranceCompany,
            String insuranceNumber, String position, float workingHours,
            String workingShift, float salary, float salaryBonus, List<Order> currentOrder,
            Customer currentCustomer, String custumerAddress, String deliveryDate) {
        super( name,  age,  gender,  email,  telephoneNumber ,  insuranceCompany ,  insuranceNumber,  position,  workingHours,  workingShift,  salary,  salaryBonus);
        this.currentOrder = currentOrder;
        this.custumerAddress = custumerAddress;
        this.deliveryDate = deliveryDate;
    }

    public Delivary(String name , int age ,String gender ,String email ,String telephoneNumber , float workingHours, String workingShift,String stateOfOrder,String deliveryDate , List<Order> currentOrder) {
        super(name, age, gender, email, telephoneNumber, "Unknown", "Unknown", workingHours, workingShift);
        this.currentOrder=currentOrder;
        this.deliveryDate=deliveryDate;
    }

    public Delivary(String name , int age ,String gender ,String email ,String telephoneNumber , String insuranceCompany , String insuranceNumber, float workingHours, String workingShift)
    {
        super(name, age, gender, email, telephoneNumber, insuranceCompany, insuranceNumber, workingHours, workingShift);
    }


    public void setCurrentOrder(List<Order> currentOrder) {
        this.currentOrder = currentOrder;
    }


    public void setCustumerAddress(String custumerAddress) {
        this.custumerAddress = custumerAddress;
    }


    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public List<Order> getCurrentOrders() {
        return currentOrder;
    }

    public String getCustumerAddress() {
        return custumerAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    void DeliverOrder() {
        System.out.println("Delivering order to " + custumerAddress + " on " + deliveryDate);
        for (Order order : currentOrder) {
            order.DisplayOrder();

        }
        System.out.println("Order delivered successfully!");
    }
}