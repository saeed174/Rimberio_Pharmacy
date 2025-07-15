package org.example.Classes;
public interface Sortable extends Comparable<Product> {

    public abstract int compareTo(Product p);
}
