package com.example.demo.model;

import java.util.Observable;

/**
 * @author HB
 * @data 2020/9/16 10:38
 * @Description: 控制层
 */
public class MyObservable extends Observable {

    @Override
    public void setChanged() {
        super.setChanged();
    }

    public String getParam() {
        return "这个是一个响应式编程实例";
    }
}
