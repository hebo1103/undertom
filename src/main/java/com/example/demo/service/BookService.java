package com.example.demo.service;

import com.example.demo.model.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author HB
 * @data 2020/9/24 13:55
 * @Description: 控制层
 */
public interface BookService {

    Optional<BookBean> findById(String id);

    BookBean save(BookBean blog);

    void delete(BookBean blog);

    Optional<BookBean> findOne(String id);

    List<BookBean> findAll();

    Page<BookBean> findByAuthor(String author, PageRequest pageRequest);

    Page<BookBean> findByTitle(String title, PageRequest pageRequest);

    List<BookBean> findByPage() throws IOException;
}
