package com.huzihao.service;

import com.huzihao.pojo.Cart;
import com.huzihao.pojo.CartItem;
import com.huzihao.service.impl.OrderServiceImpl;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/26 18:16
 */
public class OrderServiceTest {
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        var cart = new Cart();

        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(1, "Java从入门到精通", 1, BigDecimal.valueOf(10L), BigDecimal.valueOf(10L)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(1L), BigDecimal.valueOf(1L)));

        System.out.println(orderService.createOrder(cart, 1));
    }
}