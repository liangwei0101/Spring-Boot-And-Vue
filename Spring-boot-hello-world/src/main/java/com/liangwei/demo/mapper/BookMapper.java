package com.liangwei.demo.mapper;

import com.liangwei.demo.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert({"insert into book(id, name,  price) values(#{id}, #{name}, #{price})"})
    void addBook(Book book);

    @Delete("delete from book where id=#{id}")
    void delBookById(@Param("id") int id);

    @Update("update book set name = #{name}, price = #{price} where id = #{id}")
    void updateBookById(@Param("name") String name, @Param("price") float price, @Param("id") int id);

    @Select("select * from book")
    List<Book> getBook();
}
