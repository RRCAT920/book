package com.huzihao.service.impl;

import com.huzihao.dao.BookDao;
import com.huzihao.dao.impl.BookDaoImpl;
import com.huzihao.pojo.Book;
import com.huzihao.service.BookService;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/23 20:20
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
