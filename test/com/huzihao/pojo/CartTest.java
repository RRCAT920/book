package com.huzihao.pojo;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/25 14:26
 */
public class CartTest {

    @Test
    public void addItem() {
        var cart = new Cart();

        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(1L), BigDecimal.valueOf(1L)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        var cart = new Cart();

        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(1L), BigDecimal.valueOf(1L)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        var cart = new Cart();

        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(1L), BigDecimal.valueOf(1L)));

        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateItemNumber() {
        var cart = new Cart();

        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(1L), BigDecimal.valueOf(1L)));

        cart.deleteItem(1);
        cart.updateItemNumber(2, 2);
        System.out.println(cart);
    }
}