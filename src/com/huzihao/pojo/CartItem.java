package com.huzihao.pojo;

import java.math.BigDecimal;

/**
 * Item of Cart
 *
 * @author huzihao
 * @since 2020/10/25 13:55
 */
public class CartItem {
    private Integer id;
    private String name;
    private Integer number; // Number of cart item
    private BigDecimal price;
    // TODO: 2020/10/25 这个总价没有必要写成属性
    private BigDecimal totalPrice; // number * price

    public CartItem(Integer id, String name, Integer number, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
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
}
