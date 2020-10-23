package com.huzihao.service;

import com.huzihao.pojo.Book;
import com.huzihao.pojo.Page;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/23 20:19
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> paging(int number, int size);

    Page<Book> pagingByPrice(int number, int size, int min, int max);
}
