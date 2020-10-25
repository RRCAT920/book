package com.huzihao.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An object of cart
 *
 * @author huzihao
 * @since 2020/10/25 14:00
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * Add shopping cart item
     *
     * @param item The item to add
     */
    public void addItem(CartItem item) {
        // 如果已有则增加商品项的数量，否则添加商品项
        var id = item.getId();
        if (items.containsKey(id)) {
            var cartItem = items.get(id);
            cartItem.setNumber(cartItem.getNumber() + 1);
            cartItem.setTotalPrice(item.getPrice().multiply(new BigDecimal(cartItem.getNumber())));
        } else items.put(id, item);
    }

    /**
     * Delete shopping cart item
     *
     * @param id The id of item which will be deleted
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * Clear all items from shopping cart
     */
    public void clear() {
        items.clear();
    }

    /**
     * Change number of item with specified id
     *
     * @param id     The id of item
     * @param number Number to change
     */
    public void updateItemNumber(Integer id, Integer number) {
        // 检查购物车中是否有该商品
        if (items.containsKey(id)) {
            var cartItem = items.get(id);
            cartItem.setNumber(number);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getNumber())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalNumber=" + getTotalNumber() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalNumber() {
        return items.values().stream()
                .map(CartItem::getNumber)
                .reduce(0, Integer::sum);
    }

    public BigDecimal getTotalPrice() {
        return items.values().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.valueOf(0L), BigDecimal::add);
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
