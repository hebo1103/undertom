package com.example.demo.designpatterns.apiImpl.abstractfactory;

import com.example.demo.designpatterns.api.abstractfactory.FruitA;
import com.example.demo.designpatterns.api.abstractfactory.FruitFactoryA;

/**
 * @author HB
 * @data 2020/10/13 14:38
 * @Description: 控制层
 */
public class ChinaFactoryA implements FruitFactoryA {
    @Override
    public FruitA getApple() {
        return new ChinaAppleA();
    }

    @Override
    public FruitA getBanana() {
        return null;
    }
}
