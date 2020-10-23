package com.huzihao.dao;

import com.huzihao.pojo.Book;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/23 20:06
 */
public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();
}
