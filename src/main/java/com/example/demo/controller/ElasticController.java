package com.example.demo.controller;

import com.example.demo.model.BookBean;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author HB
 * @data 2020/9/24 13:57
 * @Description: 控制层
 */
@RestController
public class ElasticController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book/{id}")
    @ResponseBody
    public BookBean getBookById(@PathVariable String id) {
        Optional<BookBean> opt = bookService.findById(id);
        BookBean book = opt.get();
        System.out.println(book);
        return book;
    }

    @RequestMapping("/save/{title}")
    @ResponseBody
    public BookBean Save(@PathVariable("title") Long title) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date(1600930123657L));
        System.out.println("日期为：" + date);
        Long id = System.currentTimeMillis();
        BookBean book = new BookBean(id, title, 12, new Date(), "安鹏", 18, 100);
        System.out.println(book);
        return bookService.save(book);
    }

    @RequestMapping("/books")
    @ResponseBody
    public BookBean books() throws IOException {
        bookService.findByPage();
        return null;
    }
}
