package com.huzihao.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * An object of cart
 *
 * @author huzihao
 * @since 2020/10/25 14:00
 */
public class Cart {
    private Integer totalNumber;
    private BigDecimal totalPrice;
    private List<CartItem> items = new ArrayList<>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalNumber=" + totalNumber +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
