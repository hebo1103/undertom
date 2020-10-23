package com.example.demo.designpatterns.apiImpl.observer;

import com.example.demo.designpatterns.api.observer.Observer;
import com.example.demo.designpatterns.api.observer.Observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HB
 * @data 2020/10/13 13:49
 * @Description: 控制层
 */
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

}
