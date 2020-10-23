package com.huzihao.dao;

import com.huzihao.dao.impl.BookDaoImpl;
import com.huzihao.pojo.Book;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/23 20:14
 */
public class BookDaoTest {
    private static final BookDao dao = new BookDaoImpl();

    @Test
    public void addBook() {
        dao.addBook(new Book(null, "十万个为什么", "佚名", BigDecimal.valueOf(20.9),
                10000, 0, null));
    }

    @Test
    public void deleteBookById() {
        dao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        dao.updateBook(new Book(21, "动物世界", "佚名", BigDecimal.valueOf(20.9),
                10000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(dao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        dao.queryBooks().forEach(System.out::println);
    }
}