package com.liangwei.demo.service;

import com.liangwei.demo.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void delBookById(int id);

    void updateBookById(Book book);

    List<Book> getBook();
}
