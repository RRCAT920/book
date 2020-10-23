package com.huzihao.pojo;

import java.util.List;

/**
 * 分页模型
 *
 * @param <T> 分页的对象
 * @author huzihao
 * @since 2020/10/23 22:24
 */
public class Page<T> {
    public static final int PAGE_SIZE = 4;

    /**
     * 当前页码
     */
    private Integer number;
    /**
     * 总页码
     */
    private Integer totalNumber;
    /**
     * 页大小
     */
    private Integer size = PAGE_SIZE;
    /**
     * 总记录数
     */
    private Integer totalRecordsNumber;
    /**
     * 页数据
     */
    private List<T> items;

    @Override
    public String toString() {
        return "Page{" +
                "number=" + number +
                ", totalNumber=" + totalNumber +
                ", size=" + size +
                ", totalRecordsNumber=" + totalRecordsNumber +
                ", items=" + items +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalRecordsNumber() {
        return totalRecordsNumber;
    }

    public void setTotalRecordsNumber(Integer totalRecordsNumber) {
        this.totalRecordsNumber = totalRecordsNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}