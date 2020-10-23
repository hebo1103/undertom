package com.example.demo.designpatterns.apiImpl.factorymethod;

import com.example.demo.designpatterns.api.factorymethod.Fruit;
import com.example.demo.designpatterns.api.factorymethod.FruitFactory;

/**
 * @author HB
 * @data 2020/10/13 14:16
 * @Description: 控制层
 */
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
