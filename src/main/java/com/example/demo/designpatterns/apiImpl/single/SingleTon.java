package com.example.demo.designpatterns.apiImpl.single;

/**
 * @author HB
 * @data 2020/9/22 19:02
 * @Description: 单例模式之懒汉式
 */
public class SingleTon {

    private volatile static SingleTon singleTon = null;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
