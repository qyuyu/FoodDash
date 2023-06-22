package com.qingyu.onlineorder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity // for creating a table
@Table(name = "cart") // for naming a column
public class Cart implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id // for creating a primary keyL: unique
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double totalPrice;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    // mappedBy: cohere to the foreign key in the OrderItem
    // cascade: update, insert, delete together in both tables (cart and orderitem)
    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
