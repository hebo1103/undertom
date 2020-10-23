package com.example.demo.designpatterns.apiImpl.factorymethod;

import com.example.demo.designpatterns.api.factorymethod.Fruit;

/**
 * @author HB
 * @data 2020/10/13 14:16
 * @Description: 控制层
 */
public class Banana implements Fruit {
    @Override
    public void get() {
        System.out.println("吃香蕉");
    }
}
