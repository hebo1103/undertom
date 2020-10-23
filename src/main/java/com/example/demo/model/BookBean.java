package com.example.demo.model;

/**
 * @author HB
 * @data 2020/9/24 13:53
 * @Description: 控制层
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "book", type = "_doc")
@Data
public class BookBean {
    @Id
    private Long id;

    private long title;

    private Integer author;

    private Date postDate;

    private String name;

    private int age;

    private int money;

    public BookBean() {
    }

    public BookBean(Long id, long title, Integer author, Date postDate, String name, int age,int money) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.postDate = postDate;
        this.name = name;
        this.age = age;
        this.money = money;
    }
}
