package com.huzihao.service.impl;

import com.huzihao.dao.BookDao;
import com.huzihao.dao.impl.BookDaoImpl;
import com.huzihao.pojo.Book;
import com.huzihao.pojo.Page;
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

    @Override
    public Page<Book> paging(int number, int size) {
        var page = new Page<Book>();
        page.setSize(size);

        var totalRecordsNumber = bookDao.getPageTotalRecordsNumber();
        page.setTotalRecordsNumber(totalRecordsNumber);

        int totalNumber = totalRecordsNumber / size;
        if (totalRecordsNumber % size > 0) totalNumber++;
        page.setTotalNumber(totalNumber);

        // 最佳实践：凡是有数据检查的setter，下次获取值调用getter
        page.setNumber(number);

        var items = bookDao.getPageItems((page.getNumber() - 1) * size, size);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pagingByPrice(int number, int size, int min, int max) {
        var page = new Page<Book>();
        page.setSize(size);

        var totalRecordsNumber = bookDao.getPageTotalRecordsNumber(min, max);
        page.setTotalRecordsNumber(totalRecordsNumber);

        int totalNumber = totalRecordsNumber / size;
        if (totalRecordsNumber % size > 0) totalNumber++;
        page.setTotalNumber(totalNumber);

        // 最佳实践：凡是有数据检查的setter，下次获取值调用getter
        page.setNumber(number);

        var items = bookDao.getPageItemsByPrice((page.getNumber() - 1) * size, size, min, max);
        page.setItems(items);
        return page;
    }
}
