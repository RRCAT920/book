package com.huzihao.service;

import com.huzihao.pojo.Book;
import com.huzihao.pojo.Page;
import com.huzihao.service.impl.BookServiceImpl;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/23 20:21
 */
public class BookServiceTest {
    private static final BookService SERVICE = new BookServiceImpl();

    @Test
    public void addBook() {
        SERVICE.addBook(new Book(null, "十万个为什么", "佚名", BigDecimal.valueOf(20.9),
                10000, 0, null));
    }

    @Test
    public void deleteBookById() {
        SERVICE.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        SERVICE.updateBook(new Book(22, "动物世界", "佚名", BigDecimal.valueOf(20.9),
                10000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(SERVICE.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        SERVICE.queryBooks().forEach(System.out::println);
    }

    @Test
    public void paging() {
        System.out.println(SERVICE.paging(1, Page.PAGE_SIZE));
    }
}