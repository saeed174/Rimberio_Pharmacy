package org.example.Classes;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Cacheable
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> products = new ArrayList<>();
    @ManyToOne
    private Customer customer;
    private String TypeOfPayment;


    public Order(List<OrderItem> products, Customer customer, String paymentMethod) {
        this.products = products;
        this.customer = customer;
        this.TypeOfPayment = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void AddProducts(Product product , int quantity) {
        products.add(new OrderItem(product, quantity, this));
    }
    public void RemoveProducts(Product product , int quantity) {
        for(OrderItem orderItem : products) {
            if(orderItem.getProduct().equals(product)) {
                if(orderItem.getQuantity() >= quantity) {
                    orderItem.setQuantity(orderItem.getQuantity() - quantity);
                    if(orderItem.getQuantity() == 0) {
                        products.remove(orderItem);
                    }
                } else {
                    System.out.println("Not enough quantity to remove.");
                }
                return;
            }
        }
    }
    public int CalculateTotal()
    {
        return products.size();
    }
    public double CalculateCost ()
    {
        double cost=0;
        for(OrderItem orderItem : products)
        {
            cost += orderItem.getProduct().getCost();
        }
        return cost;
    }
    public void DisplayOrder()
    {
        System.out.println("Order Details: ");
        System.out.println("\tCustomer Name: " + customer.getName());
        System.out.println("\tCustomer Phone Number: " + customer.getPhoneNumber());
        System.out.println("\tProducts: ");
        for(OrderItem entry : products)
        {
            System.out.print("\t\tProduct Name: " + entry.getProduct().getName());
            System.out.print("\tProduct Price: " + entry.getQuantity());
            System.out.print("\tProduct Expiry Date: " + entry.getProduct().getExpireDate());
            System.out.println();
        }
        System.out.println("\tTotal Cost: " + CalculateCost());
        System.out.println("\tType of Payment: " + TypeOfPayment);
    }
    public void SetTypeOfPayment(String TypeOfPayment) {
        this.TypeOfPayment = TypeOfPayment;
    }


}
