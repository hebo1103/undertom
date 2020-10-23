package com.example.demo.designpatterns.api.abstractfactory;

import com.example.demo.designpatterns.api.factorymethod.Fruit;

/**
 * @author HB
 * @data 2020/10/13 14:37
 * @Description: 控制层
 */
public interface FruitFactoryA {
    //实例化苹果
    public FruitA getApple();
    //实例化香蕉
    public FruitA getBanana();
}
