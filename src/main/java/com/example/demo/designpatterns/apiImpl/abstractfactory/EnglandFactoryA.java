package com.example.demo.designpatterns.apiImpl.abstractfactory;

import com.example.demo.designpatterns.api.abstractfactory.FruitA;
import com.example.demo.designpatterns.api.abstractfactory.FruitFactoryA;

/**
 * @author HB
 * @data 2020/10/13 14:40
 * @Description: 控制层
 */
public class EnglandFactoryA implements FruitFactoryA {
    @Override
    public FruitA getApple() {
        return new EnglandAppleA();
    }

    @Override
    public FruitA getBanana() {
        return null;
    }
}
