package com.example.demo.designpatterns.apiImpl.observer;

import com.example.demo.designpatterns.api.observer.Observer;

/**
 * @author HB
 * @data 2020/10/13 13:52
 * @Description: 控制层
 */
public class User implements Observer {
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
