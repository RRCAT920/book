package com.huzihao.dao.impl;

import com.huzihao.dao.BaseDao;
import com.huzihao.dao.BookDao;
import com.huzihao.pojo.Book;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/23 20:08
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        var sql = """
                insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`)
                values(?, ?, ?, ?, ?, ?)
                """;
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        var sql = """
                delete from t_book
                where id = ?
                """;
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        var sql = """
                update t_book
                set `name` = ?, author = ?, price = ?, sales = ?, stock = ?, img_path = ?
                where id = ?
                """;
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        var sql = """
                select `id`, `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath
                from t_book
                where `id` = ?
                """;
        return get(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        var sql = """
                select `id`, `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath
                from t_book
                """;
        return getList(Book.class, sql);
    }
}
