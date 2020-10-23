package com.example.demo.designpatterns.apiImpl.factorymethod;

import com.example.demo.designpatterns.api.factorymethod.Fruit;

/**
 * @author HB
 * @data 2020/10/13 14:14
 * @Description: 控制层
 */
public class Apple implements Fruit {
    @Override
    public void get() {
        System.out.println("吃苹果");
    }
}
