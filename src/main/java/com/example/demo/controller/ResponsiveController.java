package com.example.demo.controller;

import com.example.demo.model.MyObservable;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author HB
 * @data 2020/9/16 10:36
 * @Description: 响应式编程控制层
 */
public class ResponsiveController {

    public static void main(String[] args){
        //可观察对象
        MyObservable observable = new MyObservable();
        //添加观察者
        observable.addObserver((o, arg) -> {
            Util.println("观察者1处理事件:" + arg.toString());
        });

        observable.addObserver((o, arg) -> {
            Util.println("观察者2处理事件:" + arg.toString());
        });

        observable.addObserver((o, arg) -> {
            Util.println("观察者3处理事件:" + arg.toString());
        });
        //发布事件通知观察者
        observable.setChanged();
        observable.notifyObservers(observable.getParam());
    }

}
