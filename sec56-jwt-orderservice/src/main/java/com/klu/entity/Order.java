package com.klu.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String product;
    private Integer quantity;
    private Double price;
    private String status;

    public Order() 
    {
    }

    public Order(String username, String product, Integer quantity,Double price, String status) 
    {
        this.username = username;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}