package com.huzihao.pojo;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/26 17:41
 */
public class OrderItem {
    private Integer id;
    private String name;
    private Integer number;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String orderId;

    public OrderItem(Integer id, String name, Integer number, BigDecimal price, BigDecimal totalPrice, String orderId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
