package com.example.demo.designpatterns.apiImpl.abstractfactory;

import com.example.demo.designpatterns.api.abstractfactory.AppleA;

/**
 * @author HB
 * @data 2020/10/13 14:41
 * @Description: 控制层
 */
public class EnglandAppleA extends AppleA {
    @Override
    public void get() {
        System.out.println("英国的苹果...");
    }
}
