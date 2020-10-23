package com.example.demo.designpatterns.api.observer;


/**
 * @author HB
 * @data 2020/10/13 13:42
 * @Description: 控制层
 */
public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
