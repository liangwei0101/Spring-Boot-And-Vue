package com.liangwei.demo.controller;

import com.liangwei.demo.model.Book;
import com.liangwei.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api("图书api")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("查询书本的信息")
    @RequestMapping(value ="/book", method = RequestMethod.GET)
    public List<Book> BookQry() {
        return bookService.getBook();
    }

    @ApiOperation("增加书本信息")
    @RequestMapping(value ="/book", method = RequestMethod.POST)
    public void BookAdd(Book book){
        bookService.addBook(book);
    }

    @ApiOperation("修改书本信息")
    @RequestMapping(value ="/book", method = RequestMethod.PUT)
    public void BookUpdate(Book book){
        bookService.updateBookById(book);
    }

    @ApiOperation("删除书本信息")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @RequestMapping(value ="/book", method = RequestMethod.DELETE)
    public void BookDel(@RequestParam(value="id") int id){
        bookService.delBookById(id);
    }
}
